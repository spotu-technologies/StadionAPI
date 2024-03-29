package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.mapper.MovementInfoMapper;


@Service
public class MovementInfoService {
	@Autowired
	private MovementInfoMapper movementInfoMapper;
	
	
	public MovementInfo getMovementInfo(long idx) {
		if(movementInfoMapper==null) {return null;}
		
		MovementInfo movementInfo = movementInfoMapper.getMovementInfo(idx);
		
		return movementInfo;
	}
	
	
	public List<MovementInfo> getMovementInfoAll() {
		if(movementInfoMapper==null) {return null;}
		
		List<MovementInfo> movementInfoList = movementInfoMapper.getMovementInfoAll();
		
		return movementInfoList;
	}
	
}
