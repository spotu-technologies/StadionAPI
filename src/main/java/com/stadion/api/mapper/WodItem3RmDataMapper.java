package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItem3RmData;

@Mapper
public interface WodItem3RmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItem3RmData getWodItem3RmData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodItem3RmData getWodItem3RmDataByEmail(String emailAddress);
	    

}
