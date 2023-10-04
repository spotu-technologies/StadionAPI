package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.LikeData;
import com.stadion.api.mapper.LikeDataMapper;


@Service
public class LikeDataService {
	@Autowired
	private LikeDataMapper likeDataMapper;
	
	
	public LikeData getLikeData(String userId) {
		if(likeDataMapper==null) {return null;}
		
		LikeData likeData = likeDataMapper.getLikeData(userId);
		
		return likeData;
	}
	public LikeData getLikeDataByEmail(String emailAddress) {
		if(likeDataMapper==null) {return null;}
		
		LikeData likeData = likeDataMapper.getLikeDataByEmail(emailAddress);
		
		return likeData;
	}

}
