package com.stadion.api.entity;

public class FileData {

	@Override
	public String toString() {
		return "FileData [idx=" + idx + ", tableLinkIdx=" + tableLinkIdx + ", pIdx=" + pIdx + ", filePath=" + filePath
				+ ", fileTitle=" + fileTitle + ", fileNameOrg=" + fileNameOrg + ", fileNameNew=" + fileNameNew
				+ ", fileNameThumb=" + fileNameThumb + ", fileSize=" + fileSize + ", fileExt=" + fileExt + ", fileType="
				+ fileType + ", fileKind=" + fileKind + ", fileSort=" + fileSort + ", writer=" + writer + ", status="
				+ status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer tableLinkIdx;
	public Integer pIdx;
	public String filePath;
	public String fileTitle;
	public String fileNameOrg;
	public String fileNameNew;
	public String fileNameThumb;
	public String fileSize;
	public String fileExt;
	public String fileType;
	public String fileKind;
	public Integer fileSort;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
