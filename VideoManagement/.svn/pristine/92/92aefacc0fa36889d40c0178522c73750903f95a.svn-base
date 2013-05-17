package com.videoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.AudioImagesServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**   
 * @ClassName:AudioImagesAction
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-31 下午9:40:32 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class AudioImagesAction extends ActionUtil {
	@Autowired
	private AudioImagesServiceDao audioImagesServiceDao;
	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	@Action(value = "audioImage", results = { @Result(name = "audioImage", location = "/jsp/behind_JSP/resource_manger/newResource/AudioImages.jsp") })
	public String audioImage(){
		HttpServletRequest request = this.getRequest();
		

		int pageSize = 12;
		int offset = 0;
		if (currentPage != null && Integer.valueOf(currentPage)!=0) {
			offset = (Integer.valueOf(currentPage)-1) * pageSize;
		} else {
			currentPage = 1 + "";
		}
		// audit = 1 表示审核
		// resoucresType = 0 表示图片
		//origin 0 表示下载的
		String hql = "from Images where origin = ? and audit=? and resourcesType =?";
		Object[] params = new Object[] {0,1,0};
		int totleRows = audioImagesServiceDao.affectNumber(hql, params);
		List<Images> images = audioImagesServiceDao.findByPage2(hql,
				offset, pageSize, params);
		
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean1 = strutsPageBean.getstrutsPageBean(
				pageSize, Integer.valueOf(currentPage), totleRows);
		request.setAttribute("images", images);
		request.setAttribute("strutsPageBean1", strutsPageBean1);
		
		
		return "audioImage";
	}
	
	@Action(value = "audioDeleteImages", results = { @Result(name = "audioImage", type = "chain", location = "audioImage") })
	public String deleteImages() throws Exception {
		HttpServletRequest request = this.getRequest();
		String type = request.getParameter("type");
		String publish = request.getParameter("publish");
		String imageId = request.getParameter("imageId");
		String[] checkbox = request.getParameterValues("checkbox");
		if (imageId != null && publish.equals("delete")) {
			String hql = "delete Images where id=?";
			audioImagesServiceDao.deleteByHql(hql,
					new Object[] { Integer.valueOf(imageId) });
			return "audioImage";
		}
		if (checkbox != null) {
			// 说明是发布按钮
			 if ("delete".equals(type)) {// 说明是删除按钮
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "delete Images where id=?";
					audioImagesServiceDao.deleteByHql(hql,
							new Object[] { Integer.valueOf(id) });
				}
				return "audioImage";
			} else {
				return "error";
			}
		}else {
			return "error";
		}
	}
}
