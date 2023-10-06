package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementParticipantLinkInfo;
import com.stadion.api.mapper.MovementParticipantLinkInfoMapper;


@Service
public class MovementParticipantLinkInfoService {
	@Autowired
	private MovementParticipantLinkInfoMapper movementParticipantLinkInfoMapper;
	
	
	public MovementParticipantLinkInfo getMovementParticipantLinkInfo(long idx) {
		if(movementParticipantLinkInfoMapper==null) {return null;}
		
		MovementParticipantLinkInfo movementParticipantLinkInfo = movementParticipantLinkInfoMapper.getMovementParticipantLinkInfo(idx);
		
		return movementParticipantLinkInfo;
	}
	
}
