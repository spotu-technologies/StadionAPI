package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.LevelData;
import com.stadion.api.mapper.LevelDataMapper;


@Service
public class LevelDataService {
	@Autowired
	private LevelDataMapper levelDataMapper;
	
	
	public LevelData getLevelData(int idx) {
		if(levelDataMapper==null) {return null;}
		
		LevelData levelData = levelDataMapper.getLevelData(idx);
		
		return levelData;
	}
	
}
