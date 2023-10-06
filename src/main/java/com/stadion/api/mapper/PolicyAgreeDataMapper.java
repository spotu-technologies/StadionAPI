package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.PolicyAgreeData;

@Mapper
public interface PolicyAgreeDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PolicyAgreeData getPolicyAgreeData(long idx);
	

}
