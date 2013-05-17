package com.videoManagement.action;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.ReceptionIndexImageServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**   
 * @ClassName:ImageLoadAction
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-4 下午12:24:16 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class ImageLoadAction extends ActionUtil {
	@Autowired
	private ReceptionIndexImageServiceDao receptionIndexImageServiceDao;
	private HttpServletResponse response = ActionUtil.getResponse();
	private String currentPage;
	private String imageType;
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	@Action(value="executeImage")
	public String executeImage() throws Exception{
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		int offset = 0;//默认显示从第0条开始查询
		int pageSize = 10;//每页显示20条
		int currentPage1 = 1;
		if (currentPage==null || currentPage.equals("")) {
			
		}else {
			currentPage1 = Integer.valueOf(currentPage);
			offset = (currentPage1++)*pageSize;
		}
		//首先默认显示的是美女图片
		String hql = "from Images where audit=? and ImageType=?";
		String imageType1= null;
		if (imageType==null || imageType.equals("")) {
			imageType1 = "美女";
		}else {
			imageType1 = imageType;
		}
		
		Object[] params = new Object[]{1,imageType1};
		List<Images> images = receptionIndexImageServiceDao.findByPage2(hql, offset, pageSize, params);
		Gson gson = new Gson();
		String listImages = gson.toJson(images);
		PrintWriter out = response.getWriter();
		out.print(listImages);
		return null;
	}
}
