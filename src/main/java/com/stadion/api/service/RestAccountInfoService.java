package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.RestAccountInfo;
import com.stadion.api.mapper.RestAccountInfoMapper;


@Service
public class RestAccountInfoService {
	@Autowired
	private RestAccountInfoMapper restAccountInfoMapper;
	
	
	public RestAccountInfo getRestAccountInfo(String userId) {
		if(restAccountInfoMapper==null) {return null;}
		
		RestAccountInfo restAccountInfo = restAccountInfoMapper.getRestAccountInfo(userId);
		
		return restAccountInfo;
	}
	public RestAccountInfo getRestAccountInfoByEmail(String emailAddress) {
		if(restAccountInfoMapper==null) {return null;}
		
		RestAccountInfo restAccountInfo = restAccountInfoMapper.getRestAccountInfoByEmail(emailAddress);
		
		return restAccountInfo;
	}

}
