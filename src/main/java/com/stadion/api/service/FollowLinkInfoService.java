package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.FollowLinkInfo;
import com.stadion.api.entity.FollowList;
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
	
	public List<FollowList> getFollowList(long accountIdx) {
		if(followLinkInfoMapper==null) {return null;}
		
		List<FollowList> followLinkInfoList = followLinkInfoMapper.getFollowList(accountIdx);
		
		return followLinkInfoList;
	}
	
	public long getIsFollow(FollowLinkInfo arg) {
		if(followLinkInfoMapper==null) {return 0;}
		return followLinkInfoMapper.getIsFollow(arg);
	}

	public long insertFollowLinkInfoFollow(FollowLinkInfo arg) {
		if(followLinkInfoMapper==null) {return 0;}
		return followLinkInfoMapper.insertFollowLinkInfoFollow(arg);
	}
	public long deleteFollowLinkInfoFollow(FollowLinkInfo arg) {
		if(followLinkInfoMapper==null) {return 0;}
		return followLinkInfoMapper.deleteFollowLinkInfoFollow(arg);
	}

}


