package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodParticipantLinkInfo;

@Mapper
public interface WodParticipantLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodParticipantLinkInfo getWodParticipantLinkInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodParticipantLinkInfo getWodParticipantLinkInfoByEmail(String emailAddress);
	    

}
