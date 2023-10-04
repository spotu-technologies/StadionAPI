package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.GuideBoard;

@Mapper
public interface GuideBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public GuideBoard getGuideBoard(int idx);
	
}
