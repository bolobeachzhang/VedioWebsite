package com.videoManagement.bean;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resources resources;
	private Timestamp commentTime;
	private String commentConent;
	private String commentName;
	private String userIp;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Comment(Integer id, Resources resources,
			Timestamp commentTime, String commentConent, String commentName,
			String userIp) {
		this.id = id;
		this.resources = resources;
		this.commentTime = commentTime;
		this.commentConent = commentConent;
		this.commentName = commentName;
		this.userIp = userIp;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resources getResources() {
		return this.resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}
	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentConent() {
		return this.commentConent;
	}

	public void setCommentConent(String commentConent) {
		this.commentConent = commentConent;
	}

	public String getCommentName() {
		return this.commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
}