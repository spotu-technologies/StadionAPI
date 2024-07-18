package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.RankingDataParameter;
import com.stadion.api.entity.ScaleGender;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodItemRecordDataRanking;

@Mapper
public interface WodItemRecordDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public List<WodItemRecordData> getWodItemRecordData(long accountIdx);
	public List<WodItemRecordData> getWodItemRecordDataByWodIdx(long wodIdx);

	public Double getWodItemRecordDataByWodAvg(long wodidx);
	public Double getWodItemRecordDataByWodBest(@Param("wodIdx") long wodidx, @Param("minMax") String minMax);
	public List<WodItemRecordData> getWodItemRecordDataRecent(long accountIdx);
	public List<WodItemRecordData> getWodItemRecordDatarecord(long accountIdx);
	public long getWodItemRecordDataBest(long wodIdx) ;
	public List<WodItemRecordData> getRankingScale(long wodIdx);
	public List<String> getRankingScaleString(long wodIdx);
	public List<ScaleGender> getRankingScaleGender(long wodIdx);
	public int insertWodItemRecord(WodItemRecordData arg);
	public List<WodItemRecordData> getWodItemRecordRankingList(RankingDataParameter param);
	public List<WodItemRecordData> getWodItemRecordListByWodIdx(long wodIdx);
}
