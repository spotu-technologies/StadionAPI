package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.mapper.MomParticipantLinkInfoMapper;


@Service
public class MomParticipantLinkInfoService {
	@Autowired
	private MomParticipantLinkInfoMapper momParticipantLinkInfoMapper;
	
	public List<MomParticipantLinkInfo> getMomParticipantLinkInfoName(long accountIdx) {
		if(momParticipantLinkInfoMapper==null) {return null;}
		
		List<MomParticipantLinkInfo> momParticipantLinkInfoList = momParticipantLinkInfoMapper.getMomParticipantLinkInfoName(accountIdx);
		
		return momParticipantLinkInfoList;
	}
	
	
	public MomParticipantLinkInfo getMomParticipantLinkInfo(long idx) {
		if(momParticipantLinkInfoMapper==null) {return null;}
		
		MomParticipantLinkInfo momParticipantLinkInfo = momParticipantLinkInfoMapper.getMomParticipantLinkInfo(idx);
		
		return momParticipantLinkInfo;
	}
	
	public long insertMomParticipantLinkInfo(MomParticipantLinkInfo arg) {
		if(momParticipantLinkInfoMapper==null) {return 0;}
		return momParticipantLinkInfoMapper.insertMomParticipantLinkInfo(arg);
	}
	public long deleteMomParticipantLinkInfo(MomParticipantLinkInfo arg) {
		if(momParticipantLinkInfoMapper==null) {return 0;}
		return momParticipantLinkInfoMapper.deleteMomParticipantLinkInfo(arg);
	}

	
	public long getMomParticipantLinkInfoAttend(MomParticipantLinkInfo arg) {
		if(momParticipantLinkInfoMapper==null) {return 0;}
		return momParticipantLinkInfoMapper.getMomParticipantLinkInfoAttend(arg);
	}
	
	public long getMomParticipantLinkInfoCount(long accountIdx) {
		if(momParticipantLinkInfoMapper==null) {return 0;}
		return momParticipantLinkInfoMapper.getMomParticipantLinkInfoCount(accountIdx);
	}
	
}
