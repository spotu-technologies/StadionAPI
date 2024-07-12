package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.entity.WodBoxLinkInfoName;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.entity.WodRecordInfoWithBox;

@Mapper
public interface WodParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodParticipantLinkInfo getWodParticipantLinkInfo(long idx);
	public long getwodParticipantLinkInfoAttend(long accountIdx);
	public long getwodParticipantLinkInfoNoAttend(long accountIdx) ;
	public long getwodParticipantCount(long idx);
	public long getwodParticipantIdx(@Param ("accountIdx")long accountIdx, @Param ("wbLinkIdx") long wbLinkIdx);
	public long getWodParticipantCountByAccount(@Param ("accountIdx")long accountIdx, @Param ("wodIdx") long wodIdx);
	
	public long getwodParticipantReserved(@Param ("idx") long idx, @Param ("accountIdx") long accountIdx);
	public long getwodParticipantStatus(@Param ("idx") long idx, @Param ("accountIdx") long accountIdx);
	public long insertWodParticipantLinkInfo(WodParticipantLinkInfo arg);
	public long cancelWodParticipantLinkInfo(long idx);
	public long reserveWodParticipantLinkInfo(long idx);
	public long getWodParticipantAttend(long idx);
	public WodBoxLinkInfoName getwodParticipantRecent(long accountIdx);

}
