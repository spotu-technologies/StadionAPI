package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomRankData;
import com.stadion.api.mapper.MomRankDataMapper;


@Service
public class MomRankDataService {
	@Autowired
	private MomRankDataMapper momRankDataMapper;
	
	
	public MomRankData getMomRankData(long idx) {
		if(momRankDataMapper==null) {return null;}
		
		MomRankData momRankData = momRankDataMapper.getMomRankData(idx);
		
		return momRankData;
	}
	
}
