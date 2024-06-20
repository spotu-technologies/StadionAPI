package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.MovementRecordData;

@Mapper
public interface LevelDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public List<LevelData> getLevelData(long accountIdx);
	public List<LevelData> getLevelDataLevel( @Param ("accountIdx") long accountIdx, @Param ("longYear") long year);
	public int insertLevelData(LevelData arg);
	
}
