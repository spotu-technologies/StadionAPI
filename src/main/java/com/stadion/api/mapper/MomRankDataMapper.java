package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomRankData;

@Mapper
public interface MomRankDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomRankData getMomRankData(int idx);
	

}
