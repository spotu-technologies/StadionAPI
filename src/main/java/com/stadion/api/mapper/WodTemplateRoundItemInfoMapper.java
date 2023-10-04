package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodTemplateRoundItemInfo;

@Mapper
public interface WodTemplateRoundItemInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodTemplateRoundItemInfo getWodTemplateRoundItemInfo(int idx);
	 

}
