package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.PushBoard;
import com.stadion.api.mapper.PushBoardMapper;


@Service
public class PushBoardService {
	@Autowired
	private PushBoardMapper pushBoardMapper;
	
	
	public PushBoard getPushBoard(String userId) {
		if(pushBoardMapper==null) {return null;}
		
		PushBoard pushBoard = pushBoardMapper.getPushBoard(userId);
		
		return pushBoard;
	}
	public PushBoard getPushBoardByEmail(String emailAddress) {
		if(pushBoardMapper==null) {return null;}
		
		PushBoard pushBoard = pushBoardMapper.getPushBoardByEmail(emailAddress);
		
		return pushBoard;
	}

}
