package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.PolicyBoard;

@Mapper
public interface PolicyBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PolicyBoard getPolicyBoard(long idx);
	

}
