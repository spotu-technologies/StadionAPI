package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.LevelData;
import com.stadion.api.mapper.InjuryDataMapper;


@Service
public class InjuryDataService {
	@Autowired
	private InjuryDataMapper injuryDataMapper;
	
	public List<InjuryData> getInjuryDataLast(long accountIdx) {
		if(injuryDataMapper==null) {return null;}
		
		List<InjuryData> injuryDataList = injuryDataMapper.getInjuryDataLast(accountIdx);
		
		return injuryDataList;
	}
	
	public List<InjuryData> getInjuryDataLook(long accountIdx) {
		if(injuryDataMapper==null) {return null;}
		
		List<InjuryData> injuryDataList = injuryDataMapper.getInjuryDataLook(accountIdx);
		
		return injuryDataList;
	}
	
	
	public InjuryData getInjuryData(long idx) {
		if(injuryDataMapper==null) {return null;}
		
		InjuryData injuryData = injuryDataMapper.getInjuryData(idx);
		
		return injuryData;
	}
	
	
	public int insertInjuryData(InjuryData data) {
		if(injuryDataMapper==null) {return 0;}		
		return injuryDataMapper.insertInjuryData(data);		
	}
}
