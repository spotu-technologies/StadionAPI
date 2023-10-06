package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomMovementLinkInfo;
import com.stadion.api.mapper.MomMovementLinkInfoMapper;


@Service
public class MomMovementLinkInfoService {
	@Autowired
	private MomMovementLinkInfoMapper momMovementLinkInfoMapper;
	
	
	public MomMovementLinkInfo getMomMovementLinkInfo(long idx) {
		if(momMovementLinkInfoMapper==null) {return null;}
		
		MomMovementLinkInfo momMovementLinkInfo = momMovementLinkInfoMapper.getMomMovementLinkInfo(idx);
		
		return momMovementLinkInfo;
	}
	
}
