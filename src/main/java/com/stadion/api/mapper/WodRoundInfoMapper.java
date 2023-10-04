package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodRoundInfo;

@Mapper
public interface WodRoundInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodRoundInfo getWodRoundInfo(int idx);
	

}
