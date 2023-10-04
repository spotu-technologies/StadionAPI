package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WithdrawData;

@Mapper
public interface WithdrawDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WithdrawData getWithdrawData(int idx);
	

}
