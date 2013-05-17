package com.videoManagement.action;

import jxl.biff.StringHelper;

import org.apache.poi.hpbf.extractor.PublisherTextExtractor;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.videoManagement.util.ActionUtil;

/**   
 * @ClassName:ReceptionIndexAction
 * @Description: TODO(用来跳转主页的action) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-1 下午6:26:36 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
@Controller
@Results({
	@Result(name="vedio_index",location="/jsp/front_JSP/picture_jsp/video_index.jsp"),
	@Result(name="error",location="/WEB-INF/error.jsp")
})
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class ReceptionIndexVedioAction extends ActionUtil {
	@Action(value="receptionIndexVedio")
	public String receptionIndexVedio(){
		return "vedio_index";
	}
}
