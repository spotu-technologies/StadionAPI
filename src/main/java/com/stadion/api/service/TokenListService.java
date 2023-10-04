package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.TokenList;
import com.stadion.api.mapper.TokenListMapper;


@Service
public class TokenListService {
	@Autowired
	private TokenListMapper tokenListMapper;
	
	
	public TokenList getTokenList(String userId) {
		if(tokenListMapper==null) {return null;}
		
		TokenList tokenList = tokenListMapper.getTokenList(userId);
		
		return tokenList;
	}
	public TokenList getTokenListByEmail(String emailAddress) {
		if(tokenListMapper==null) {return null;}
		
		TokenList tokenList = tokenListMapper.getTokenListByEmail(emailAddress);
		
		return tokenList;
	}

}
