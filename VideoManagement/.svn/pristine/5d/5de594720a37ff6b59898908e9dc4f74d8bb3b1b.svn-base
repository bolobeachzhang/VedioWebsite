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
 * @ClassName:souseManageMenuAction
 * @Description: TODO(这个action是用来处理资源管理子菜单的跳转)
 * @author 刘福林
 * @date 2013-4-16 下午14:03:01
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */

@Controller
@Result(name="error",location="/WEB-INF/error.jsp")
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class souseManageMenuAction extends ActionUtil {
	/**
	 * newResourceMain跳转
	 * 
	 */
	@Action(value = "/newResourceMain", results = { @Result(name = "newResourceMain", location = "/jsp/behind_JSP/resource_manger/newResource/newResourceMain.jsp") })
	public String newResourceMain() throws Exception {
		
		return "newResourceMain";
	}
	/**
	 * uploadResourceMain跳转
	 * 
	 */
	@Action(value = "/uploadResourceMain", results = { @Result(name = "uploadResourceMain", location= "/jsp/behind_JSP/resource_manger/uploadResource/uploadResourceMain.jsp") })
	public String uploadResourceMain() throws Exception {
		
		return "uploadResourceMain";
	}
	/**
	 * uploadResourceMain跳转
	 * 
	 */
	@Action(value = "/existResourceMain", results = { @Result(name = "existResourceMain", location= "/jsp/behind_JSP/resource_manger/existResource/existResourceMain.jsp") })
	public String existResourceMain() throws Exception {
		
		return "existResourceMain";
	}
	/**
	 * uploadResourceMain跳转
	 * 
	 */
	@Action(value = "/oldResourceMain", results = { @Result(name = "oldResourceMain", location= "/jsp/behind_JSP/resource_manger/oldResource/oldResourceMain.jsp") })
	public String oldResourceMain() throws Exception {
		
		return "oldResourceMain";
	}
}
