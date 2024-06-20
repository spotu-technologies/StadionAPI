package com.stadion.api.entity;

public class PolicyAgreeData {

	@Override
	public String toString() {
		return "PolicyAgreeData [idx=" + idx + ", policyBoardIdx=" + policyBoardIdx + ", policyType=" + policyType
				+ ", writer=" + writer + ", status=" + status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime="
				+ lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer policyBoardIdx;
	public Integer policyType;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
