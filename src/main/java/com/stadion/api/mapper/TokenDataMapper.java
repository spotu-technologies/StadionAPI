package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.TokenData;

@Mapper
public interface TokenDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TokenData getTokenData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public TokenData getTokenDataByEmail(String emailAddress);
	    

}
