package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ActionHistory;

@Mapper
public interface ActionHistoryMapper {

	//public List<AccountInfo> getAccountInfoList();
	public ActionHistory getActionHistory(int idx);
	


}

