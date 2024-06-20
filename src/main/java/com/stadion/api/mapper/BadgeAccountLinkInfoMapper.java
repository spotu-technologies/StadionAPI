package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.stadion.api.entity.BadgeAccountLinkInfo;

@Mapper
public interface BadgeAccountLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public List<BadgeAccountLinkInfo> getBadgeAccountLinkInfo(long accountIdx);
	

}
