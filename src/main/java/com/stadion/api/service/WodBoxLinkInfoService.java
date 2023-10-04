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
	
	
	public WodBoxLinkInfo getWodBoxLinkInfo(int idx) {
		if(wodBoxLinkInfoMapper==null) {return null;}
		
		WodBoxLinkInfo wodBoxLinkInfo = wodBoxLinkInfoMapper.getWodBoxLinkInfo(idx);
		
		return wodBoxLinkInfo;
	}
	
}
