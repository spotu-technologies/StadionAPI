package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomRankData;
import com.stadion.api.entity.MomRankDataResult;
import com.stadion.api.entity.RankingDataParameter;
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
	
	public MomRankData getMomRankingData(long momIdx) {
		if(momRankDataMapper==null) {return null;}
		
		MomRankData momRankData = momRankDataMapper.getMomRankingData(momIdx);
		
		return momRankData;
	}
	
	public List<MomRankDataResult> getMomRankingDataList(RankingDataParameter param
			//long momIdx, String dynamicColumn, String orderType, long year, long start, long count, String minMax
			) {
		if(momRankDataMapper==null) {return null;}
		
		List<MomRankDataResult> momRankData = momRankDataMapper.getMomRankingDataList(param);	//momIdx, dynamicColumn, orderType, year, start, count, minMax);
		
		return momRankData;
	}
	
}
