package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodInfo;

@Mapper
public interface WodInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodInfo getWodInfo(long idx);
	

}
