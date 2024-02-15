package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemRecordData;

@Mapper
public interface WodItemOneRmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemOneRmData getWodItemOneRmData(long idx);
	public List<WodItemOneRmData> getWodItemOneRmDataPersonal(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataPersonalDetail(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataClub(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataClubMan();
	public List<WodItemOneRmData> getWodItemOneRmDataClubWoman();
	public List<WodItemOneRmData> getWodItemOneRmDataClubAll();




}
