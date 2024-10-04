package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomAttend;
import com.stadion.api.entity.MomAttendByDay;
import com.stadion.api.entity.RangedArg;
import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.entity.WodBoxLinkInfoName;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.entity.WodRecordInfoWithBox;
import com.stadion.api.mapper.WodParticipantLinkInfoMapper;


@Service
public class WodParticipantLinkInfoService {
	@Autowired
	private WodParticipantLinkInfoMapper wodParticipantLinkInfoMapper;
	
	public long getwodParticipantLinkInfoAttend(long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getwodParticipantLinkInfoAttend(accountIdx);
	}
	
	public List<MomAttendByDay> getRangedWodParticipantLinkInfoMap(RangedArg arg) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		List<MomAttendByDay> ret = wodParticipantLinkInfoMapper.getRangedWodParticipantLinkInfoMap(arg);
		return ret;
	}
	public MomAttend getRangedWodParticipantLinkInfo(RangedArg arg) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		MomAttend ret = wodParticipantLinkInfoMapper.getRangedWodParticipantLinkInfo(arg);
		return ret;
	}
	
	public long getwodParticipantLinkInfoNoAttend(long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}
		return wodParticipantLinkInfoMapper.getwodParticipantLinkInfoNoAttend(accountIdx);
	}
	
	
	public WodParticipantLinkInfo getWodParticipantLinkInfo(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodParticipantLinkInfo wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getWodParticipantLinkInfo(idx);
		
		return wodParticipantLinkInfo;
	}
	
	public long getwodParticipantCount(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getwodParticipantCount(idx);
	}
	
	public long getwodParticipantIdx(long accountIdx, long wbLinkIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getwodParticipantIdx(accountIdx, wbLinkIdx);
	}
	
	public long getWodParticipantStatus(long accountIdx, long wbLinkIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getWodParticipantStatus(accountIdx, wbLinkIdx);
	}
	
	public long getWodParticipantCountByAccount(long accountIdx, long wodIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getWodParticipantCountByAccount(accountIdx, wodIdx);
	}

	
	public long getwodParticipantReserved(long idx, long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getwodParticipantReserved(idx, accountIdx);
	}
	
	public long getwodParticipantStatus(long idx, long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getwodParticipantStatus(idx, accountIdx);
	}
	
	public long insertWodParticipantLinkInfo(WodParticipantLinkInfo arg) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.insertWodParticipantLinkInfo(arg);
	}
	
	public long cancelWodParticipantLinkInfo(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.cancelWodParticipantLinkInfo(idx);
	}
	
	
	public long reserveWodParticipantLinkInfo(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.reserveWodParticipantLinkInfo(idx);
	}
	
	public long getWodParticipantAttend(long idx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}		
		return wodParticipantLinkInfoMapper.getWodParticipantAttend(idx);
	}

	public WodBoxLinkInfoName getwodParticipantRecent(long accountIdx) {
		if(wodParticipantLinkInfoMapper==null) {return null;}
		
		WodBoxLinkInfoName wodParticipantLinkInfo = wodParticipantLinkInfoMapper.getwodParticipantRecent(accountIdx);
		
		return wodParticipantLinkInfo;
	}
	
	public long getWbLinkIdx(long accountIdx, long wodIdx) {
		if(wodParticipantLinkInfoMapper==null) {return 0;}
		return wodParticipantLinkInfoMapper.getWbLinkIdx(accountIdx, wodIdx);
	}

}
