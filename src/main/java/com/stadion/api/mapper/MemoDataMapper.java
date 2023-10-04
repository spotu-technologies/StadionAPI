package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MemoData;

@Mapper
public interface MemoDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MemoData getMemoData(int idx);
	
}
