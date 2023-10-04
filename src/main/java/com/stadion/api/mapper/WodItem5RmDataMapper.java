package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItem5RmData;

@Mapper
public interface WodItem5RmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItem5RmData getWodItem5RmData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodItem5RmData getWodItem5RmDataByEmail(String emailAddress);
	    

}
