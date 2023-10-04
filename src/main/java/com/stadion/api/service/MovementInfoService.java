package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementInfo;
import com.stadion.api.mapper.MovementInfoMapper;


@Service
public class MovementInfoService {
	@Autowired
	private MovementInfoMapper movementInfoMapper;
	
	
	public MovementInfo getMovementInfo(String userId) {
		if(movementInfoMapper==null) {return null;}
		
		MovementInfo movementInfo = movementInfoMapper.getMovementInfo(userId);
		
		return movementInfo;
	}
	public MovementInfo getMovementInfoByEmail(String emailAddress) {
		if(movementInfoMapper==null) {return null;}
		
		MovementInfo movementInfo = movementInfoMapper.getMovementInfoByEmail(emailAddress);
		
		return movementInfo;
	}

}
