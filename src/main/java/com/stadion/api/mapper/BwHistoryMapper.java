package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BwHistory;

@Mapper
public interface BwHistoryMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BwHistory getBwHistory(long idx);


}
