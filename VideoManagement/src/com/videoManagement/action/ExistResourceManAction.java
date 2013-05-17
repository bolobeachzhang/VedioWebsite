package com.videoManagement.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.bean.Sort;
import com.videoManagement.serviceDao.LatestResourceManServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 后台管理跳转 actoin
 * @Author 代兵
 * @Date 2013-3-27, 15:56 PM
 * @mailto 707189384@qq.com 已有资源管理
 */
@Controller
@Result(name="error",location="/WEB-INF/error.jsp")
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class ExistResourceManAction extends ActionUtil {
	@Autowired
	private LatestResourceManServiceDao latestResourceManServiceDao;
	
	int pageSize = 12;
	int offset = 0;
	int curPage = 0;
	private String imageSortType;
	private String flashSortType;

	public String getFlashSortType() {
		return flashSortType;
	}

	public void setFlashSortType(String flashSortType) {
		this.flashSortType = flashSortType;
	}

	public String getImageSortType() {
		return imageSortType;
	}

	public void setImageSortType(String imageSortType) {
		this.imageSortType = imageSortType;
	}

	

	@Action(value = "uploadImages", results = {
			@Result(name = "uploadImages", location = "/jsp/behind_JSP/resource_manger/existResource/uploadImages.jsp") })
	public String uploadImages() throws Exception {
		String hql=null;
		String currentPage = null;
		
		strutsPageBean strutsPageBean = new strutsPageBean();
		
		String imagesSql = "from Sort where sortType = 0";
		List<Sort> imagesSorts = latestResourceManServiceDao.query(imagesSql);
		HttpServletRequest request = this.getRequest();

		if(request.getParameter("imageSortType")!=null && request.getParameter("imageSortType").equals("")){
			imageSortType = request.getParameter("imageSortType");
		}
		
		currentPage = request.getParameter("currentPage");
		
		if (currentPage != null) {
			curPage = Integer.valueOf(currentPage);
			offset = ((curPage - 1) * pageSize);
		} else {
			curPage=1;
		}
		if(imageSortType!=null && !imageSortType.equals("")){
			imageSortType = new String(imageSortType.getBytes("ISO8859_1"), "UTF8");
			hql = "from Images where origin = 1 and audit = 1  and imageType = '"+imageSortType+"'";
			request.setAttribute("imageSortType", imageSortType);
		}else {
			hql = "from Images where origin = 1 and audit = 1";
		}
		
		int totleRows = latestResourceManServiceDao.affectNumber(hql, null);
		List<Images> images = latestResourceManServiceDao.findByPage(hql,
				offset, pageSize);
		
		// 判断该页是否有数据
		if (images.size() == 0 && curPage > 1) {
				curPage = curPage - 1;
				offset = ((curPage - 1) * pageSize);
				images = latestResourceManServiceDao.findByPage(hql,
						offset, pageSize);
		}
		
			
			strutsPageBean strutsPageBean2 = strutsPageBean.getstrutsPageBean(
					pageSize, curPage, totleRows);
			
			request.setAttribute("exitImage", images);
			request.setAttribute("strutsPageBean2", strutsPageBean2);
			request.setAttribute("imagesSorts", imagesSorts);
			
			return "uploadImages";
		

	}

	/**
	 * uploadVedio主页跳转
	 * 
	 */
	@Action(value = "uploadVedio", results = {
			@Result(name = "uploadVedio", location = "/jsp/behind_JSP/resource_manger/existResource/uploadVedio.jsp")})
	public String uploadVedio() throws Exception {
		
		String currentPage = null;
		String hql = null;
		
		HttpServletRequest request = this.getRequest();
		strutsPageBean strutsPageBean = new strutsPageBean();
		
		currentPage = request.getParameter("currentPage");
		
		String flashSql = "from Sort where sortType = 1";
		List<Sort> flashSorts = latestResourceManServiceDao.query(flashSql);
		
		if(request.getParameter("flashSortType")!=null && request.getParameter("flashSortType").equals("")){
			flashSortType = request.getParameter("flashSortType");
		}
		
		if (currentPage != null) {
			curPage = Integer.valueOf(currentPage);
			offset = ((curPage - 1) * pageSize);
		} else {
			curPage = 1;
		}
		
		if(flashSortType!=null && !flashSortType.equals("")){
			flashSortType = new String(flashSortType.getBytes("ISO8859_1"), "UTF8");
			hql = "from FlashVedio where origin = 1 and audit = 1 and flashType = '"+flashSortType+"'";
			request.setAttribute("flashSortType", flashSortType);
		}else {
			hql = "from FlashVedio where origin = 1 and audit = 1";
		}
		int totleRows = latestResourceManServiceDao.affectNumber(hql, null);
		List<FlashVedio> flashVedios = latestResourceManServiceDao.findByPage(
				hql, offset, pageSize);
		// 判断该页是否有数据
		if (flashVedios.size() == 0 && curPage > 1) {
			int cPage = Integer.valueOf(currentPage) - 1;
			curPage = curPage-1;
			offset = ((curPage - 1) * pageSize);
			flashVedios = latestResourceManServiceDao.findByPage(
					hql, offset, pageSize);
		}
		
		strutsPageBean strutsPageBean2 = strutsPageBean.getstrutsPageBean(
				pageSize, curPage, totleRows);
		request.setAttribute("flashVedios", flashVedios);
		request.setAttribute("strutsPageBean2", strutsPageBean2);
		request.setAttribute("flashSorts", flashSorts);
		
		return "uploadVedio";
	}
}
