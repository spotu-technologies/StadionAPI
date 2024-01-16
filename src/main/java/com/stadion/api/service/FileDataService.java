package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.FileData;
import com.stadion.api.entity.LevelData;
import com.stadion.api.mapper.FileDataMapper;


@Service
public class FileDataService {
	@Autowired
	private FileDataMapper fileDataMapper;
	
	public List<FileData> getFileDataMts(String fileKind, long tableLinkIdx, long pIdx) {
		if(fileDataMapper==null) {return null;}
		
		List<FileData> fileDataList = fileDataMapper.getFileDataMts(fileKind, tableLinkIdx, pIdx);
		
		return fileDataList;
	}
	
	public List<FileData> getFileDataImage(String fileKind, long tableLinkIdx, long pIdx) {
		if(fileDataMapper==null) {return null;}
		
		List<FileData> fileDataList = fileDataMapper.getFileDataImage(fileKind, tableLinkIdx, pIdx);
		
		return fileDataList;
	}
	
	public List<FileData> getFileDataFile(String fileKind, long tableLinkIdx, long pIdx) {
		if(fileDataMapper==null) {return null;}
		
		List<FileData> fileDataList = fileDataMapper.getFileDataFile(fileKind, tableLinkIdx, pIdx);
		
		return fileDataList;
	}
	
	
	public FileData getFileData(long idx) {
		if(fileDataMapper==null) {return null;}
		
		FileData fileData = fileDataMapper.getFileData(idx);
		
		return fileData;
	}
	
}
