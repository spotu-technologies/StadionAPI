package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.mapper.WodBoxLinkInfoMapper;


@Service
public class WodBoxLinkInfoService {
	@Autowired
	private WodBoxLinkInfoMapper wodBoxLinkInfoMapper;
	
	
	public WodBoxLinkInfo getWodBoxLinkInfo(String userId) {
		if(wodBoxLinkInfoMapper==null) {return null;}
		
		WodBoxLinkInfo wodBoxLinkInfo = wodBoxLinkInfoMapper.getWodBoxLinkInfo(userId);
		
		return wodBoxLinkInfo;
	}
	public WodBoxLinkInfo getWodBoxLinkInfoByEmail(String emailAddress) {
		if(wodBoxLinkInfoMapper==null) {return null;}
		
		WodBoxLinkInfo wodBoxLinkInfo = wodBoxLinkInfoMapper.getWodBoxLinkInfoByEmail(emailAddress);
		
		return wodBoxLinkInfo;
	}

}
