package com.videoManagement.action;

import java.sql.Struct;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.bean.Sort;
import com.videoManagement.serviceDao.LatestResourceManServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.PictureDown;
import com.videoManagement.util.strutsPageBean;

/**
 * 
 * @ClassName:LatestResourceManAction
 * @Description: TODO(这个是用来处理视频资源还没有通过审核的)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-28 下午1:14:01
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class LatestResourceManAction extends ActionUtil {
	@Autowired
	private LatestResourceManServiceDao latestResourceManServiceDao;
	private HttpServletRequest request;
	
	private String sortName;//图片和视频类型
	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * vedio跳转
	 * 
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Action(value = "vedio", results = { @Result(name = "vedio", location = "/jsp/behind_JSP/resource_manger/newResource/vedio.jsp") })
	public String vedio() throws Exception {
		int pageSize = 12;
		int offset = 0;
		if (currentPage != null && Integer.valueOf(currentPage)!=0) {
			if (Integer.valueOf(currentPage)==1) {
				offset = 0;
			}else {
				offset = (Integer.valueOf(currentPage)-1) * pageSize;
			}
		} else {
			currentPage = 1 + "";
		}
		
		//同时我们还需要把分类表查询出来
		String  hqlSort = "from Sort where sortType= ?";
		Object[] object = new Object[]{1};//1表示视频的分类
		List<Sort> sorts = latestResourceManServiceDao.query(hqlSort, object);
		
		
		//在这里需要查询视频信息 把为审核的查询出来
		//orign 如果为0表示是抓取的
		//audit 0 表示未审核的
		String hql = "from FlashVedio where origin = ? and audit=?";
		int totleRows = latestResourceManServiceDao.affectNumber(hql,
				new Object[] {0,0});
		
		List<FlashVedio> flashVedios = latestResourceManServiceDao.findByPage2(
				hql, offset, pageSize, new Object[] {0,0});
		
		
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean2 = strutsPageBean.getstrutsPageBean(
				pageSize, Integer.valueOf(currentPage), totleRows);
		
		
		request = this.getRequest();
		request.setAttribute("sorts", sorts);
		request.setAttribute("flashVedios", flashVedios);
		request.setAttribute("strutsPageBean2", strutsPageBean2);
		return "vedio";
	}

	/**
	 * imagesTest主页跳转
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "imagesTest", results = { @Result(name = "images", location = "/jsp/behind_JSP/resource_manger/newResource/images.jsp") })
	public String images() throws Exception {
		HttpServletRequest request = this.getRequest();
		//同时我们还需要把分类表查询出来
		String  hqlSort = "from Sort where sortType= ?";
		Object[] object = new Object[]{0};//0表示图片的分类
		List<Sort> sorts = latestResourceManServiceDao.query(hqlSort, object);
		request.setAttribute("sorts", sorts);
		
		int pageSize = 12;
		int offset = 0;
		if (currentPage != null && Integer.valueOf(currentPage)!=0) {
			offset = (Integer.valueOf(currentPage)-1) * pageSize;
		} else {
			currentPage = 1 + "";
		}
		// audit = 0 表示未审核
		// resoucresType = 0 表示图片
		String hql = "from Images where origin = ? and audit=? and resourcesType =?";
		Object[] params = new Object[] {0, 0,0};
		int totleRows = latestResourceManServiceDao.affectNumber(hql, params);
		List<Images> images = latestResourceManServiceDao.findByPage2(hql,
				offset, pageSize, params);
		
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean1 = strutsPageBean.getstrutsPageBean(
				pageSize, Integer.valueOf(currentPage), totleRows);
		request.setAttribute("images", images);
		request.setAttribute("strutsPageBean1", strutsPageBean1);
		
		
		return "images";
	}

	/**
	 * 
	 * @Title: deleteVideo
	 * @Description: TODO(删除一个或者多个视频,或者发布一个或者多个视频)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * 
	 */
	@SuppressWarnings("unused")
	@Action(value = "deleteVideo", results = { @Result(name = "vedio", type = "chain", location = "vedio") })
	public String deleteVideo() throws Exception {
		HttpServletRequest request = this.getRequest();
		String type = request.getParameter("type");
		String publish = request.getParameter("publish");
		String videoId = request.getParameter("videoId");
		String sortName = request.getParameter("sortName");
		System.out.println(publish);
		// 如果是发布按钮
		if (videoId != null && publish.equals("publish")) {
			String sort = new String(sortName.getBytes("ISO-8859-1"),"UTF-8");
			String hql = "update FlashVedio  set audit = ?,flashType=? where id=?";
			latestResourceManServiceDao.update(hql,
					new Object[] { 1,sort, Integer.valueOf(videoId) });
			return "vedio";
		}
		if (videoId!=null && publish.equals("delete")) {
			String hql = "delete FlashVedio where id=?";
			latestResourceManServiceDao.deleteByHql(hql,
					new Object[] { Integer.valueOf(videoId) });
			return "vedio";
		}
		
		
		String[] checkbox = request.getParameterValues("checkboxFlashId");
		if (checkbox == null) {
			return "error";
		} else {
			// 说明是发布按钮
			if ("publish".equals(type)) {
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "update FlashVedio  set audit = ?,flashType=? where id=?";
					latestResourceManServiceDao.update(hql, new Object[] { 1,sortName,
							Integer.valueOf(id) });
				}
				return "vedio";
			} else if ("delete".equals(type)) {// 说明是删除按钮
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "delete FlashVedio where id=?";
					latestResourceManServiceDao.deleteByHql(hql,
							new Object[] { Integer.valueOf(id) });
				}
				return "vedio";
			} else {
				return "error";
			}
		}

	}

	@SuppressWarnings("unused")
	@Action(value = "deleteImages", results = { @Result(name = "images", type = "chain", location = "imagesTest") })
	public String deleteImages() throws Exception {
		HttpServletRequest request = this.getRequest();
		String type = request.getParameter("type");
		String publish = request.getParameter("publish");
		String imageId = request.getParameter("imageId");
		String[] checkbox = request.getParameterValues("checkbox");
		if (imageId != null && publish.equals("delete")) {
			String hql = "delete Images where id=?";
			latestResourceManServiceDao.deleteByHql(hql,
					new Object[] { Integer.valueOf(imageId) });
			return "images";
		}
		// 如果是发布按钮
		if (imageId != null && publish.equals("publish")) {
			System.out.println("发布按钮进来了。。");
			String sort = new String(sortName.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(sort);
			String hql = "update Images  set audit = ?,imageType=? where id=?";
			latestResourceManServiceDao.update(hql,
					new Object[] { 1,sort, Integer.valueOf(imageId) });
			return "images";
		}
		if (checkbox == null) {
			return "error";
		} else {
			// 说明是发布按钮
			if ("publish".equals(type)) {
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					System.out.println(sortName+"*******************");
					String hql = "update Images  set audit = ?,imageType=? where id=?";
					latestResourceManServiceDao.update(hql, new Object[] { 1,sortName,
							Integer.valueOf(id) });
				}
				return "images";
			} else if ("delete".equals(type)) {// 说明是删除按钮
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "delete Images where id=?";
					latestResourceManServiceDao.deleteByHql(hql,
							new Object[] { Integer.valueOf(id) });
				}
				return "images";
			} else {
				return "error";
			}
		}
	}
}
