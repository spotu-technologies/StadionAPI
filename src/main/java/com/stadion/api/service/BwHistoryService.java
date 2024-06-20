package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BwHistory;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.mapper.BwHistoryMapper;


@Service
public class BwHistoryService {
	@Autowired
	private BwHistoryMapper bwHistoryMapper;
	
	
	public BwHistory getBwHistory(long idx) {
		if(bwHistoryMapper==null) {return null;}
		
		BwHistory bwHistory = bwHistoryMapper.getBwHistory(idx);
		
		return bwHistory;
	}
	
	public long insertBwHistory(BwHistory bw) 
	{
		if(bwHistoryMapper==null) {return 0;}
		
		return bwHistoryMapper.insertBwHistory(bw);
	}
	
	
	public List<BwHistory> getBwHistorWeight(long accountIdx) {
		if(bwHistoryMapper==null) {return null;}
		
		List<BwHistory> bwHistoryList = bwHistoryMapper.getBwHistorWeight(accountIdx);
		
		return bwHistoryList;
	}

}
