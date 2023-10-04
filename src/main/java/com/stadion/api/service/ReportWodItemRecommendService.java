package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.ReportWodItemRecommend;
import com.stadion.api.mapper.ReportWodItemRecommendMapper;


@Service
public class ReportWodItemRecommendService {
	@Autowired
	private ReportWodItemRecommendMapper reportWodItemRecommendMapper;
	
	
	public ReportWodItemRecommend getReportWodItemRecommend(int idx) {
		if(reportWodItemRecommendMapper==null) {return null;}
		
		ReportWodItemRecommend reportWodItemRecommend = reportWodItemRecommendMapper.getReportWodItemRecommend(idx);
		
		return reportWodItemRecommend;
	}
	
}
