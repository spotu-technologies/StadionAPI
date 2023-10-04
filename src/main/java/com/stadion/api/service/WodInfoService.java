package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodInfo;
import com.stadion.api.mapper.WodInfoMapper;


@Service
public class WodInfoService {
	@Autowired
	private WodInfoMapper wodInfoMapper;
	
	
	public WodInfo getWodInfo(String userId) {
		if(wodInfoMapper==null) {return null;}
		
		WodInfo wodInfo = wodInfoMapper.getWodInfo(userId);
		
		return wodInfo;
	}
	public WodInfo getWodInfoByEmail(String emailAddress) {
		if(wodInfoMapper==null) {return null;}
		
		WodInfo wodInfo = wodInfoMapper.getWodInfoByEmail(emailAddress);
		
		return wodInfo;
	}

}
