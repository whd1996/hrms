package com.xpu.hrms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xpu.hrms.entity.DbDepartment;
import com.xpu.hrms.entity.DbInterviewee;
import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.entity.DbUser;
import com.xpu.hrms.service.DepartmentService;
import com.xpu.hrms.service.IntervieweeService;
import com.xpu.hrms.service.StaffService;
import com.xpu.hrms.service.UserService;
import com.xpu.hrms.utils.CookieUtils;
import com.xpu.hrms.utils.MD5Utils;
import com.xpu.hrms.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	StaffService staffdao;
	@Autowired
	DepartmentService dpdao;
	@Autowired
	IntervieweeService interviewdao;

	/**
	 * 用户列表
	 */
	@ResponseBody
	@RequestMapping(value = "listUser", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request, HttpServletResponse response) {
		List<HashMap<String, String>> list = this.userservice.listUser();
		return JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 用户权限管理 查询 员工职位和权限
	 */
	@RequestMapping(value = "listUserRole", method = RequestMethod.POST)
	@ResponseBody
	public String listUserRole(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, String>> list = this.userservice.listUserRole();
		return JSON.toJSONString(list);
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "listUserByDepartment", method = RequestMethod.GET)
	 * public String listUserByDepartment(HttpServletRequest request,
	 * HttpServletResponse response) { DbStaff staff = (DbStaff)
	 * request.getSession().getAttribute("staff"); if (staff != null) {
	 * 
	 * String dep = staff.getStaff_department();
	 * 
	 * // System.out.println(dep + "---------------"); List<DbUser> list =
	 * this.userservice.listUserByDepartment(dep); return JSON.toJSONString(list); }
	 * return "没查到"; }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "listUserByZhuGuan", method = RequestMethod.GET)
	 * public String listUserByZhuGuan(HttpServletRequest request,
	 * HttpServletResponse response) { DbStaff staff = (DbStaff)
	 * request.getSession().getAttribute("staff"); //
	 * System.out.println(staff.getStaff_department() + "主管查询--------------" + //
	 * staff.getName()); List<DbUser> list = userservice.listUserByZhuGuan(staff);
	 * 
	 * return JSON.toJSONString(list); }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "listUserByUserId", method = RequestMethod.GET)
	 * public String listStaffByUserId(HttpServletRequest request,
	 * HttpServletResponse response) { DbUser user = (DbUser)
	 * request.getSession().getAttribute("user"); List<DbUser> list = new
	 * ArrayList<DbUser>(); // System.out.println("用户查询--------------" + user); if
	 * (user != null) { list.add(user); return JSON.toJSONString(list); } return
	 * "没查到"; }
	 */

	/**
	 * 添加用户
	 */
	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addUser(@RequestBody DbUser user, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> result = new HashMap<>();
		// 查看用户账号 是否已经被注册 如果已经被注册 返回 账号已被注册
		int usercount = this.userservice.selectUserByUserAccount(user);
		if (usercount > 0) {
			result.put("msg", "该账号已被注册");
			return JSON.toJSONString(result);
		} else {
			user.setUser_password(MD5Utils.getMD5(user.getUser_password()));
			if (user.getId() == null)// 如果没传id 才新建id
				user.setId(UUIDUtil.createUUID());
			int count = this.userservice.addUser(user);
			// 查看是否该账号已有面试者
			DbInterviewee interviewee = interviewdao.selectIntervieweeById(user.getId());
			if (interviewee != null)
				return JSON.toJSONString("面试者") + interviewee.getName() + "已存在";
			else {// 如果是新注册账号 即为内推账号 不用参加笔试 直接参加面试 但无期望部门和职位
				DbInterviewee interview = new DbInterviewee();
				interview.setName(user.getStaff_name());
				interview.setId(user.getId());
				interview.setWork_experience("公司内推员工");
				interviewdao.addInterviewee(interview);
			}
			// 新注册用户 需要通过面试并且办理入职后才能成为正式员工
			if (count > 0)
				result.put("msg", "添加成功");
			else
				result.put("msg", "添加失败");
		}

		return JSON.toJSONString(result);
	}

	/**
	 * 修改用户
	 */
	@ResponseBody
	@RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String updateUser(@RequestBody DbUser user, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> reslut = new HashMap<>();
		user.setUser_password(MD5Utils.getMD5(user.getUser_password()));
		DbStaff staff = staffdao.selectStaffById(user.getId());
		if (staff != null) {// 如果有该 id员工 同步修改
			staff.setName(user.getStaff_name());
			staffdao.updateStaff(staff);
		}
		if (this.userservice.updateUser(user)) {
			reslut.put("msg", "用户修改成功");
		} else {
			reslut.put("msg", "用户修改失败");
		}
		return JSON.toJSONString(reslut);
	}

	/**
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "deleteUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String deleteUser(@RequestBody DbUser user, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> reslut = new HashMap<>();
		int count = this.userservice.deleteUser(user);
		DbStaff deleteStaff = staffdao.selectStaffById(user.getId());
		if (deleteStaff != null) {// 如果这个账号是已入职员工
			deleteStaff.setLeave_time(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()).toString());
			int countDeleteStaff = staffdao.deleteStaff(deleteStaff);
			if (count > 0 && countDeleteStaff > 0) {
				reslut.put("msg", "删除成功");
			} else {
				reslut.put("msg", "删除失败");
			}
		} else
			reslut.put("msg", "删除成功");// 仅删除了用户表
		return JSON.toJSONString(reslut);
	}

	/**
	 * 用户登陆
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String loginByUserNameAndPassword(@RequestBody DbUser user, HttpServletRequest request,
			HttpServletResponse response) {
		String oldpwd = user.getUser_password();
		user.setUser_password(MD5Utils.getMD5(oldpwd));
		DbUser loginuser = this.userservice.loginByUserNameAndPassword(user);
		Map<String, String> reslut = new HashMap<>();
		if (loginuser != null) {
			DbStaff staff = staffdao.selectStaffById(loginuser.getId());
			DbDepartment dp = null;
			if (staff != null) {
				if (staff.getStaff_department() == null)
					staff.setStaff_department("暂无部门");
				dp = dpdao.selectDepartmentById(staff.getStaff_department());// 查询部门名

			}
			// System.out.println(loginuser.getId() + "---------------");
			switch (loginuser.getRole_id()) {
			case 3:
				reslut.put("msg", "总经理登录成功");
				reslut.put("role", "3");
				reslut.put("user_account", "总经理");
				break;
			case 2:
				reslut.put("msg", "经理登录成功");
				reslut.put("role", "2");

				reslut.put("department", dp.getDepartment_name());
				reslut.put("user_account", user.getUser_account());
				break;
			case 1:
				reslut.put("msg", "主管登录成功");
				reslut.put("role", "1");
				reslut.put("department", dp.getDepartment_name());
				reslut.put("user_account", user.getUser_account());
				break;
			case 0:
				reslut.put("msg", "员工登录成功");
				reslut.put("role", "0");
				if (staff != null) {
					reslut.put("uid", staff.getId());
					reslut.put("department", dp.getDepartment_name());
					reslut.put("user_account", user.getUser_account());
				} else
					reslut.put("department", "未入职");
				break;
			default:
				reslut.put("msg", "查无此人");
				break;
			}
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			// 从数据库获取用户信息放到session
			session.setAttribute("user", loginuser);
			session.setAttribute("staff", staff);
			if (user.getId() != null)
				CookieUtils.setCookie(request, response, //
						"userlogininfo", String.format("%s:%s", user.getUser_account(), oldpwd), 7 * 24 * 60 * 60);
			else
				CookieUtils.deleteCookie(request, response, "userlogininfo");
		} else
			reslut.put("msg", "登录失败");
		return JSON.toJSONString(reslut);
	}

	/**
	 * 用户注册
	 */
	@ResponseBody
	@RequestMapping(value = "regist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String regit(@RequestBody DbUser user, HttpServletRequest request, HttpServletResponse response) {

		return addUser(user, request, response);
	}

	/**
	 * 用户修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "foundPwd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String foundPwd(@RequestBody DbUser user, HttpServletRequest request, HttpServletResponse response) {

		String msg;
		boolean success = false;
		//System.out.println(user);
		// 查询数据库中的员工是否存在
		DbUser dbUser = userservice.selectUserByUserAccountInfo(user);
		if (dbUser == null)
			return JSON.toJSONString("公司无此员工");
		// 对密码加密
		user.setUser_password(MD5Utils.getMD5(user.getUser_password()));
		System.out.println(user);
		success = userservice.updateUserPwd(user);
		if (success == true)
			msg = "修改成功";
		else
			msg = "修改失败";

		return JSON.toJSONString(msg);
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute("user");
		session.removeAttribute("isLogin");
		session.invalidate();
		return "redirect:/login.html";
	}

}
