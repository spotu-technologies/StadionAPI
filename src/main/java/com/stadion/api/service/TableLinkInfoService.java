package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.TableLinkInfo;
import com.stadion.api.mapper.TableLinkInfoMapper;


@Service
public class TableLinkInfoService {
	@Autowired
	private TableLinkInfoMapper tableLinkInfoMapper;
	
	
	public TableLinkInfo getTableLinkInfo(long idx) {
		if(tableLinkInfoMapper==null) {return null;}
		
		TableLinkInfo tableLinkInfo = tableLinkInfoMapper.getTableLinkInfo(idx);
		
		return tableLinkInfo;
	}
	
}
