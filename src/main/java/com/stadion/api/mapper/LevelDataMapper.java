package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.LevelData;

@Mapper
public interface LevelDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public LevelData getLevelData(int idx);
	
}
