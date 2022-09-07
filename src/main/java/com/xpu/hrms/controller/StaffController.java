package com.xpu.hrms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xpu.hrms.entity.DbDepartment;
import com.xpu.hrms.entity.DbPosition;
import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.entity.DbUser;
import com.xpu.hrms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "staff")
public class StaffController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private UserService userdao;
	@Autowired
	private IntervieweeService interviewDao;
	@Autowired
	private PositionService pDao;
	@Autowired
	private DepartmentService dpDao;

	/**
	 * 查询员工列表（有分页）
	 */
	@ResponseBody
	@RequestMapping(value = "listStaff", method = RequestMethod.GET)
	public String listStaff(HttpServletRequest request, HttpServletResponse response) {
		List<HashMap<String, String>> staffList = this.staffService.listStaff();

		// 该方法可以把日期不转换为时间戳 按自己格式转化
		return JSON.toJSONStringWithDateFormat(staffList, "yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 查询人才库信息（有分页）
	 */
	@ResponseBody
	@RequestMapping(value = "listStaffData", method = RequestMethod.GET)
	public String listStaffData(HttpServletRequest request, HttpServletResponse response) {

		List<HashMap<String, String>> staffList = this.staffService.listStaffData();
		return JSON.toJSONStringWithDateFormat(staffList, "yyyy-MM-dd HH:mm:ss",
				SerializerFeature.WriteDateUseDateFormat);
	}

	// 员工面试 在user表中但不在staff表中的 主键 id即为还未入职待面试的员工
	@ResponseBody
	@RequestMapping(value = "listUserForAddStaff", method = RequestMethod.GET)
	public String listUserForAddStaff(HttpServletRequest request, HttpServletResponse response) {

		List<DbUser> staffList = this.userdao.listUserForAddStaff();
		// System.out.println("---待面试员工---\n");
		// System.out.println(staffList);

		return JSON.toJSONString(staffList);
	}

	@ResponseBody
	@RequestMapping(value = "listStaffByUserId", method = RequestMethod.GET)
	public String listStaffByUserId(HttpServletRequest request, HttpServletResponse response) {
		DbStaff staff = (DbStaff) request.getSession().getAttribute("staff");
		List<DbStaff> staffList = new ArrayList<>();
		// System.out.println("员工查询--------------" + staff);
		if (staff != null) {
			staffList.add(staff);
			return JSON.toJSONString(staffList);
		}
		return "没查到";
	}

	@ResponseBody
	@RequestMapping(value = "listStaffByZhuGuan", method = RequestMethod.GET)
	public String listStaffByZhuGuan(HttpServletRequest request, HttpServletResponse response) {
		DbStaff staff = (DbStaff) request.getSession().getAttribute("staff");
		System.out.println(staff.getStaff_department() + "主管查询--------------" + staff.getName());
		List<DbStaff> list = staffService.listStaffByZhuGuan(staff);

		return JSON.toJSONString(list);
	}

	@ResponseBody
	@RequestMapping(value = "listStaffByDepartment", method = RequestMethod.GET)
	public String listStaffByDepartment(HttpServletRequest request, HttpServletResponse response) {
		DbStaff staff = (DbStaff) request.getSession().getAttribute("staff");
		// System.out.println(staff.getStaff_department() + "经理查询--------------" +
		// staff.getName());
		List<DbStaff> list = staffService.listStaffByDepartment(staff);

		return JSON.toJSONString(list);
	}

	/**
	 * 统计员工数量
	 */
	@ResponseBody
	@RequestMapping(value = "getStaffCount", method = RequestMethod.GET)
	public String getStaffCount() {
		// System.out.println("----------------getStaffCount--begin");
		int taffCount = this.staffService.getStaffCount();
		// System.out.println("----------------getStaffCount--end");
		return "{\"taffCount\":" + taffCount + "}";
	}

	/**
	 * 添加员工
	 */
	@ResponseBody
	@RequestMapping(value = "addStaff", method = RequestMethod.POST)
	public String addStaff(@RequestBody DbStaff staff, HttpServletRequest req) {
		// 列出需要面试的员工
		HashMap<String, String> result = new HashMap<>();
		List<DbUser> userlist = this.userdao.listUserForAddStaff();
		if (!userlist.isEmpty()) {// 如果有待面试的员工 遍历查找与用户输入一致的员工
			for (int i = 0; i < userlist.size(); i++) {
				// 遍历待入职的员工集合 找到与输入姓名一致的员工 添加入数据库staff表 id一致
				DbUser user = userlist.get(i);
				if (staff.getName().equals(user.getStaff_name())) {
					staff.setEntry_time(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()).toString());
					staff.setId(user.getId());
					String positionName = staff.getStaff_position();
					String position_level = staff.getLeave_time();// 借用的变量暂存一下职级
					String departmentName = staff.getStaff_department();

					DbPosition position = pDao.selectPositionByPositionNameAndLevel(positionName, position_level);
					DbDepartment dp = dpDao.selectDpByPAndDP(departmentName, positionName);
					// System.out.println(position + "\n" + dp);
					if (dp == null) {
						result.put("msg", "部门<" + departmentName + ">无" + positionName + "职位！");
						return JSON.toJSONString(result);
					}
					if (position == null) {
						result.put("msg", "职位<" + positionName + ">无职级:" + position_level);
						return JSON.toJSONString(result);
					}
					staff.setLeave_time(null);// 返回借用的变量
					staff.setStaff_position(position.getId());// 设置部门
					staff.setStaff_department(dp.getId());// 设置职位
					int count = staffService.addStaff(staff);// 新增员工信息
					if (count > 0) {
						int role = judgeRole(positionName);
						// 根据输入修改员工权限
						int coun = userdao.updateUserRoleById(user.getId(), role);
						if (coun > 0) {
							interviewDao.deleteInterviewee(staff.getId());
							return "true";
						}
					}
				} else
					result.put("msg", staff.getName()+"不是候选人");
			}
		} else
			result.put("msg", "入职失败！");

		return JSON.toJSONString(result);
	}

	/**
	 * 修改员工;根据ID改名字
	 * 
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStaff", method = RequestMethod.POST)
	public String updateStaff(@RequestBody DbStaff staff, HttpServletRequest request) {
		// TODO
		System.out.println("修改员工。。。");
		System.out.println(staff);
		String positionName = staff.getStaff_position();
		String position_level = staff.getLeave_time();// 借用的变量暂存一下职级
		String departmentName = staff.getStaff_department();
		int role = judgeRole(positionName);
		System.out.println(role);
		DbPosition position = pDao.selectPositionByPositionNameAndLevel(positionName, position_level);
		DbDepartment dp = dpDao.selectDpByPAndDP(departmentName, positionName);
		// System.out.println(position + "\n" + dp);
		if (dp == null)
			return "部门<" + departmentName + ">无职位：" + positionName;
		if (position == null)
			return "职位<" + departmentName + ">无职级：" + position_level;
		staff.setLeave_time(null);// 返回借用的变量
		staff.setStaff_position(position.getId());// 设置部门
		staff.setStaff_department(dp.getId());// 设置职位
		DbUser user = userdao.selectUserById(staff.getId());// 查询该员工对应的账号信息 一并修改
		if (user != null) {
			// System.out.println("正在修改用户信息：\n" + user);
			user.setRole_id(role); // 修改账户权限
			user.setStaff_name(staff.getName());
			userdao.updateUser(user);// 修改账户信息
			userdao.updateUserRoleById(user.getId(), role);//修改权限

		}

		String s = "成功修改" + this.staffService.updateStaff(staff) + "个员工";
		return s;
	}

	private int judgeRole(String staff_position) {
		int role = -1;
		if (staff_position.equals("经理"))
			role = 2;
		else if (staff_position.equals("主管"))
			role = 1;
		else
			role = 0;
		return role;
	}

	/**
	 * 删除员工
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "deleteStaff", method = RequestMethod.POST)
	public String deleteStaff(@RequestBody DbStaff staff, HttpServletRequest request) {
		String reslut;
		// System.out.println(JSON.toJSONString(staff));
		staff.setLeave_time(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()).toString());
		int count = this.staffService.deleteStaff(staff);
		// 注销员工账号
		int cou = userdao.deleteUser(userdao.selectUserById(staff.getId()));
		if (count > 0 && cou > 0)
			reslut = String.valueOf(count);
		else
			reslut = "删除失败";
		return reslut;

	}

	/**
	 * 彻底删除：删除人才库中的员工
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "deleteStaffData", method = RequestMethod.POST)
	public String deleteStaffData(@RequestBody DbStaff staff, HttpServletRequest request) {
		String reslut;

		// System.out.println("想要删除的人才库员工是"+staff);
		if (staff.getLeave_time() == null) {// 如果员工无离职时间 说明还未离职
			reslut = "-1";
		} else {
			int count = this.staffService.deleteStaffData(staff.getId());
			if (count > 0)
				reslut = String.valueOf(count);
			else
				reslut = "删除失败";
		}
		return reslut;

	}

}
