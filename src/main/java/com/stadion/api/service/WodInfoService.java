package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.mapper.WodInfoMapper;


@Service
public class WodInfoService {
	@Autowired
	private WodInfoMapper wodInfoMapper;
	
	public List<WodInfo> getWodInfoClass(String progressDate, long orderNo) {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfo> wodInfoList = wodInfoMapper.getWodInfoClass(progressDate, orderNo);
		
		return wodInfoList;
	}
	
	public WodInfo getWodInfo(long idx) {
		if(wodInfoMapper==null) {return null;}
		
		WodInfo wodInfo = wodInfoMapper.getWodInfo(idx);
		
		return wodInfo;
	}
	
}
