package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItemOneRmData;

@Mapper
public interface WodItemOneRmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemOneRmData getWodItemOneRmData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodItemOneRmData getWodItemOneRmDataByEmail(String emailAddress);
	    

}
