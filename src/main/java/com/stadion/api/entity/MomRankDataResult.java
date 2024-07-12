package com.stadion.api.entity;

public class MomRankDataResult {
	@Override
	public String toString() {
		return "MomRankDataResult [idx=" + idx + ", momIdx=" + momIdx + ", accountIdx=" + accountIdx + ", mpLinkIdx="
				+ mpLinkIdx + ", point=" + point + ", gender=" + gender + ", age=" + age + ", ageGroup=" + ageGroup
				+ ", height=" + height + ", heightGroup=" + heightGroup + ", weight=" + weight + ", weightGroup="
				+ weightGroup + ", region=" + region + ", regionGroup=" + regionGroup + ", writer=" + writer
				+ ", status=" + status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime
				+ "\n, accountID=" + accountID + ", accountName=" + accountName + ", accountNick=" + accountNick
				+ ", emailAddress=" + emailAddress + ", cellNumber=" + cellNumber
				+ "\n, lfl=" + lfl + ", recordValue=" + recordValue
				+ "]";
	}
	public Integer idx;
	public Integer momIdx;
	public Integer accountIdx;
	public Integer mpLinkIdx;
	public Integer point;
	public String gender;
	public Integer age;
	public Integer ageGroup;
	public String height;
	public Integer heightGroup;
	public String weight;
	public Integer weightGroup;
	public String region;
	public String regionGroup;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	
	public String accountID;
	public String accountName;
	public String accountNick;
	public String emailAddress;	
	public String cellNumber;
	
	public String lfl;
	public String recordValue;
	public String filePath; 
	public String fileNameThumb;
}
