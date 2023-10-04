package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TokenList;

@Mapper
public interface TokenListMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TokenList getTokenList(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public TokenList getTokenListByEmail(String emailAddress);
	    

}
