package com.videoManagement.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.junit.runner.Request;

import com.videoManagement.util.ActionUtil;

public class ShowFlashAction extends ActionUtil{
	private String path;
	private String imagePath;
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Action(value="showFlashAction",results={@Result(name="path",location="/jsp/behind_JSP/resource_manger/existResource/showFlash.jsp")})
	public String  show() {
		this.getRequest().setAttribute("path", path);
		this.getRequest().setAttribute("imagePath", imagePath);
		System.out.println("aa"+path);
		return "path";
	}
}
