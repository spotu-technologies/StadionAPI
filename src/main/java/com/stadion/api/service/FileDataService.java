package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.FileData;
import com.stadion.api.mapper.FileDataMapper;


@Service
public class FileDataService {
	@Autowired
	private FileDataMapper fileDataMapper;
	
	
	public FileData getFileData(String userId) {
		if(fileDataMapper==null) {return null;}
		
		FileData fileData = fileDataMapper.getFileData(userId);
		
		return fileData;
	}
	public FileData getFileDataByEmail(String emailAddress) {
		if(fileDataMapper==null) {return null;}
		
		FileData fileData = fileDataMapper.getFileDataByEmail(emailAddress);
		
		return fileData;
	}

}
