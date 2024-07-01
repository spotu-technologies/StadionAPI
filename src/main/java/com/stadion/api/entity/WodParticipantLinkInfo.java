package com.stadion.api.entity;

public class WodParticipantLinkInfo {

	@Override
	public String toString() {
		return "WodParticipantLinkInfo [idx=" + idx + ", wodIdx=" + wodIdx + ", boxIdx=" + boxIdx + ", wbLinkIdx="
				+ wbLinkIdx + ", accountIdx=" + accountIdx + ", writer=" + writer + ", status=" + status
				+ ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + ", isAttend=" + isAttend
				+ "]";
	}
	public Integer idx;
	public Integer wodIdx;
	public Integer boxIdx;
	public Integer wbLinkIdx;
	public Integer accountIdx;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	public String isAttend;
}
