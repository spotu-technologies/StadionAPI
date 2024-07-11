package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.NumbersRankData;
import com.stadion.api.entity.NumbersRankDataIdx;
import com.stadion.api.entity.WodItemInsertRmData;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemOneRmDataHistory;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodItemRmData;

@Mapper
public interface WodItemOneRmDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemOneRmData getWodItemOneRmData(long idx);
	public List<WodItemOneRmData> getWodItemOneRmDataPersonal(long accountIdx);
	public List<WodItemOneRmDataHistory> getWodItemOneRmDataPoundHistory(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataPersonalDetail(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataClub(long accountIdx);
	public List<NumbersRankDataIdx> getWodItemOneRmPoundClubByGender(@Param("gender") String gender);
	public NumbersRankData getNumbersRankData(long accountIdx);
	public String getNumbersRankDataDeadLift(long accountIdx);
	public String getNumbersRankDataBenchPress(long accountIdx);
	public String getNumbersRankDataSquat(long accountIdx);
	public List<WodItemOneRmData> getWodItemOneRmDataClubMan();
	public List<WodItemOneRmData> getWodItemOneRmDataClubWoman();
	public List<WodItemOneRmData> getWodItemOneRmDataClubAll();

	public List<WodItemRmData> getWodItemRmData(@Param ("rmType") String rmType, @Param ("accountIdx") long accountIdx);
	public int insertPersonalBest(WodItemInsertRmData arg);


}
