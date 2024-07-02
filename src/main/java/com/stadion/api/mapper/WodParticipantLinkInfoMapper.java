package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.WodParticipantLinkInfo;

@Mapper
public interface WodParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodParticipantLinkInfo getWodParticipantLinkInfo(long idx);
	public List<WodParticipantLinkInfo> getWodParticipantLinkInfoIsAttend(long accountIdx);
	public List<WodParticipantLinkInfo> getWodParticipantLinkInfoIsNonappearance(long accountIdx);
	public long getwodParticipantCount(long idx);
	public long getwodParticipantReserved(@Param ("idx") long idx, @Param ("accountIdx") long accountIdx);
	public long insertWodParticipantLinkInfo(WodParticipantLinkInfo arg);
}
