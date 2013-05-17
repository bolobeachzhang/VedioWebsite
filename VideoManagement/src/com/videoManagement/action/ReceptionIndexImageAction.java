package com.videoManagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.videoManagement.bean.Images;
import com.videoManagement.bean.Sort;
import com.videoManagement.serviceDao.ReceptionIndexImageServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**
 * @ClassName:ReceptionImageAction
 * @Description: TODO(前台图片首页跳转action)
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-1 下午7:41:25
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */
@Controller
@Results({
		@Result(name = "image_index", location = "/jsp/front_JSP/picture_jsp/image_index.jsp"),
		@Result(name = "error", location = "/WEB-INF/error.jsp") })
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class ReceptionIndexImageAction extends ActionUtil {
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Autowired
	private ReceptionIndexImageServiceDao receptionIndexImageServiceDao;

	@SuppressWarnings("unused")
	@Action(value = "receptionImage")
	public String receptionImage() throws Exception {
		String sortsHql = "from Sort where sortType=?";
		// 处理所有的image类型
		List<Sort> sorts = receptionIndexImageServiceDao.query(sortsHql, 0);

		request = this.getRequest();
		int offset = 0;// 默认显示从第0条开始查询
		int pageSize = 50;// 每页显示20条
		int currentPage = 1;
		String getCurrentPage = request.getParameter("currentPage");
		if (getCurrentPage == null || getCurrentPage.equals("")) {
			offset = 0;
		} else {
			currentPage = Integer.valueOf(getCurrentPage);
			offset = (currentPage - 1) * pageSize;
		}
		// 首先默认显示的是美女图片
		String hql = "from Images where audit=? and ImageType=?";
		String imageId = request.getParameter("imageType");
		String imageType = null;
		if (imageId != null) {
			Sort sort = (Sort) receptionIndexImageServiceDao.findById(
					Sort.class, Integer.valueOf(imageId));
			imageType = sort.getSortName();
		}
		if (imageType == null || imageType.equals("")) {
			imageType = "美女";
		}
		Object[] params = new Object[] { 1, imageType };
		int totleRows = receptionIndexImageServiceDao.affectNumber(hql, params);
		strutsPageBean strutsPageBean = new strutsPageBean();
		PrintWriter printWriter = null;
		strutsPageBean strutsPageBean2 = strutsPageBean.getstrutsPageBean(
				pageSize, currentPage, totleRows);
		List<Images> images = receptionIndexImageServiceDao.findByPage2(hql,
				offset, pageSize, params);

		// 获取焦点图
		List<Images> imagesFocus = receptionIndexImageServiceDao.query(
				"from Images i where i.content=? order by imageType","imageFocus");	
		/*for (Images images2 : imagesFocus) {
			System.out.println("图片的类型：：：："+images2.getImageType());
		}*/
		request.setAttribute("imagesFocus", imagesFocus);
		request.setAttribute("images", images);
		request.setAttribute("sorts", sorts);
		request.setAttribute("strutsPageBean2", strutsPageBean2);
		request.setAttribute("imageType", imageType);
		return "image_index";
	}
}
