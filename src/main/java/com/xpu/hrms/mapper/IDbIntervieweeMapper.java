package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbInterviewee;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDbIntervieweeMapper {
	ArrayList<DbInterviewee> listInterviewee();

	ArrayList<HashMap<String, String>> listIntervieweeInfo();

	DbInterviewee selectIntervieweeById(String id);

	int deleteInterviewee(String id);

	int addInterviewee(DbInterviewee interviewee);

}
