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
	
	public List<NoticeBoard> getNoticeBoardAll() {
		if(noticeBoardMapper==null) {return null;}
		
		List<NoticeBoard> noticeBoardList = noticeBoardMapper.getNoticeBoardAll();
		
		return noticeBoardList;
	}
	
	public NoticeBoard getNoticeBoard(long idx) {
		if(noticeBoardMapper==null) {return null;}
		
		NoticeBoard noticeBoard = noticeBoardMapper.getNoticeBoard(idx);
		
		return noticeBoard;
	}
	
}
