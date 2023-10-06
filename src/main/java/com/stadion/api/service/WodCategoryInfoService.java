package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodCategoryInfo;
import com.stadion.api.mapper.WodCategoryInfoMapper;


@Service
public class WodCategoryInfoService {
	@Autowired
	private WodCategoryInfoMapper wodCategoryInfoMapper;
	
	
	public WodCategoryInfo getWodCategoryInfo(long idx) {
		if(wodCategoryInfoMapper==null) {return null;}
		
		WodCategoryInfo wodCategoryInfo = wodCategoryInfoMapper.getWodCategoryInfo(idx);
		
		return wodCategoryInfo;
	}
	
}
