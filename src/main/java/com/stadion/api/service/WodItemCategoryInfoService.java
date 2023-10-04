package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemCategoryInfo;
import com.stadion.api.mapper.WodItemCategoryInfoMapper;


@Service
public class WodItemCategoryInfoService {
	@Autowired
	private WodItemCategoryInfoMapper wodItemCategoryInfoMapper;
	
	
	public WodItemCategoryInfo getWodItemCategoryInfo(String userId) {
		if(wodItemCategoryInfoMapper==null) {return null;}
		
		WodItemCategoryInfo wodItemCategoryInfo = wodItemCategoryInfoMapper.getWodItemCategoryInfo(userId);
		
		return wodItemCategoryInfo;
	}
	public WodItemCategoryInfo getWodItemCategoryInfoByEmail(String emailAddress) {
		if(wodItemCategoryInfoMapper==null) {return null;}
		
		WodItemCategoryInfo wodItemCategoryInfo = wodItemCategoryInfoMapper.getWodItemCategoryInfoByEmail(emailAddress);
		
		return wodItemCategoryInfo;
	}

}
