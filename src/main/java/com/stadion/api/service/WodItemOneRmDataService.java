package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.mapper.WodItemOneRmDataMapper;


@Service
public class WodItemOneRmDataService {
	@Autowired
	private WodItemOneRmDataMapper wodItemOneRmDataMapper;
	
	
	public WodItemOneRmData getWodItemOneRmData(long idx) {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		WodItemOneRmData wodItemOneRmData = wodItemOneRmDataMapper.getWodItemOneRmData(idx);
		
		return wodItemOneRmData;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataPersonal(long accountIdx) {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataPersonal(accountIdx);
		
		return wodItemOneRmDataList;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataPersonalDetail(long accountIdx) {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataPersonalDetail(accountIdx);
		
		return wodItemOneRmDataList;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataClub(long accountIdx) {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataClub(accountIdx);
		
		return wodItemOneRmDataList;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataClubMan() {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataClubMan();
		
		return wodItemOneRmDataList;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataClubWoman() {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataClubWoman();
		
		return wodItemOneRmDataList;
	}
	
	
	public List<WodItemOneRmData> getWodItemOneRmDataClubAll() {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		List<WodItemOneRmData> wodItemOneRmDataList = wodItemOneRmDataMapper.getWodItemOneRmDataClubAll();
		
		return wodItemOneRmDataList;
	}
	
	
}
