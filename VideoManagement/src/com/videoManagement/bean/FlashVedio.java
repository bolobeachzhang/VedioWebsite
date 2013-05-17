package com.videoManagement.bean;

public class FlashVedio extends Resources implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	//flash分类
	private String flashType;
	
	public String getFlashType() {
		return flashType;
	}

	public void setFlashType(String flashType) {
		this.flashType = flashType;
	}
	//是否转码，1表示已经转码
	private Integer transcoding;
	
	public Integer getTranscoding() {
		return transcoding;
	}

	public void setTranscoding(Integer transcoding) {
		this.transcoding = transcoding;
	}

	//时间长度
	private String flashTime;
	//详细信息
	private String detailInfo;
	private String flashvedioType;
	public String getFlashvedioType() {
		return flashvedioType;
	}

	public void setFlashvedioType(String flashvedioType) {
		this.flashvedioType = flashvedioType;
	}
	private String flashImagePath;
	public String getFlashImagePath() {
		return flashImagePath;
	}

	public void setFlashImagePath(String flashImagePath) {
		this.flashImagePath = flashImagePath;
	}

	public FlashVedio() {
	}

	public String getFlashTime() {
		return this.flashTime;
	}

	public void setFlashTime(String flashTime) {
		this.flashTime = flashTime;
	}

	public String getDetailInfo() {
		return this.detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	
}