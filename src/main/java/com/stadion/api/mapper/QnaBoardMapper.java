package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.QnaBoard;

@Mapper
public interface QnaBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public QnaBoard getQnaBoard(int idx);
	

}
