package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemInfo;
import com.stadion.api.mapper.WodItemInfoMapper;


@Service
public class WodItemInfoService {
	@Autowired
	private WodItemInfoMapper wodItemInfoMapper;
	
	
	public WodItemInfo getWodItemInfo(int idx) {
		if(wodItemInfoMapper==null) {return null;}
		
		WodItemInfo wodItemInfo = wodItemInfoMapper.getWodItemInfo(idx);
		
		return wodItemInfo;
	}
	
}
