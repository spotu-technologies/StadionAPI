package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomRankData;
import com.stadion.api.entity.MomRankDataResult;
import com.stadion.api.entity.RankingDataParameter;

@Mapper
public interface MomRankDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomRankData getMomRankData(long idx);
	public MomRankData getMomRankingData(long momIdx);
	public List<MomRankDataResult> getMomRankingDataList(RankingDataParameter param);
/*			@Param("momIdx") long momIdx, 
			@Param("dynamicColumn") String dynamicColumn,
			@Param("orderType")String orderType,
			@Param("year") long year,
			@Param("start") long start,
			@Param("count") long count,
			@Param("minMax") String minMax
			);*/
	
}
