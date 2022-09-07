package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbPosition;
import com.xpu.hrms.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PositionService {
	@Autowired
	private PositionMapper positionmapper;

	public ArrayList<DbPosition> listPosition() {

		return positionmapper.listPosition();
	}

	public int addPosition(DbPosition dbposition) {

		return positionmapper.addPosition(dbposition);
	}

	public int deletePosition(String id) {

		return positionmapper.deletePosition(id);
	}

	public int updatePosition(DbPosition dbposition) {

		return positionmapper.updatePosition(dbposition);
	}

	public DbPosition selectPositionByPositionNameAndLevel(String positionName, String position_level) {
		return positionmapper.selectPositionByPositionNameAndLevel(positionName,position_level);
	}



}
