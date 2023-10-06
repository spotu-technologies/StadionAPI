package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ReportWodItems;

@Mapper
public interface ReportWodItemsMapper {

	//public List<AccountInfo> getAccountInfoList();
	public ReportWodItems getReportWodItems(long idx);
	

}
