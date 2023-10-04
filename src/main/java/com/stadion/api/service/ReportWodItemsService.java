package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.ReportWodItems;
import com.stadion.api.mapper.ReportWodItemsMapper;


@Service
public class ReportWodItemsService {
	@Autowired
	private ReportWodItemsMapper reportWodItemsMapper;
	
	
	public ReportWodItems getReportWodItems(String userId) {
		if(reportWodItemsMapper==null) {return null;}
		
		ReportWodItems reportWodItems = reportWodItemsMapper.getReportWodItems(userId);
		
		return reportWodItems;
	}
	public ReportWodItems getReportWodItemsByEmail(String emailAddress) {
		if(reportWodItemsMapper==null) {return null;}
		
		ReportWodItems reportWodItems = reportWodItemsMapper.getReportWodItemsByEmail(emailAddress);
		
		return reportWodItems;
	}

}
