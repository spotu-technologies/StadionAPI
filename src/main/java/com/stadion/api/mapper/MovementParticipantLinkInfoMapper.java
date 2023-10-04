package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementParticipantLinkInfo;

@Mapper
public interface MovementParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MovementParticipantLinkInfo getMovementParticipantLinkInfo(int idx);
	
}
