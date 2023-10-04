package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItem3RmData;

@Mapper
public interface WodItem3RmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItem3RmData getWodItem3RmData(int idx);


}
