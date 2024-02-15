package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.FollowLinkInfo;
import com.stadion.api.mapper.ActionHistoryMapper;
import com.stadion.api.mapper.FollowLinkInfoMapper;

@Service
public class FollowLinkInfoService {
	@Autowired
	private FollowLinkInfoMapper followLinkInfoMapper;
	
	
	public List<FollowLinkInfo> getFollowLinkInfoFollow(long followAccountIdx) {
		if(followLinkInfoMapper==null) {return null;}
		
		List<FollowLinkInfo> followLinkInfoList = followLinkInfoMapper.getFollowLinkInfoFollow(followAccountIdx);
		
		return followLinkInfoList;
	}
	
	
	public List<FollowLinkInfo> getFollowLinkInfoReg(long regAccountIdx) {
		if(followLinkInfoMapper==null) {return null;}
		
		List<FollowLinkInfo> followLinkInfoList = followLinkInfoMapper.getFollowLinkInfoReg(regAccountIdx);
		
		return followLinkInfoList;
	}


}


