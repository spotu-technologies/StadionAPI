package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItem5RmData;

@Mapper
public interface WodItem5RmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItem5RmData getWodItem5RmData(long idx);
	

}
