package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.PushBoard;

@Mapper
public interface PushBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PushBoard getPushBoard(long idx);
	

}
