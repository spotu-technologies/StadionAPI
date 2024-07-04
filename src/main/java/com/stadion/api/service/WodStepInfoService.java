package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodStepInfo;
import com.stadion.api.mapper.WodStepInfoMapper;


@Service
public class WodStepInfoService {
	@Autowired
	private WodStepInfoMapper wodStepInfoMapper;
	
	
	public WodStepInfo getWodStepInfo(long idx) {
		if(wodStepInfoMapper==null) {return null;}
		
		WodStepInfo wodStepInfo = wodStepInfoMapper.getWodStepInfo(idx);
		
		return wodStepInfo;
	}
	
	public List<WodStepInfo> getWodStepInfoByWodIdx(long wodIdx) {
		if(wodStepInfoMapper==null) {return null;}
		List<WodStepInfo> wodStepInfo = wodStepInfoMapper.getWodStepInfoByWodIdx(wodIdx);
		return wodStepInfo;
	}
	
	
}
