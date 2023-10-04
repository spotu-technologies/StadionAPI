package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodRoundItemInfo;
import com.stadion.api.mapper.WodRoundItemInfoMapper;


@Service
public class WodRoundItemInfoService {
	@Autowired
	private WodRoundItemInfoMapper wodRoundItemInfoMapper;
	
	
	public WodRoundItemInfo getWodRoundItemInfo(String userId) {
		if(wodRoundItemInfoMapper==null) {return null;}
		
		WodRoundItemInfo wodRoundItemInfo = wodRoundItemInfoMapper.getWodRoundItemInfo(userId);
		
		return wodRoundItemInfo;
	}
	public WodRoundItemInfo getWodRoundItemInfoByEmail(String emailAddress) {
		if(wodRoundItemInfoMapper==null) {return null;}
		
		WodRoundItemInfo wodRoundItemInfo = wodRoundItemInfoMapper.getWodRoundItemInfoByEmail(emailAddress);
		
		return wodRoundItemInfo;
	}

}
