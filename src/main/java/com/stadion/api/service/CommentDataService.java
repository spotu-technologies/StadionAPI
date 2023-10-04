package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.CommentData;
import com.stadion.api.mapper.CommentDataMapper;


@Service
public class CommentDataService {
	@Autowired
	private CommentDataMapper commentDataMapper;
	
	
	public CommentData getCommentData(String userId) {
		if(commentDataMapper==null) {return null;}
		
		CommentData commentData = commentDataMapper.getCommentData(userId);
		
		return commentData;
	}
	public CommentData getCommentDataByEmail(String emailAddress) {
		if(commentDataMapper==null) {return null;}
		
		CommentData commentData = commentDataMapper.getCommentDataByEmail(emailAddress);
		
		return commentData;
	}

}
