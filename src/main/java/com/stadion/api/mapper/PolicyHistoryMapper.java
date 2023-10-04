package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.PolicyHistory;

@Mapper
public interface PolicyHistoryMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PolicyHistory getPolicyHistory(int idx);
	

}
