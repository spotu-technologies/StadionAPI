package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.entity.MomInfoWithFile;
import com.stadion.api.entity.MomTeamInfo;
import com.stadion.api.entity.MomTeamMemberInfo;
import com.stadion.api.mapper.MomInfoMapper;


@Service
public class MomInfoService {
	@Autowired
	private MomInfoMapper momInfoMapper;
	
	public List<MomInfo> getMomInfoAll() {
		if(momInfoMapper==null) {return null;}
		
		List<MomInfo> momInfoList = momInfoMapper.getMomInfoAll();
		
		return momInfoList;
	}
	
	public List<MomInfoWithFile> getMomInfoListDetail(long accountIdx) {
		if(momInfoMapper==null) {return null;}
		
		List<MomInfoWithFile> momInfoList = momInfoMapper.getMomInfoListDetail(accountIdx);
		
		return momInfoList;
	}

	
	public MomInfo getMomInfo(long idx) {
		if(momInfoMapper==null) {return null;}
		
		MomInfo momInfo = momInfoMapper.getMomInfo(idx);
		
		return momInfo;
	}
	
	public Long getMomTeamInfoIdx(long leaderAccountIdx, long momIdx) {
		if(momInfoMapper==null) {return 0L;}
		return momInfoMapper.getMomTeamInfoIdx(leaderAccountIdx, momIdx);
	}
	public List<MomTeamInfo> getMomTeamInfoByMomIdx(long momIdx) {
		if(momInfoMapper==null) {return null;}
		List<MomTeamInfo> momInfo = momInfoMapper.getMomTeamInfoByMomIdx(momIdx);
		return momInfo;
	}
	
	public List<MomTeamInfo> getMomTeamInfo(long leaderAccountIdx) {
		if(momInfoMapper==null) {return null;}
		List<MomTeamInfo> momInfo = momInfoMapper.getMomTeamInfo(leaderAccountIdx);
		return momInfo;
	}
	
	public int insertMomTeamInfo(MomTeamInfo arg) {
		if(momInfoMapper==null) {return 0;}		
		return momInfoMapper.insertMomTeamInfo(arg);		
	}
	
	public int insertMomTeamMemberInfo(MomTeamMemberInfo arg) {
		if(momInfoMapper==null) {return 0;}		
		return momInfoMapper.insertMomTeamMemberInfo(arg);		
	}
	
}
