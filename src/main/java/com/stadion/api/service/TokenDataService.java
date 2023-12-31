package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.TokenData;
import com.stadion.api.mapper.TokenDataMapper;


@Service
public class TokenDataService {
	@Autowired
	private TokenDataMapper tokenDataMapper;
	
	
	public TokenData getTokenData(long idx) {
		if(tokenDataMapper==null) {return null;}
		
		TokenData tokenData =tokenDataMapper.getTokenData(idx);
		
		return tokenData;
	}
	
}
