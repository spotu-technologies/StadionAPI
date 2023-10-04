package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ReportWodItems;

@Mapper
public interface ReportWodItemsMapper {

	//public List<AccountInfo> getAccountInfoList();
	public ReportWodItems getReportWodItems(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public ReportWodItems getReportWodItemsByEmail(String emailAddress);
	    

}
