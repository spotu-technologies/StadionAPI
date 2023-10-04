package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomParticipantLinkInfo;

@Mapper
public interface MomParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomParticipantLinkInfo getMomParticipantLinkInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public MomParticipantLinkInfo getMomParticipantLinkInfoByEmail(String emailAddress);
	    

}
