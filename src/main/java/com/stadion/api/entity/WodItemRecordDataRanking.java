package com.stadion.api.entity;

public class WodItemRecordDataRanking {
	@Override
	public String toString() {
		return "WodItemRecordDataRanking [boxIdx=" + boxIdx + ", accountIdx=" + accountIdx + ", wbLinkIdx=" + wbLinkIdx
				+ ", wodStepIdx=" + wodStepIdx + ", wodRecordIdx=" + wodRecordIdx + ", recordType=" + recordType
				+ ", recordUnit=" + recordUnit + ", value=" + value + ", value2=" + value2 + ", gender=" + gender
				+ ", profileImagePath=" + profileImagePath + ", nick=" + accountNick + "]";
	}
	public Integer boxIdx;
	public Integer accountIdx;
	public Integer wbLinkIdx;
	public Integer wodStepIdx;
	public Integer wodRecordIdx;
	public Integer recordType;
	public Integer recordUnit;
	
	public String value;
	public String value2;
	public String gender;
	
	public String profileImagePath;
	public String accountNick;
}
