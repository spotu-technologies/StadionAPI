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
	
	
	public WodParticipantLinkInfo getWodParticipantLinkInfo(String userId) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodParticipantLinkInfo wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getWodParticipantLinkInfo(userId);
		
		return wodParticipantLinkInfo;
	}
	public WodParticipantLinkInfo getWodParticipantLinkInfoByEmail(String emailAddress) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodParticipantLinkInfo wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getWodParticipantLinkInfoByEmail(emailAddress);
		
		return wodParticipantLinkInfo;
	}

}
