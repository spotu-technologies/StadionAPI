package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementPointData;
import com.stadion.api.mapper.MovementPointDataMapper;


@Service
public class MovementPointDataService {
	@Autowired
	private MovementPointDataMapper movementPointDataMapper;
	
	
	public MovementPointData getMovementPointData(String userId) {
		if(movementPointDataMapper==null) {return null;}
		
		MovementPointData movementPointData = movementPointDataMapper.getMovementPointData(userId);
		
		return movementPointData;
	}
	public MovementPointData getMovementPointDataByEmail(String emailAddress) {
		if(movementPointDataMapper==null) {return null;}
		
		MovementPointData movementPointData = movementPointDataMapper.getMovementPointDataByEmail(emailAddress);
		
		return movementPointData;
	}

}
