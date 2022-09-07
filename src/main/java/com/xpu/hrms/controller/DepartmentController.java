package com.xpu.hrms.controller;


import com.alibaba.fastjson.JSON;
import com.xpu.hrms.entity.DbDepartment;
import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.service.DepartmentService;
import com.xpu.hrms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="dept")
public class DepartmentController {
	@Autowired
	DepartmentService deptservice;
	@Autowired
	StaffService staffdao;
	
	/**
	 * 部门列表
	 */
	@ResponseBody
	@RequestMapping(value = "listDepartment", method = RequestMethod.GET)
	public String listDepartment(HttpServletRequest request, HttpServletResponse response) {
		List<DbDepartment> list = this.deptservice.listDepartment();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 添加部门
	 */
	@ResponseBody
	@RequestMapping(value = "addDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String addDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response){
		
		Map<String ,String> reslut = new HashMap<>();
		DbDepartment dpinfo = deptservice.selectDpByPAndDP(dept.getDepartment_name(), dept.getPosition());
		if(dpinfo!=null)
			return JSON.toJSONString("该部门信息已存在！");
		int count = this.deptservice.addDepartment(dept);
		if(count>0)
			reslut.put("msg", "添加成功");
		else 
			reslut.put("msg", "添加失败");
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 修改部门
	 */
	@ResponseBody
	@RequestMapping(value = "updateDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response) {
		boolean succeed = this.deptservice.updateDepartment(dept);
		Map<String ,String> reslut = new HashMap<>();
		//int i=0;
		if(succeed) {
			reslut.put("msg", "部门修改成功");
			
		}else{
			reslut.put("msg", "部门修改失败");
			//i=1;
		}
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 删除部门
	 */
	@ResponseBody
	@RequestMapping(value = "deleteDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String deleteDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response) {
		Map<String ,String> reslut = new HashMap<>();
		System.out.println(dept);
		String dpname = dept.getDepartment_name();//部门名
		String pname = dept.getPosition();//职位名
		
		LinkedList<DbStaff>  dpList=staffdao.selectStaffByDeptInfo(dpname,pname);
		System.out.println(dpList);
		if(!dpList.isEmpty()){//如果还有软工在该职位
			reslut.put("msg", "该部门此职位还有员工,无法删除");
			return JSON.toJSONString(reslut);
		}
		int count = this.deptservice.deleteDepartment(dept);
		if(count>0)
		{
			reslut.put("msg", "删除成功");
		}else {
			reslut.put("msg", "删除失败");
		}
		return JSON.toJSONString(reslut);
	}
}
