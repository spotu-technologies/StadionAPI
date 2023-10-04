package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.mapper.CategoryInfoMapper;


@Service
public class CategoryInfoService {
	@Autowired
	private CategoryInfoMapper categoryInfoMapper;
	
	
	public CategoryInfo getCategoryInfo(int idx) {
		if(categoryInfoMapper==null) {return null;}
		
		CategoryInfo categoryInfo = categoryInfoMapper.getCategoryInfo(idx);
		
		return categoryInfo;
	}
	
}
