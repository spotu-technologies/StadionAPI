package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.NoticeBoard;

@Mapper
public interface NoticeBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public NoticeBoard getNoticeBoard(long idx);
	public List<NoticeBoard> getNoticeBoardPopup(long nDay);
	public List<NoticeBoard> getNoticeBoardAll();
	public List<NoticeBoard> getNoticeBoardLast(
			@Param ("start") long start, 
			@Param ("count")long count);
	
	
}
