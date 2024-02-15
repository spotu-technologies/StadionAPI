package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.mapper.WodParticipantLinkInfoMapper;


@Service
public class WodParticipantLinkInfoService {
	@Autowired
	private WodParticipantLinkInfoMapper wodParticipantLinkInfoMapper;
	
	public List<WodParticipantLinkInfo> getWodParticipantLinkInfoIsAttend(long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		List<WodParticipantLinkInfo> wodParticipantLinkInfoList 
		   = wodParticipantLinkInfoMapper.getWodParticipantLinkInfoIsAttend(accountIdx);
		
		return wodParticipantLinkInfoList;
	}
	
	
	public List<WodParticipantLinkInfo> getWodParticipantLinkInfoIsNonappearance(long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		List<WodParticipantLinkInfo> wodParticipantLinkInfoList 
		   = wodParticipantLinkInfoMapper.getWodParticipantLinkInfoIsNonappearance(accountIdx);
		
		return wodParticipantLinkInfoList;
	}
	
	
	public WodParticipantLinkInfo getWodParticipantLinkInfo(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodParticipantLinkInfo wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getWodParticipantLinkInfo(idx);
		
		return wodParticipantLinkInfo;
	}
	
}
