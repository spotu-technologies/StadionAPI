package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItemOneRmData;

@Mapper
public interface WodItemOneRmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemOneRmData getWodItemOneRmData(int idx);


}
