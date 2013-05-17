package com.videoManagement.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.bean.Resources;
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
 * @Date  2013-3-27, 15:56  PM
 * @mailto 707189384@qq.com
 * 上传资源管理
 */
public class UploadResourceManAction extends ActionUtil {
	
	@Resource
	private BasicServiceImp basicServiceImp;
	
	private String content;
	private String title;
	private int id;
	private String change;
	
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Action(value="AdminUploadResource",results={@Result(name="AdminUploadResource",location="/jsp/behind_JSP/resource_manger/uploadResource/AdminUploadResource.jsp")})
	public String AdminUploadResource() throws Exception {
		String imagesSql = "from Sort where sortType = 0";
		String flashSql = "from Sort where sortType = 1";
		List<Sort> imagesSorts = basicServiceImp.query(imagesSql);
		List<Sort> flashSorts = basicServiceImp.query(flashSql);
		HttpServletRequest request = this.getRequest();
		request.setAttribute("imagesSorts", imagesSorts);
		request.setAttribute("flashSorts", flashSorts);
		return "AdminUploadResource";
	}
	
	@Autowired
	private LatestResourceManServiceDao latestResourceManServiceDao;
	@Action(value="UserUploadResource",results={@Result(name="UserUploadResource",location="/jsp/behind_JSP/resource_manger/uploadResource/UserUploadResource.jsp")})
	public String UserUploadResource() throws Exception {
		String currentPage = this.getRequest().getParameter("currentPage");
		
		int pageSize = 12;
		int offset = 0;
		if (currentPage!=null) {
			offset = (Integer.valueOf(currentPage)-1)*pageSize;
		}else {
			currentPage = 1+"";
		}
		String hql = "from Images where origin = 1 and content is null and audit = 1";
		int totleRows = latestResourceManServiceDao.affectNumber(hql, null);
		List<Images> images = latestResourceManServiceDao.findByPage(hql, offset, pageSize);
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean2  = strutsPageBean.getstrutsPageBean(pageSize, Integer.valueOf(currentPage), totleRows);
		this.getRequest().setAttribute("images", images);
		this.getRequest().setAttribute("strutsPageBean2", strutsPageBean2);
		if(change!=null){
			this.getRequest().setAttribute("change", change);
		}
		return "UserUploadResource";
	}
	@Action(value="manageUserUploadeImages",results={@Result(name="manageUserUploadeImages",location="/jsp/behind_JSP/resource_manger/uploadResource/ManageUserUploadeImages.jsp")})
	public String ManageUserUploadeImages(){
		return "manageUserUploadeImages";
	}
	@Action(value="manageUserUploadeFlash",results={@Result(name="manageUserUploadeFlash",location="/jsp/behind_JSP/resource_manger/uploadResource/ManageUserUploadeFlash.jsp")})
	public String ManageUserUploadeFlash(){
		return "manageUserUploadeFlash";
	}
	@Action(value="addFlashmsg",results={@Result(name="addFlashmsg",location="/jsp/behind_JSP/resource_manger/uploadResource/Uploadflash.jsp")})
	public String addFlashmsg(){
		int pageSize = 12;
		String currentPage = this.getRequest().getParameter("currentPage");
		int offset = 0;
		if (currentPage!=null) {
			offset = (Integer.valueOf(currentPage)-1)*pageSize;
		}else {
			currentPage = 1+"";
		}
		String hql = "from FlashVedio where origin = 1 and content is null and audit = 1";
		int totleRows = latestResourceManServiceDao.affectNumber(hql, null);
		List<FlashVedio> flashVedios = latestResourceManServiceDao.findByPage(hql, offset, pageSize);
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean2  = strutsPageBean.getstrutsPageBean(pageSize, Integer.valueOf(currentPage), totleRows);
		this.getRequest().setAttribute("flashVedios", flashVedios);
		this.getRequest().setAttribute("strutsPageBean2", strutsPageBean2);
		if(change!=null){
			this.getRequest().setAttribute("change", change);
		}
		return "addFlashmsg";
	}
	@Action(value="ImagesMsg")
	public String addImagesMsg(){
		if(id!=0){
			String sql = "from Resources where id = "+id;
			List<Resources> resources = basicServiceImp.query(sql);
			Resources resource = resources.get(0);
			resource.setTitle(title);
			resource.setContent(content);
			basicServiceImp.update(resource);
		}else {
			String hql = "from Resources where origin = 1 and content is null and audit = 1";
			List<Resources> resources = basicServiceImp.query(hql);
			for(Resources resource :resources){
				resource.setTitle(title);
				resource.setContent(content);
				basicServiceImp.update(resource);
			}
		}
		return "addImagesMsg";
		
	}
}
