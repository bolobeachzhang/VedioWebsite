package com.videoManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.AudioVedioServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**   
 * @ClassName:AudioVedioAction
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-31 下午7:49:59 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class AudioVedioAction extends ActionUtil {
	@Autowired
	private AudioVedioServiceDao audioVedioServiceDao;
	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	@Action(value="/AudioVedio", results = { @Result(name = "audiovedio", location = "/jsp/behind_JSP/resource_manger/newResource/auditVedio.jsp") })
	public String AudioVedio(){
		//首先加载所有的已经审核的视频资源信息
		HttpServletRequest request = this.getRequest();
		
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
		
		//在这里需要查询视频信息 把为审核的查询出来
		//orign 如果为0表示是抓取的
		//audit 0 表示未审核的
		String hql = "from FlashVedio where origin = ? and audit=?";
		int totleRows = audioVedioServiceDao.affectNumber(hql,
				new Object[] {0,1});
		
		List<FlashVedio> flashVedios = audioVedioServiceDao.findByPage2(
				hql, offset, pageSize, new Object[] {0,1});
		
		
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean2 = strutsPageBean.getstrutsPageBean(
				pageSize, Integer.valueOf(currentPage), totleRows);
		
		
		request = this.getRequest();
		request.setAttribute("flashVedios", flashVedios);
		request.setAttribute("strutsPageBean2", strutsPageBean2);
		return "audiovedio";
	}
	
	@Action(value = "deleteAudioVideo", results = { @Result(name = "AudioVedio", type = "chain", location = "AudioVedio") })
	public String deleteVideo() throws Exception {
		HttpServletRequest request = this.getRequest();
		String type = request.getParameter("type");
		String publish = request.getParameter("publish");
		String videoId = request.getParameter("videoId");
		
		
		// 如果是发布按钮
		if (videoId != null && publish.equals("publish")) {
			System.out.println("fabu");
			String hql = "update FlashVedio  set audit = ? where id=?";
			audioVedioServiceDao.update(hql,
					new Object[] { 1, Integer.valueOf(videoId) });
			return "AudioVedio";
		}
		if (videoId!=null && publish.equals("delete")) {
			String hql = "delete FlashVedio where id=?";
			audioVedioServiceDao.deleteByHql(hql,
					new Object[] { Integer.valueOf(videoId) });
			return "AudioVedio";
		}
		
		
		String[] checkbox = request.getParameterValues("checkboxFlashId");
		if (checkbox == null) {
			return "error";
		} else {
			// 说明是发布按钮
			if ("publish".equals(type)) {
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "update FlashVedio  set audit = ? where id=?";
					audioVedioServiceDao.update(hql, new Object[] { 1,
							Integer.valueOf(id) });
				}
				return "AudioVedio";
			} else if ("delete".equals(type)) {// 说明是删除按钮
				for (int i = 0; i < checkbox.length; i++) {
					String id = checkbox[i];
					String hql = "delete FlashVedio where id=?";
					audioVedioServiceDao.deleteByHql(hql,
							new Object[] { Integer.valueOf(id) });
				}
				return "AudioVedio";
			} else {
				return "error";
			}
		}

	}
}
