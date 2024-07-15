package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.ChatData;

@Mapper
public interface ChatDataMapper {
	public ChatData getChatData(long idx);
	public List<ChatData> getChatDataByAccountIdx(long idx);
	public long insertChatData(ChatData arg);
	public long updateChatData(ChatData arg);

}

