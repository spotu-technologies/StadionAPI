package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.ActionHistory;
import com.stadion.api.mapper.ActionHistoryMapper;

@Service
public class ActionHistoryService {
	@Autowired
	private ActionHistoryMapper actionHistoryMapper;
	
	
	public ActionHistory getActionHistory(long idx ) {
		if(actionHistoryMapper==null) {return null;}
		
		ActionHistory actionHistory = actionHistoryMapper.getActionHistory(idx);
		
		return actionHistory;
	}


}
