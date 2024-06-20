package com.stadion.api.entity;

import java.util.List;

public class LoginInfo {
	public List<AccountInfo> accountInfoList;
	//public AccountInfo accountInfo;
	public List<EventBoard> eventBoardList;
	public List<NoticeBoard> noticeBoardList;
	
	public List<FileData> fileDataGuideThumnail;    	
	public List<FileData> fileDataGuideVideo;
	public List<FileData> fileDataProfileImage;
	public List<FileData> fileDataMtc;
	public List<FileData> fileDataWod;


	public List<FollowLinkInfo> followLinkInfo;
	public 	List<FollowLinkInfo> followLinkReg;
	
	public List<InjuryData> injuryDataList;
	public List<InjuryInfo> injuryInfoList;
	
	public List<LevelData> levelData;
	
	public List<MovementInfo> movementInfoList;
	public List<MomInfo> momInfoList;
	
	public List<MovementRecordData> movementRecordDataList;
	
	public List<WodBoxLinkInfo> wodBoxLinkInfoList;	
	public List<WodInfo> wodInfoList;	
	public List<WodItemInfo> wodItemInfoList;
	public List<WodItemRecordData> wodItemRecordDataList;
	public WodItemOneRmData wodItemOneRmData;
	public List<WodItemOneRmData> wodItemOneRmDataList;
	public List<WodItemOneRmData> wodItemOneRmDataClubManList;
	public List<WodItemOneRmData> wodItemOneRmDataClubWomanList;
	
	public WodParticipantLinkInfo wodParticipantLinkInfo;
	public List<WodParticipantLinkInfo> wodParticipantLinkInfoList;
	public List<WodItemOneRmData> wodItemOneRmDataPersonalDetailList;
	public List<WodItemOneRmData> wodItemOneRmDataClubList;
	public List<WodItem3RmData> wodItem3RmDataPersonalDetailList;
	public List<WodItem5RmData> wodItem5RmDataPersonalDetaiList;

}