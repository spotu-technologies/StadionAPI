package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.PolicyAgreeData;

@Mapper
public interface PolicyAgreeDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PolicyAgreeData getPolicyAgreeData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public PolicyAgreeData getPolicyAgreeDataByEmail(String emailAddress);
	    

}
