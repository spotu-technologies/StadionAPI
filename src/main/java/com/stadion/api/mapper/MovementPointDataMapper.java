package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementPointData;

@Mapper
public interface MovementPointDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MovementPointData getMovementPointData(long idx);
	
}
