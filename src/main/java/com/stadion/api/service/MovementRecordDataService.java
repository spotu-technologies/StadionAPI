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
	
	
	public MovementRecordData getMovementRecordData(int idx) {
		if(movementRecordDataMapper==null) {return null;}
		
		MovementRecordData movementRecordData = movementRecordDataMapper.getMovementRecordData(idx);
		
		return movementRecordData;
	}
	
}
