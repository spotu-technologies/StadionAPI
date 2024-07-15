package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BwHistory;
import com.stadion.api.entity.ChatData;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.mapper.BwHistoryMapper;
import com.stadion.api.mapper.ChatDataMapper;


@Service
public class ChatDataService {
	@Autowired
	private ChatDataMapper chatDataMapper;
	
	public List<ChatData> getChatDataByAccountIdx(long accountIdx){
		if(chatDataMapper==null) {return null;}		
		List<ChatData> data = chatDataMapper.getChatDataByAccountIdx(accountIdx);		
		return data;
	}	
	
	public ChatData getChatData(long idx) {
		if(chatDataMapper==null) {return null;}		
		ChatData data = chatDataMapper.getChatData(idx);		
		return data;
	}
	
	public long insertChatData(ChatData arg) {
		if(chatDataMapper==null) {return 0L;}		
		return chatDataMapper.insertChatData(arg);		
	}
	
	public long updateChatData(ChatData arg) {
		if(chatDataMapper==null) {return 0L;}		
		return chatDataMapper.updateChatData(arg);		
	}
}


