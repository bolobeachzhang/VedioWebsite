package com.videoManagement.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.Normalizer.Form;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.ReceptionVedioActionDao;
import com.videoManagement.util.ActionUtil;

/**   
 * @ClassName:ReceptionVedioAction
 * @Description: TODO(所有flash跳转的action) 
 * @author 代兵 【707189384@qq.com】
 * @date 2013-4-1 下午6:27:24 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
@Controller
@Results({
	@Result(name="video_index",location="/jsp/front_JSP/video_jsp/video_index.jsp"),
	@Result(name="error",location="/WEB-INF/error.jsp")
})
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class ReceptionVedioAction extends ActionUtil{
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	private  String  param;
	@Autowired
	public ReceptionVedioActionDao receptionVedioActionDao;
	//配置所有的视频Action跳转
	//左边部分的所有分类跳转都是采用这个action
	@Action(value="/ReceptionVedio")
	public String ReceptionVedio() throws UnsupportedEncodingException{
		
		String param1="";
		if (param == null || param == "") {			
			param1="电影";
		}else {
			param1 = new String(param.getBytes("ISO-8859-1"),"utf-8");
		}	
		//System.out.println("参数是"+param1);
		//给播放次数增加1
		String hql ="from FlashVedio where flashType=? order by captureTime desc";
		String hql2 ="from Sort where sortType=? ";
		int offset =0;
		int pageSize = 20;
		//获取焦点图
		List<Images> images = receptionVedioActionDao.query(
				"from Images i where i.content=? order by imageType", "videoFocus");
		this.getRequest().setAttribute("images", images);	
		Object[] values1={param1};
		//传递娱乐新闻	
		List<FlashVedio> list1 = receptionVedioActionDao.getFlashVedios(hql, offset, pageSize, values1);
		//传递各种分类
		List   flashTypes = receptionVedioActionDao.getType(hql2, 1);
		List   lasteVideo1 = receptionVedioActionDao.findByPage("from FlashVedio order by captureTime desc", 0, 4);
		List   lasteVideo2 = receptionVedioActionDao.findByPage("from FlashVedio order by captureTime desc", 5, 9);
		//排行榜的显示
		List   byclickNum = receptionVedioActionDao.findByPage("from FlashVedio order by clickNums desc", 0, 40);
		this.getRequest().setAttribute("list1", list1);
		this.getRequest().setAttribute("byclickNum", byclickNum);
		this.getRequest().setAttribute("flashTypes", flashTypes);
		this.getRequest().setAttribute("lasteVideo1", lasteVideo1);
		this.getRequest().setAttribute("lasteVideo2", lasteVideo2);
		this.getRequest().setAttribute("flashType", param1);
		return "video_index";
	}
}
