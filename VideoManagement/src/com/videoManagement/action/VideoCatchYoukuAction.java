package com.videoManagement.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.getYouku.VideoManager;
import com.videoManagement.getYouku.Youku;
import com.videoManagement.serviceDao.VideoYoukuServiceDao;
import com.videoManagement.serviceImp.VideoYoukuServiceDaoImpl;
import com.videoManagement.util.ActionUtil;

/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 后台管理跳转 actoin
 * @Author 代兵
 * @Date 2013-3-27, 15:56 PM
 * @mailto 707189384@qq.com 优酷视频抓取爱车tion
 */
@Controller
public class VideoCatchYoukuAction extends ActionUtil {

	public VideoYoukuServiceDao getVideoYoukuServiceDao() {
		return videoYoukuServiceDao;
	}

	public void setVideoYoukuServiceDao(
			VideoYoukuServiceDao videoYoukuServiceDao) {
		this.videoYoukuServiceDao = videoYoukuServiceDao;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	private String pageUrl; // 资源抓取的来源url
	HttpServletRequest request = ActionUtil.getRequest();
	HttpServletResponse response = ActionUtil.getResponse();
	@Autowired
	private VideoYoukuServiceDao videoYoukuServiceDao;

	/**
	 * 搜寻优酷的视频主页跳转
	 *//*
	@Action(value = "/searchYouku", results = { @Result(name = "searchYouku", location = "/jsp/behind_JSP/straty_manager/searchManagement.jsp") })
	public String searchYouku() throws Exception {
		
		VideoManager videoTest = new VideoManager();
		VideoYoukuServiceDao vImpl = new VideoYoukuServiceDaoImpl();
		// 创建一个装载所有video对象的title
		List<String> iamgelList = new ArrayList<String>();
		// 取得这个网页所有有效的超链接
		List<String> list = videoTest.getVideosLink(pageUrl);
		List<FlashVedio> videos = new ArrayList<>();
		// System.out.println("进入后。。。");
		for (String link : list) {
			if (videoTest.check2(link)) {
				// System.out.println("第二次过滤后的链接：：：" + link);
				// 获取这个有效链接的video对象
				FlashVedio flashVedio = videoTest.getVideo(link);
				// 将titile添加到titles
				if (iamgelList.contains(flashVedio.getFlashImagePath()) == false) {
					iamgelList.add(flashVedio.getFlashImagePath());
					// 添加对象到list对象中
					if (flashVedio != null) {
						vImpl.save(flashVedio);
						System.out.println("插入成功！！！");
					}
				}

			}
		}
	
		return "searchYouku";
	}*/
}
