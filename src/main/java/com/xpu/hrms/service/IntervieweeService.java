package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbInterviewee;
import com.xpu.hrms.mapper.IDbIntervieweeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class IntervieweeService {
	@Autowired
	private IDbIntervieweeMapper intervieweeMapper;

	public ArrayList<DbInterviewee> listInterviewee() {
		
		return intervieweeMapper.listInterviewee();
	}
	
	public ArrayList<HashMap<String, String>> listIntervieweeInfo() {
		
		return intervieweeMapper.listIntervieweeInfo();
	}

	public int deleteInterviewee(String id) {
		System.out.println("业务层"+id);
		return intervieweeMapper.deleteInterviewee(id);
	}

	public int addInterviewee(DbInterviewee interviewee) {
		
		return intervieweeMapper.addInterviewee(interviewee);
	}

	public DbInterviewee selectIntervieweeById(String id) {
		
		return intervieweeMapper.selectIntervieweeById(id);
	}
}
