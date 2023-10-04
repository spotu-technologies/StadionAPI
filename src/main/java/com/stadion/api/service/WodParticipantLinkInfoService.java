package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.mapper.WodParticipantLinkInfoMapper;


@Service
public class WodParticipantLinkInfoService {
	@Autowired
	private WodParticipantLinkInfoMapper wodParticipantLinkInfoMapper;
	
	
	public WodParticipantLinkInfo getWodParticipantLinkInfo(int idx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodParticipantLinkInfo wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getWodParticipantLinkInfo(idx);
		
		return wodParticipantLinkInfo;
	}
	
}
