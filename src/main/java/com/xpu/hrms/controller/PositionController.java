package com.xpu.hrms.controller;

import com.alibaba.fastjson.JSON;
import com.xpu.hrms.entity.DbPosition;
import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.service.DepartmentService;
import com.xpu.hrms.service.PositionService;
import com.xpu.hrms.service.StaffService;
import com.xpu.hrms.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "position")
public class PositionController {
	@Autowired
	PositionService psDao;
	@Autowired
	DepartmentService dpDao;
	@Autowired
	StaffService staffDao;
	
	/**
	 * 职位列表
	 */
	@ResponseBody
	@RequestMapping(value = "listPosition", method = RequestMethod.GET)
	public String listPosition(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<DbPosition> list = psDao.listPosition();
		//System.out.println(list);
		return JSON.toJSONString(list);
	}
	/**
	 * 新增职位
	 */
	@ResponseBody
	@RequestMapping(value = "addPosition", method = RequestMethod.POST)
	public String addPosition(@RequestBody DbPosition dbposition, HttpServletResponse response) {
		String result;
		int coun=dpDao.selectDpPositionByPositionName(dbposition.getPosition());
		if(coun==0)
			return "无该职位";
		dbposition.setId(UUIDUtil.createUUID());
		int count  = psDao.addPosition(dbposition);
		if(count>0)
			result="success";
		else 
			result ="false";
		return result;
	}
	/**
	 * 修改职位
	 */
	@ResponseBody
	@RequestMapping(value = "updatePosition", method = RequestMethod.POST)
	public String updatePosition(@RequestBody DbPosition dbposition, HttpServletResponse response) {
		String result;
		int coun=dpDao.selectDpPositionByPositionName(dbposition.getPosition());
		if(coun==0)
			return "无该职位";
		System.out.println(dbposition);
		int count  = psDao.updatePosition(dbposition);
		if(count>0)
			result="success";
		else 
			result ="false";
		return result;
	}
	
	/**
	 * 删除职位
	 */
	@ResponseBody
	@RequestMapping(value = "deletePosition", method = RequestMethod.POST)
	public String deletePosition(@RequestBody DbPosition dbposition, HttpServletResponse response) {
		String result;
		System.out.println(dbposition);
		ArrayList<DbStaff> staffList= staffDao.selectStaffByPositionInfo(dbposition.getPosition(), dbposition.getPosition_level());
		System.out.println(staffList);
		if(!staffList.isEmpty())
			return "该职位职级仍有员工，禁止删除";
		int count  = psDao.deletePosition(dbposition.getId());
		if(count>0)
			result="success";
		else 
			result ="false";
		return result;
	}
	
}
