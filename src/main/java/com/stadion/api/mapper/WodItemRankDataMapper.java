package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItemRankData;

@Mapper
public interface WodItemRankDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemRankData getWodItemRankData(long idx);
	  

}
