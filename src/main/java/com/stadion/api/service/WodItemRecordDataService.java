package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.RankingDataParameter;
import com.stadion.api.entity.ScaleGender;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodItemRecordDataDetail;
import com.stadion.api.entity.WodItemRecordDataRanking;
import com.stadion.api.mapper.WodItemRecordDataMapper;


@Service
public class WodItemRecordDataService {
	@Autowired
	private WodItemRecordDataMapper wodItemRecordDataMapper;
	
	public List<WodItemRecordData> getWodItemRecordDataRecent(long accountIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getWodItemRecordDataRecent(accountIdx);
		
		return wodItemRecordDataList;
	}
	
	public List<WodItemRecordData> getWodItemRecordDatarecord(long accountIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getWodItemRecordDatarecord(accountIdx);
		
		return wodItemRecordDataList;
	}
	
	
	public List<WodItemRecordDataDetail> getWodItemRecordDataDetail(long accountIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordDataDetail> wodItemRecordData = wodItemRecordDataMapper.getWodItemRecordDataDetail(accountIdx);
		
		return wodItemRecordData;
	}
	
	public List<WodItemRecordData> getWodItemRecordDataByWodIdx(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordData = wodItemRecordDataMapper.getWodItemRecordDataByWodIdx(wodIdx);
		
		return wodItemRecordData;
	}
	
	public Double getWodItemRecordDataByWodAvg(long wodidx) {
		if(wodItemRecordDataMapper==null) {return 0.0;}
		return wodItemRecordDataMapper.getWodItemRecordDataByWodAvg(wodidx);
	}
	
	public Double getWodItemRecordDataByWodBest(long wodidx, String minMax) {
		if(wodItemRecordDataMapper==null) {return 0.0;}
		return wodItemRecordDataMapper.getWodItemRecordDataByWodBest(wodidx, minMax);
	}

	
	public long getWodItemRecordDataBest(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return 0;}
		return wodItemRecordDataMapper.getWodItemRecordDataBest(wodIdx);
	}	
	
	public List<WodItemRecordData> getRankingScale(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getRankingScale(wodIdx);
		
		return wodItemRecordDataList;
	}
	
	public List<String> getRankingScaleString(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<String> wodItemRecordDataList = wodItemRecordDataMapper.getRankingScaleString(wodIdx);
		
		return wodItemRecordDataList;
	}
	
	public List<ScaleGender> getRankingScaleGender(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<ScaleGender> wodItemRecordDataList = wodItemRecordDataMapper.getRankingScaleGender(wodIdx);
		
		return wodItemRecordDataList;
	}
		
	public int insertWodItemRecord(WodItemRecordData arg) {
		if(wodItemRecordDataMapper==null) {return 0;}		
		return wodItemRecordDataMapper.insertWodItemRecord(arg);
	}
	
	public List<WodItemRecordData> getWodItemRecordRankingList(RankingDataParameter param) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getWodItemRecordRankingList(param);
		
		return wodItemRecordDataList;
	}

	public List<WodItemRecordData> getWodItemRecordListByWodIdx(long wodIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getWodItemRecordListByWodIdx(wodIdx);
		
		return wodItemRecordDataList;
	}
}
