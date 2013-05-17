package com.videoManagement.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */

public class Resources implements java.io.Serializable {

	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	// Fields
	private Integer id;
	private Users users;
	private String url;
	private String pageUrl;
	private String title;
	private String content;
	private Date captureTime;
	private String enableds;
	private Integer resourcesType;
	//新增加的多少人喜欢的字段
	private Integer likeNum;
	//审核
	private Integer audit;
	private String clickNums;
	private String resourceSize;
	//1表示上传的资源
	private int origin;
	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	private Set votes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Resources() {
	}

	/** minimal constructor */
	public Resources(Integer id, String url) {
		this.id = id;
		this.url = url;
	}

	/** full constructor */
	public Resources(Integer id, 
			Users users, String url, String pageUrl, String title,
			String content, Date captureTime, String enableds,
			Integer resourcesType, Integer audit, String clickNums,
			String resourceSize, Set votes) {
		this.id = id;
		this.users = users;
		this.url = url;
		this.pageUrl = pageUrl;
		this.title = title;
		this.content = content;
		this.captureTime = captureTime;
		this.enableds = enableds;
		this.resourcesType = resourcesType;
		this.audit = audit;
		this.clickNums = clickNums;
		this.resourceSize = resourceSize;
		this.votes = votes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCaptureTime() {
		return this.captureTime;
	}

	public void setCaptureTime(Date captureTime) {
		this.captureTime = captureTime;
	}

	public String getEnableds() {
		return this.enableds;
	}

	public void setEnableds(String enableds) {
		this.enableds = enableds;
	}

	public Integer getResourcesType() {
		return this.resourcesType;
	}

	public void setResourcesType(Integer resourcesType) {
		this.resourcesType = resourcesType;
	}

	public Integer getAudit() {
		return this.audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getClickNums() {
		return this.clickNums;
	}

	public void setClickNums(String clickNums) {
		this.clickNums = clickNums;
	}

	public String getResourceSize() {
		return this.resourceSize;
	}

	public void setResourceSize(String resourceSize) {
		this.resourceSize = resourceSize;
	}

	public Set getVotes() {
		return this.votes;
	}

	public void setVotes(Set votes) {
		this.votes = votes;
	}

	

}