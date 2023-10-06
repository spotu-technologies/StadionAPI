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
	
	
	public LikeData getLikeData(long idx) {
		if(likeDataMapper==null) {return null;}
		
		LikeData likeData = likeDataMapper.getLikeData(idx);
		
		return likeData;
	}
	
}
