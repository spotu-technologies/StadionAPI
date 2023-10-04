package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodRoundInfo;
import com.stadion.api.mapper.WodRoundInfoMapper;


@Service
public class WodRoundInfoService {
	@Autowired
	private WodRoundInfoMapper wodRoundInfoMapper;
	
	
	public WodRoundInfo getWodRoundInfo(String userId) {
		if(wodRoundInfoMapper==null) {return null;}
		
		WodRoundInfo wodRoundInfo = wodRoundInfoMapper.getWodRoundInfo(userId);
		
		return wodRoundInfo;
	}
	public WodRoundInfo getWodRoundInfoByEmail(String emailAddress) {
		if(wodRoundInfoMapper==null) {return null;}
		
		WodRoundInfo wodRoundInfo = wodRoundInfoMapper.getWodRoundInfoByEmail(emailAddress);
		
		return wodRoundInfo;
	}

}
