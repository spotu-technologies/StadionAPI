package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.entity.WodRecordInfoWithBox;

@Mapper
public interface WodRecordInfoMapper {

	public WodRecordInfo getWodRecordInfo(long idx);
	public List<WodRecordInfo> getWodRecordInfoByWodIdx(long wodIdx);
	public List<WodRecordInfoWithBox> getWodRecordInfoRecentByWod(@Param ("accountIdx") long accountIdx, @Param ("wodIdx") long wodIdx);
}
