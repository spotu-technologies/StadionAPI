package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BadgeInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.mapper.BadgeInfoMapper;
import com.stadion.api.mapper.BoxInfoMapper;


@Service
public class BadgeInfoService {
	@Autowired
	private BadgeInfoMapper badgeInfoMapper;
	
	public List<BadgeInfo> getBadgeInfo() {
		if(badgeInfoMapper==null) {return null;}
		
		List<BadgeInfo> badgeInfoList = badgeInfoMapper.getBadgeInfo();
		
		return badgeInfoList;
	}
	

}
