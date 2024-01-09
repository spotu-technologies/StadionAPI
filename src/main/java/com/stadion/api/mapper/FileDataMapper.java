package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.LevelData;

@Mapper
public interface FileDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public FileData getFileData(long idx);
	public List<FileData> getFileDataFile( 
			@Param ("fileKind") String fileKind, 
			@Param ("tableLinkIdx") long tableLinkIdx, 
			@Param ("pIdx") long pIdx);
	
	public List<FileData> getFileDataImage( 
			@Param ("fileKind") String fileKind, 
			@Param ("tableLinkIdx") long tableLinkIdx, 
			@Param ("pIdx") long pIdx);
	

}
