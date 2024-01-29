package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.mapper.CategoryInfoMapper;


@Service
public class CategoryInfoService {
	@Autowired
	private CategoryInfoMapper categoryInfoMapper;
	
	public List<CategoryInfo> getCategoryInfoName(long tableLinkIdx, long depth) {
		if(categoryInfoMapper==null) {return null;}
		
		List<CategoryInfo> categoryInfoList = categoryInfoMapper.getCategoryInfoName(tableLinkIdx, depth);
		
		return categoryInfoList;
	}

	
	public CategoryInfo getCategoryInfo(long idx) {
		if(categoryInfoMapper==null) {return null;}
		
		CategoryInfo categoryInfo = categoryInfoMapper.getCategoryInfo(idx);
		
		return categoryInfo;
	}
	
}
