package com.videoManagement.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools ModifyTime 2013-3-28 9:36
 * ModifyAuthor 代兵
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String email;
	private Date registTime;
	private String passWord;
	private String userImageUrl;
	private Integer userType;
	private String sex;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	private Set resourceses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Integer id, String userName, String email, String passWord) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
	}

	/** full constructor */
	public Users(Integer id, String userName, String email, Date registTime,
			String passWord, String userImageUrl, Integer userType,
			String audit, String auditUser, Date auditTime, Set resourceses) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.registTime = registTime;
		this.passWord = passWord;
		this.userImageUrl = userImageUrl;
		this.userType = userType;
		this.resourceses = resourceses;
	}

	public Users(Integer id, String userName, String email, Date registTime,
			String passWord, String userImageUrl, Integer userType,
			String audit, String auditUser, Date auditTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.registTime = registTime;
		this.passWord = passWord;
		this.userImageUrl = userImageUrl;
		this.userType = userType;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserImageUrl() {
		return this.userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Set getResourceses() {
		return this.resourceses;
	}

	public void setResourceses(Set resourceses) {
		this.resourceses = resourceses;
	}

}