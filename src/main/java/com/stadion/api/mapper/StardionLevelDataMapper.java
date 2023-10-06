package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.StardionLevelData;

@Mapper
public interface StardionLevelDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public StardionLevelData getStardionLevelData(long idx);


}
