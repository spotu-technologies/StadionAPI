package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BadgeInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.EventBoard;

@Mapper
public interface BadgeInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public List<BadgeInfo> getBadgeInfo(long categoryIdx);
	

}
