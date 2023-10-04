package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.StardionLevelData;

@Mapper
public interface StardionLevelDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public StardionLevelData getStardionLevelData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public StardionLevelData getStardionLevelDataByEmail(String emailAddress);
	    

}
