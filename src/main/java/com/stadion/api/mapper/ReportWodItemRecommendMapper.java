package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ReportWodItemRecommend;

@Mapper
public interface ReportWodItemRecommendMapper {

	//public List<AccountInfo> getAccountInfoList();
	public ReportWodItemRecommend getReportWodItemRecommend(long idx);
	

}
