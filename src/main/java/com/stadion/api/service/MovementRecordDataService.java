package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.NoticeBoard;
import com.stadion.api.mapper.MovementRecordDataMapper;


@Service
public class MovementRecordDataService {
	@Autowired
	private MovementRecordDataMapper movementRecordDataMapper;
	
	public MovementRecordData getMovementRecordData(long idx) {
		if(movementRecordDataMapper==null) {return null;}
		
		MovementRecordData movementRecordData = movementRecordDataMapper.getMovementRecordData(idx);
		
		return movementRecordData;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataAll() {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataAll();
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataRecent(long accountIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataRecent(accountIdx);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataBest(long accountIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataBest(accountIdx);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataYearBest(long accountIdx, long dateYear) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataYearBest(accountIdx, dateYear);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataDetail(long accountIdx, long movementIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataDetail(accountIdx, movementIdx);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDataRecentDetail(long accountIdx, long movementIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDataRecentDetail(accountIdx, movementIdx);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDatMomLevel(long accountIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDatMomLevel(accountIdx);
		
		return movementRecordDataList;
	}
	
	
	public List<MovementRecordData> getMovementRecordDatChallenge(long accountIdx) {
		if(movementRecordDataMapper==null) {return null;}
		
		List<MovementRecordData> movementRecordDataList = movementRecordDataMapper.getMovementRecordDatChallenge(accountIdx);
		
		return movementRecordDataList;
	}
	
	
	
	
}
