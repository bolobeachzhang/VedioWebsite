package com.videoManagement.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.bean.Resources;
import com.videoManagement.bean.Sort;
import com.videoManagement.getYouku.VideoManager;
import com.videoManagement.serviceDao.SearchManServiceDao;
import com.videoManagement.serviceDao.VideoYoukuServiceDao;
import com.videoManagement.serviceImp.VideoYoukuServiceDaoImpl;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.PictureDown;
import com.videoManagement.util.VideoService;
import com.videoManagement.util.strutsPageBean;
import com.videoManagement.videoHtml.Queue;
import com.videoManagement.videoHtml.TudouHtmlService;

/**
 * 
 * @ClassName:searchManAction
 * @Description: TODO(这个action是用来处理搜索所有的Flash地址)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午8:55:01
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */

@Controller
@Result(name="error",location="/WEB-INF/error.jsp")
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class SearchManAction extends ActionUtil {
	@Autowired
	private SearchManServiceDao searchManServiceDao;
	HttpServletRequest request = getRequest();
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
	/**
	 * 后台主页跳转 代兵专属
	 */
	@Action(value = "/inserFont", results = { @Result(name = "inserFont", location = "/jsp/front_JSP/front_index.jsp") })
	public String frame() throws Exception {
		//获取焦点图
		List<Images> images = searchManServiceDao.query(
						"from Images i where i.content=? order by imageType", "mainFocus");
		//左边部分
		List<Images> leftPart = new ArrayList<Images>();
		leftPart.add(images.get(0));
		leftPart.add(images.get(1));
		leftPart.add(images.get(2));
		//右边部分
		List<Images> rightPart = new ArrayList<Images>();
		rightPart.add(images.get(3));
		rightPart.add(images.get(4));
		rightPart.add(images.get(5));
	    this.getRequest().setAttribute("leftPart", leftPart);	
	    this.getRequest().setAttribute("rightPart", rightPart);	
		return "inserFont";
	}

	/**
	 * searchManagement跳转
	 * 
	 */
	@Action(value = "searchManagement", results = { @Result(name = "searchManagement", location = "/jsp/behind_JSP/straty_manager/searchManagement.jsp") })
	public String searchManagement() throws Exception {
		
		String pageNow = request.getParameter("currentPage");
		int currentPage = 1;
		//在这里用来处理曾经抓取的url地址
		int offset = 0;
		int pageSize = 12;
		if (pageNow!=null) {
			currentPage = Integer.valueOf(pageNow);
			offset = (currentPage-1) *pageSize;
		}
		String hql = "SELECT DISTINCT (pageUrl),captureTime from Resources";
		List<Object[]> resources = searchManServiceDao.findByPage(hql, offset, pageSize);
		/*for(Object[] link : resources){
		    String captureTime = (String) link[1];
		    System.out.println("*******************************"+ captureTime);
		}*/
		int totleRows = searchManServiceDao.affectNumber(hql, null);
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean1 = strutsPageBean.getstrutsPageBean(pageSize, currentPage, totleRows);
		request.setAttribute("resources", resources);
		request.setAttribute("strutsPageBean1", strutsPageBean1);
		return "searchManagement";
	}

	/** 
	* @Title: spriderUrl 
	* @Description: TODO(用来抓取页面地址的) 
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	*
	*/
	@Action(value="spriderUrl",results={
	@Result(name="searchManagementAction",type="chain",location="searchManagement")})
	public String spriderUrl() throws Exception{ 
		String url = request.getParameter("url");
		if (url.contains("tudou")) {
			System.out.println("tudou");
			VideoService videoService = new VideoService();
			TudouHtmlService tudouHtmlService = new TudouHtmlService();
			Queue queue = tudouHtmlService.getUrlQueue(url);
			Iterator iterator = queue.getQueueIterator();
			while (iterator.hasNext()) {
				FlashVedio flashVedio = videoService.getTudouVideo(iterator.next().toString());
				if (flashVedio!=null) {
					FlashVedio flashVedio2 = new FlashVedio();
					flashVedio2.setFlashTime(flashVedio.getFlashTime());
					flashVedio2.setPageUrl(flashVedio.getPageUrl());
					flashVedio2.setFlashImagePath(flashVedio.getFlashImagePath());
					flashVedio2.setUrl(flashVedio.getUrl());
					flashVedio2.setTitle(flashVedio.getTitle());
					flashVedio2.setDetailInfo(flashVedio.getDetailInfo());
					flashVedio2.setCaptureTime(new Date());
					flashVedio2.setAudit(0);
					searchManServiceDao.save(flashVedio2);
				}
			}
		}
		//然后抓取图片
		PictureDown pictureDown = new PictureDown();
		String htmlCode = pictureDown.getHtmlCode(url);
		List<Images> images = PictureDown.getPictureUrl(htmlCode, url);
		for (Images images2 : images) {
			searchManServiceDao.save(images2);
		}
		List<String> strings = pictureDown.getPicUrlByCss(url, htmlCode);
		List<Images> images2 = pictureDown.getStrUrl(url, strings);
		for (Images images3 : images2) {
			searchManServiceDao.save(images3);
		}
		return "searchManagementAction";
	}
	/**
	 * 搜寻优酷的视频主页跳转
	 */
	@Action(value = "/searchYouku", results = { @Result(name = "searchYouku", location = "/jsp/behind_JSP/straty_manager/searchManagement.jsp") })
	public String searchYouku() throws Exception {
		
		VideoManager videoTest = new VideoManager();
		//VideoYoukuServiceDao vImpl = new VideoYoukuServiceDaoImpl();
		// 创建一个装载所有video对象的title
		List<String> iamgelList = new ArrayList<String>();
		// 取得这个网页所有有效的超链接
		List<String> list = videoTest.getVideosLink(url);
		List<FlashVedio> videos = new ArrayList<FlashVedio>();
		// System.out.println("进入后。。。");
		for (String link : list) {
			if (videoTest.check2(link)) {
				System.out.println("第二次过滤后的链接：：：" + link);
				// 获取这个有效链接的video对象
				FlashVedio flashVedio = videoTest.getVideo(link);
				// 将titile添加到titles
				if (iamgelList.contains(flashVedio.getFlashImagePath()) == false) {
					iamgelList.add(flashVedio.getFlashImagePath());
					// 添加对象到list对象中
					if (flashVedio != null) {
						searchManServiceDao.save(flashVedio);
						System.out.println("插入成功！！！");
					}
				}

			}
		}
	
		return "searchYouku";
	}
}
