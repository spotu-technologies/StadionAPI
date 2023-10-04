package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.mapper.MomParticipantLinkInfoMapper;


@Service
public class MomParticipantLinkInfoService {
	@Autowired
	private MomParticipantLinkInfoMapper momParticipantLinkInfoMapper;
	
	
	public MomParticipantLinkInfo getMomParticipantLinkInfo(String userId) {
		if(momParticipantLinkInfoMapper==null) {return null;}
		
		MomParticipantLinkInfo momParticipantLinkInfo = momParticipantLinkInfoMapper.getMomParticipantLinkInfo(userId);
		
		return momParticipantLinkInfo;
	}
	public MomParticipantLinkInfo getMomParticipantLinkInfoByEmail(String emailAddress) {
		if(momParticipantLinkInfoMapper==null) {return null;}
		
		MomParticipantLinkInfo momParticipantLinkInfo = momParticipantLinkInfoMapper.getMomParticipantLinkInfoByEmail(emailAddress);
		
		return momParticipantLinkInfo;
	}

}
