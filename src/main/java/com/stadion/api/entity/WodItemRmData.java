package com.stadion.api.entity;

public class WodItemRmData {
	@Override
	public String toString() {
		return "WodItemOneRmData [idx=" + idx + ", accountIdx=" + accountIdx + ", wodItemIdx=" + wodItemIdx
				+ ", recordType=" + recordType + ", recordUnit=" + recordUnit + ", value=" + value + ", value2="
				+ value2 + ", writer=" + writer + ", status=" + status + ", regUnixtime=" + regUnixtime
				+ ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	
	public Integer idx;
	public Integer accountIdx;
	public Integer wodItemIdx;
	public Integer recordType;
	public Integer recordUnit;
	public String value;
	public String value2;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
