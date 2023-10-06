package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.FileData;

@Mapper
public interface FileDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public FileData getFileData(long idx);
	

}
