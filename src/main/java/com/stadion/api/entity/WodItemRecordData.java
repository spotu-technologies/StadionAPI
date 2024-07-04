package com.stadion.api.entity;

public class WodItemRecordData {

	@Override
	public String toString() {
		return "WodItemRecordData [idx=" + idx + ", wodIdx=" + wodIdx + ", boxIdx=" + boxIdx + ", accountIdx="
				+ accountIdx + ", wbLinkIdx=" + wbLinkIdx + ", wodStepIdx=" + wodStepIdx + ", wodItemIdx=" + wodItemIdx
				+ ", wodRecordIdx=" + wodRecordIdx + ", recordType=" + recordType + ", recordUnit=" + recordUnit
				+ ", grade=" + grade + ", value=" + value + ", value2=" + value2 + ", isOneRm=" + isOneRm + ", gender="
				+ gender + ", age=" + age + ", ageGroup=" + ageGroup + ", height=" + height + ", heightGroup="
				+ heightGroup + ", weight=" + weight + ", weightGroup=" + weightGroup + ", region=" + region
				+ ", regionGroup=" + regionGroup + ", dateYmd=" + dateYmd + ", writer=" + writer + ", status=" + status
				+ ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer wodIdx;
	public Integer boxIdx;
	public Integer accountIdx;
	public Integer wbLinkIdx;
	public Integer wodStepIdx;
	public Integer wodItemIdx;
	public Integer wodRecordIdx;
	public Integer recordType;
	public Integer recordUnit;
	
	public String grade;
	public String value;
	public String value2;
	public String isOneRm;
	public String gender;
	public Integer age;
	public Integer ageGroup;
	public String height;
	public Integer heightGroup;
	public String weight;
	public Integer weightGroup;
	public String region;
	public String regionGroup;
	public Integer dateYmd;
	
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
