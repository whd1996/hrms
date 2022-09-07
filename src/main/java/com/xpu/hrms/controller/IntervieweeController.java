package com.xpu.hrms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xpu.hrms.entity.DbInterviewee;
import com.xpu.hrms.entity.DbUser;
import com.xpu.hrms.service.IntervieweeService;
import com.xpu.hrms.service.UserService;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping(value = "interview")
public class IntervieweeController {
	@Autowired
	IntervieweeService interviewservice;
	@Autowired
	UserService userdao;

	/**
	 * 求职者列表
	 */
	@ResponseBody
	@RequestMapping(value = "listInterviewee", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<DbInterviewee> list = interviewservice.listInterviewee();
		// System.out.println(list);
		return JSON.toJSONString(list);
	}

	// 待面试列表 包含user信息与interviewee信息
	@ResponseBody
	@RequestMapping(value = "listIntervieweeInfo", method = RequestMethod.GET)
	public String listIntervieweeInfo(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HashMap<String, String>> list = interviewservice.listIntervieweeInfo();
		return JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 增加面试者
	 */
	@ResponseBody
	@RequestMapping(value = "addInterviewee", method = RequestMethod.POST)
	public String addInterviewee(@RequestBody DbInterviewee interviewee, HttpServletResponse response) {
		String result;
		interviewee.setId(UUIDUtil.createUUID());
		// System.out.println(interviewee);
		int count = interviewservice.addInterviewee(interviewee);
		if (count > 0)
			result = "success";
		else
			result = "false";
		return JSON.toJSONString(count);
	}

	/**
	 * 通知参加面试
	 */
	@ResponseBody
	@RequestMapping(value = "intervieweeToUser", method = RequestMethod.POST)
	public String intervieweeToUser(@RequestBody DbInterviewee interviewee, DbUser user) {
		String result;
		// 通过笔试 通知参加面试 为面试者创建一个账号
		user.setId(interviewee.getId());
		user.setRole_id(0);
		user.setUser_password(MD5Utils.getMD5("123"));
		user.setUser_account(interviewee.getName());
		user.setStaff_name(interviewee.getName());
		user.setCreat_time(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()).toString());
		// System.out.println("我想要注册的用户是"+user);
		DbUser dbu = userdao.selectUserById(interviewee.getId());
		if (dbu != null)
			return "通知过了";
		int count = userdao.addUser(user);
		// int coun = interviewservice.deleteInterviewee(interviewee.getId());
		if (count > 0)
			result = "成功！";
		else
			result = "失败！";
		return JSON.toJSONString(result);
	}

	/**
	 * 初选 在笔试中删除求职者
	 */
	@ResponseBody
	@RequestMapping(value = "deleteInterviewee", method = RequestMethod.POST)
	public String deleteInterviewee(@RequestBody DbInterviewee interviewee, HttpServletResponse response) {
		DbUser user = userdao.selectUserById(interviewee.getId());
		if (user != null)
			userdao.deleteUser(user);
		int count = interviewservice.deleteInterviewee(interviewee.getId());
		if (count > 0)
			return JSON.toJSONString(count);
		else
			return "删除失败";
	}

	/**
	 * 终选 在面试中中淘汰求职者
	 */
	@ResponseBody
	@RequestMapping(value = "deleteIntervieweeByBoss", method = RequestMethod.POST)
	public String deleteIntervieweeByBoss(@RequestBody DbInterviewee interviewee) {

		int count = interviewservice.deleteInterviewee(interviewee.getId());
		DbUser user = userdao.selectUserById(interviewee.getId());
		if (user != null)// 如果存在用户 一并删除
			userdao.deleteUser(user);
		if (count > 0)
			return JSON.toJSONString("淘汰成功");
		else
			return JSON.toJSONString("淘汰失败");
	}

}
