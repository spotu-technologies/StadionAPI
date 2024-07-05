package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.entity.WodRecordInfoWithBox;
import com.stadion.api.mapper.WodRecordInfoMapper;


@Service
public class WodRecordInfoService {
	@Autowired
	private WodRecordInfoMapper wodRecordInfoMapper;
	
	
	public WodRecordInfo getWodRecordInfo(long idx) {
		if(wodRecordInfoMapper==null) {return null;}
		
		WodRecordInfo wodRecordInfo = wodRecordInfoMapper.getWodRecordInfo(idx);
		
		return wodRecordInfo;
	}
	
	public List<WodRecordInfo> getWodRecordInfoByWodIdx(long wodIdx) {
		if(wodRecordInfoMapper==null) {return null;}
		
		List<WodRecordInfo> wodRecordInfo = wodRecordInfoMapper.getWodRecordInfoByWodIdx(wodIdx);
		
		return wodRecordInfo;
	}
	

	public List<WodRecordInfoWithBox> getWodRecordInfoRecentByWod(long accountIdx, long wodIdx) {
		if(wodRecordInfoMapper==null) {return null;}
		
		List<WodRecordInfoWithBox> wodParticipantLinkInfo = wodRecordInfoMapper.getWodRecordInfoRecentByWod(accountIdx, wodIdx);
		
		return wodParticipantLinkInfo;
	}

}
