package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodRoundItemInfo;

@Mapper
public interface WodRoundItemInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodRoundItemInfo getWodRoundItemInfo(int idx);
	
}
