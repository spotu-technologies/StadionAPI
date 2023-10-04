package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodRoundItemInfo;

@Mapper
public interface WodRoundItemInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodRoundItemInfo getWodRoundItemInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodRoundItemInfo getWodRoundItemInfoByEmail(String emailAddress);
	    

}
