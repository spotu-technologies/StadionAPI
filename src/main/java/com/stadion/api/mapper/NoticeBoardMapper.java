package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.NoticeBoard;

@Mapper
public interface NoticeBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public NoticeBoard getNoticeBoard(int idx);
	
}
