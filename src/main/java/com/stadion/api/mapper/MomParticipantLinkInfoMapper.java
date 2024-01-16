package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.entity.MovementRecordData;

@Mapper
public interface MomParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomParticipantLinkInfo getMomParticipantLinkInfo(long idx);
	public List<MomParticipantLinkInfo> getMomParticipantLinkInfoName(long accountIdx);

}
