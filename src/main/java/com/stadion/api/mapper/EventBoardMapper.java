package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;

@Mapper
public interface EventBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public EventBoard getEventBoard(int idx);
	

}
