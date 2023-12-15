package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.LevelData;
import com.stadion.api.mapper.LevelDataMapper;


@Service
public class LevelDataService {
	@Autowired
	private LevelDataMapper levelDataMapper;
	
	public List<LevelData> getLevelDataLevel(long accountIdx, long longYear) {
		if(levelDataMapper==null) {return null;}
		
		List<LevelData> levelDataList = levelDataMapper.getLevelDataLevel(accountIdx, longYear);
		
		return levelDataList;
	}
	

	public LevelData getLevelData(long idx) {
		if(levelDataMapper==null) {return null;}
		
		LevelData levelData = levelDataMapper.getLevelData(idx);
		
		return levelData;
	}
	
}
