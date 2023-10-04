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
	
	
	public TokenList getTokenList(int idx) {
		if(tokenListMapper==null) {return null;}
		
		TokenList tokenList = tokenListMapper.getTokenList(idx);
		
		return tokenList;
	}
	
}
