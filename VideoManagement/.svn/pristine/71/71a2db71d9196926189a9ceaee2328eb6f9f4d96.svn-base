package com.videoManagement.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.videoManagement.util.ActionUtil;

/**   
 * @ClassName:ReceptionVedioNewsAction
 * @Description: TODO(前台最新动态的action) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-1 下午6:50:33 
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
public class ReceptionVedioNewsAction extends ActionUtil {
	@Action(value="/receptionVedioNews",results={@Result(name="video_playPage",location="/jsp/front_JSP/video_jsp/video_playPage.jsp")})
	public String ReceptionVedioNews(){
		System.out.println("所有视频跳转");
		return "video_playPage";
	}
}
