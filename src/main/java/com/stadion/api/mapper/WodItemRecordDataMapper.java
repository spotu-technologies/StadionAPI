package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.WodItemRecordData;

@Mapper
public interface WodItemRecordDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemRecordData getWodItemRecordData(long idx);
	public List<WodItemRecordData> getWodItemRecordDataRecent(long accountIdx);
	public List<WodItemRecordData> getWodItemRecordDatarecord(long accountIdx);
	public long getWodItemRecordDataBest(long wodIdx) ;

}
