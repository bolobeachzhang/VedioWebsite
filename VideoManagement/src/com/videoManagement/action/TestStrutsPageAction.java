/**   
* @Title: TestStrutsPageAction.java 
* @Package com.videoManagement.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-25 上午10:36:38 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.videoManagement.serviceDao.LoginServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/** 
 * @ClassName: TestStrutsPageAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-25 上午10:36:38 
 *  
 */
public class TestStrutsPageAction extends ActionUtil {
	@Autowired
	private LoginServiceDao loginServiceDao;
	@Action(value="testPageAction",results=@Result(location="/WEB-INF/testAction.jsp",name="testAction"))
	public String testPageAction(){
		int pageSize = 5; 
		String pageId = this.getRequest().getParameter("pageId"); 
		if (pageId == null || pageId.equals("")) 
		{ 
		        pageId = "1"; 
		} 
		int currentPage = Integer.parseInt(pageId);
		//从服务层里获取总记录数 
		int totalRows = loginServiceDao.affectNumber("from Users", null); 
		System.out.println(totalRows);
		strutsPageBean page = new strutsPageBean();
		strutsPageBean strutsPageBean = page.getstrutsPageBean(pageSize, currentPage, totalRows);
		this.getRequest().setAttribute("page", strutsPageBean);
		return "testAction";
	}
}
