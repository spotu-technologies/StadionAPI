package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.mapper.MovementRecordDataMapper;


@Service
public class MovementRecordDataService {
	@Autowired
	private MovementRecordDataMapper movementRecordDataMapper;
	
	
	public MovementRecordData getMovementRecordData(String userId) {
		if(movementRecordDataMapper==null) {return null;}
		
		MovementRecordData movementRecordData = movementRecordDataMapper.getMovementRecordData(userId);
		
		return movementRecordData;
	}
	public MovementRecordData getMovementRecordDataByEmail(String emailAddress) {
		if(movementRecordDataMapper==null) {return null;}
		
		MovementRecordData movementRecordData = movementRecordDataMapper.getMovementRecordDataByEmail(emailAddress);
		
		return movementRecordData;
	}

}
