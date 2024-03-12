package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BadgeAccountLinkInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.mapper.BadgeAccountLinkInfoMapper;
import com.stadion.api.mapper.BoxInfoMapper;


@Service
public class BadgeAccountLinkInfoService {
	@Autowired
	private BadgeAccountLinkInfoMapper badgeAccountLinkInfoMapper;
	
	public List<BadgeAccountLinkInfo> getBadgeAccountLinkInfo(long accountIdx) {
		if(badgeAccountLinkInfoMapper==null) {return null;}
		
		List<BadgeAccountLinkInfo> badgeAccountLinkInfoList = badgeAccountLinkInfoMapper.getBadgeAccountLinkInfo(accountIdx);
		
		return badgeAccountLinkInfoList;
	}
	

}
