package com.stadion.api.entity;

public class MovementRecordData {

	@Override
	public String toString() {
		return "MovementRecordData [idx=" + idx + ", movementIdx=" + movementIdx + ", momIdx=" + momIdx + ", mvLinkIdx="
				+ mvLinkIdx + ", mpLinkIdx=" + mpLinkIdx + ", accountIdx=" + accountIdx + ", memoIdx=" + memoIdx
				+ ", injuryIdx=" + injuryIdx + ", value=" + value + ", value2=" + value2 + ", recordType=" + recordType
				+ ", point=" + point + ", gradeLevel=" + gradeLevel + ", pIdx=" + pIdx + ", noRapReason=" + noRapReason
				+ ", gender=" + gender + ", age=" + age + ", ageGroup=" + ageGroup + ", height=" + height
				+ ", heightGroup=" + heightGroup + ", weight=" + weight + ", weightGroup=" + weightGroup + ", region="
				+ region + ", regionGroup=" + regionGroup + ", dateYmd=" + dateYmd + ", writer=" + writer + ", status="
				+ status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer movementIdx;
	public Integer momIdx;
	public Integer mvLinkIdx;
	public Integer mpLinkIdx;
	public Integer accountIdx;
	public Integer memoIdx;
	public Integer injuryIdx;
	public String value;
	public String value2;
	public Integer recordType;
	public Integer point;
	public String gradeLevel;
	public Integer pIdx;
	public String noRapReason;
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
