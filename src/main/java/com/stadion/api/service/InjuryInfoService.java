package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.InjuryInfo;
import com.stadion.api.mapper.InjuryInfoMapper;


@Service
public class InjuryInfoService {
	@Autowired
	private InjuryInfoMapper injuryInfoMapper;
	
	
	public InjuryInfo getInjuryInfo(long idx) {
		if(injuryInfoMapper==null) {return null;}
		
		InjuryInfo injuryInfo = injuryInfoMapper.getInjuryInfo(idx);
		
		return injuryInfo;
	}
	
}
