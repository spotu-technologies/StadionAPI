package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodTemplateRoundInfo;

@Mapper
public interface WodTemplateRoundInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodTemplateRoundInfo getWodTemplateRoundInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodTemplateRoundInfo getWodTemplateRoundInfoByEmail(String emailAddress);
	    

}
