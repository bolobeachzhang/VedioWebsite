package com.videoManagement.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Sort entity. @author MyEclipse Persistence Tools
 */

public class Sort implements java.io.Serializable {

	// Fields


	private Integer id;
	private String sortName;
	private Integer sortType;
    
	// Constructors

	/** default constructor */
	public Sort() {
	}

	/** minimal constructor */
	public Sort(Integer id, String sortName) {
		this.id = id;
		this.sortName = sortName;
	}

	/** full constructor */
	public Sort(Integer id, String sortName, Integer sortType) {
		this.id = id;
		this.sortName = sortName;
		this.sortType = sortType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSortName() {
		return this.sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getSortType() {
		return this.sortType;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}

}