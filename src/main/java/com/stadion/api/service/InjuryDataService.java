package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.InjuryData;
import com.stadion.api.mapper.InjuryDataMapper;


@Service
public class InjuryDataService {
	@Autowired
	private InjuryDataMapper injuryDataMapper;
	
	
	public InjuryData getInjuryData(String userId) {
		if(injuryDataMapper==null) {return null;}
		
		InjuryData injuryData = injuryDataMapper.getInjuryData(userId);
		
		return injuryData;
	}
	public InjuryData getInjuryDataByEmail(String emailAddress) {
		if(injuryDataMapper==null) {return null;}
		
		InjuryData injuryData = injuryDataMapper.getInjuryDataByEmail(emailAddress);
		
		return injuryData;
	}

}
