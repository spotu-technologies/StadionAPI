package com.stadion.api.entity;

public class BoxAccountLinkInfo {

	@Override
	public String toString() {
		return "BoxAccountLinkInfo [idx=" + idx + ", boxIdx=" + boxIdx + ", accountIdx=" + accountIdx + ", writer="
				+ writer + ", status=" + status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime
				+ "]";
	}
	public Integer idx;
	public Integer boxIdx;
	public Integer accountIdx;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
