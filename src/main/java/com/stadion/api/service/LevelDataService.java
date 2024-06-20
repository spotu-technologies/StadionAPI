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
	

	public List<LevelData> getLevelData(long accountIdx) {
		if(levelDataMapper==null) {return null;}
		
		List<LevelData> levelData = levelDataMapper.getLevelData(accountIdx);
		
		return levelData;
	}
	
	public int insertLevelData(LevelData arg) {
		if(levelDataMapper==null) {return 0;}	
		return levelDataMapper.insertLevelData(arg);
	}
}
