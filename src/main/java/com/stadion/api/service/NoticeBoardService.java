package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.NoticeBoard;
import com.stadion.api.mapper.NoticeBoardMapper;


@Service
public class NoticeBoardService {
	@Autowired
	private NoticeBoardMapper noticeBoardMapper;
	
	
	public NoticeBoard getNoticeBoard(String userId) {
		if(noticeBoardMapper==null) {return null;}
		
		NoticeBoard noticeBoard = noticeBoardMapper.getNoticeBoard(userId);
		
		return noticeBoard;
	}
	public NoticeBoard getNoticeBoardByEmail(String emailAddress) {
		if(noticeBoardMapper==null) {return null;}
		
		NoticeBoard noticeBoard = noticeBoardMapper.getNoticeBoardByEmail(emailAddress);
		
		return noticeBoard;
	}

}
