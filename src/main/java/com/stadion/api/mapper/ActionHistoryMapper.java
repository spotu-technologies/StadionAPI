package com.stadion.api.mapper;


import org.apache.ibatis.annotations.Mapper;


import com.stadion.api.entity.ActionHistory;

@Mapper
public interface ActionHistoryMapper {

	//public List<AccountInfo> getAccountInfoList();
	public ActionHistory getActionHistory(long idx);
	


}

