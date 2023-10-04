package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BwHistory;
import com.stadion.api.mapper.BwHistoryMapper;


@Service
public class BwHistoryService {
	@Autowired
	private BwHistoryMapper bwHistoryMapper;
	
	
	public BwHistory getBwHistory(String userId) {
		if(bwHistoryMapper==null) {return null;}
		
		BwHistory bwHistory = bwHistoryMapper.getBwHistory(userId);
		
		return bwHistory;
	}
	public BwHistory getBwHistoryByEmail(String emailAddress) {
		if(bwHistoryMapper==null) {return null;}
		
		BwHistory bwHistory = bwHistoryMapper.getBwHistoryByEmail(emailAddress);
		
		return bwHistory;
	}

}
