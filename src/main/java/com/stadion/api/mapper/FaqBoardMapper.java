package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.FaqBoard;

@Mapper
public interface FaqBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public FaqBoard getFaqBoard(int idx);
	

}
