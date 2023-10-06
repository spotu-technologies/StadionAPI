package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementRecordData;

@Mapper
public interface MovementRecordDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MovementRecordData getMovementRecordData(long idx);
	

}
