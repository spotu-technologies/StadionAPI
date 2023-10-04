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
	
	
	public ReportWodItemRecommend getReportWodItemRecommend(String userId) {
		if(reportWodItemRecommendMapper==null) {return null;}
		
		ReportWodItemRecommend reportWodItemRecommend = reportWodItemRecommendMapper.getReportWodItemRecommend(userId);
		
		return reportWodItemRecommend;
	}
	public ReportWodItemRecommend getReportWodItemRecommendByEmail(String emailAddress) {
		if(reportWodItemRecommendMapper==null) {return null;}
		
		ReportWodItemRecommend reportWodItemRecommend = reportWodItemRecommendMapper.getReportWodItemRecommendByEmail(emailAddress);
		
		return reportWodItemRecommend;
	}

}
