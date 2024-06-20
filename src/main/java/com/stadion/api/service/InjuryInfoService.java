package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.InjuryInfo;
import com.stadion.api.mapper.InjuryInfoMapper;


@Service
public class InjuryInfoService {
	@Autowired
	private InjuryInfoMapper injuryInfoMapper;
	
	public List<InjuryInfo> getInjuryInfoLast() {
		if(injuryInfoMapper==null) {return null;}
		
		List<InjuryInfo> injuryInfoList = injuryInfoMapper.getInjuryInfoLast();
		
		return injuryInfoList;
	}
	
	public List<InjuryInfo> getInjuryInfoAll() {
		if(injuryInfoMapper==null) {return null;}
		
		List<InjuryInfo> injuryInfoList = injuryInfoMapper.getInjuryInfoAll();
		
		return injuryInfoList;
	}
	
	
	public InjuryInfo getInjuryInfo(long idx) {
		if(injuryInfoMapper==null) {return null;}
		
		InjuryInfo injuryInfo = injuryInfoMapper.getInjuryInfo(idx);
		
		return injuryInfo;
	}
	
}
