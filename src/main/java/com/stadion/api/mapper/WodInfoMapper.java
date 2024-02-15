package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodParticipantLinkInfo;

@Mapper
public interface WodInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodInfo getWodInfo(long idx);
	public List<WodInfo> getWodInfoAll();
	

}
