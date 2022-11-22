package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbPosition;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PositionMapper {

	public ArrayList<DbPosition> listPosition();

	public int addPosition(DbPosition dbposition);

	public int deletePosition(String id);

	public int updatePosition(DbPosition dbposition);

	public DbPosition selectPositionByPositionNameAndLevel(@Param("positionName") String positionName, @Param("position_level") String position_level);

}
