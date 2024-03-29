package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.MovementRecordData;

@Mapper
public interface MovementInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MovementInfo getMovementInfo(long idx);
	public List<MovementInfo> getMovementInfoAll();
	
}
