package com.videoManagement.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Sort;
import com.videoManagement.serviceImp.ManageSortImp;
import com.videoManagement.util.ActionUtil;

public class SortAction extends BasicServiceImp{
	
	private static final long serialVersionUID = 1L;
	private int sortType;
	private String name;
	
	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Action(value="aaa",results={@Result(name="aaaaaa",location="/jsp/behind_JSP/resource_manger/uploadResource/AdminUploadResource.jsp")})
	public String saveOneSort(){
		Sort sort = new Sort();
		Sort sort1 = new Sort();
		Sort sort2 = new Sort();
		Sort sort3 = new Sort();
		Sort sort4 = new Sort();
		sort.setSortName("美女");
		sort.setSortType(0);
		sort1.setSortName("宇宙");
		sort1.setSortType(0);
		sort2.setSortName("非主流");
		sort2.setSortType(0);
		sort3.setSortName("动漫");
		sort3.setSortType(0);
		sort4.setSortName("大海");
		sort4.setSortType(0);
		this.save(sort4);
		this.save(sort3);
		this.save(sort2);
		this.save(sort1);
		this.save(sort);
		return "aaaaaa";
	}
}
