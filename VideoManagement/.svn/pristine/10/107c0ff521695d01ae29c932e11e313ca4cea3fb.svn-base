/**   
* @Title: IndexAction.java 
* @Package com.videoManagement.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-20 上午10:26:40 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;
import com.videoManagement.serviceDao.LoginServiceDao;
import com.videoManagement.util.ActionUtil;

/** 
 * @ClassName: IndexAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-20 上午10:26:40 
 *  
 */
@Controller
@Namespace("VideoManagement")
public class TestAction extends ActionUtil{
	//跳转到欢迎界面
	@Action(value="/welcomeAction",results={@Result(location="/jsp/behind_JSP/frame.jsp",name="test")})
	public String execute() throws Exception {
		return "test";
	}
}
