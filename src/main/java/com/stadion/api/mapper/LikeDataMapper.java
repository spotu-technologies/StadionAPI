package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.LikeData;

@Mapper
public interface LikeDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public LikeData getLikeData(long idx);
	

}
