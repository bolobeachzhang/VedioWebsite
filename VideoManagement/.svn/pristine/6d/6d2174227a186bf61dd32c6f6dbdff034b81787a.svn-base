/**   
* @Title: IndexAction.java 
* @Package com.videoManagement.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-20 上午10:26:40 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;
import com.videoManagement.serviceDao.LoginServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.MD5;

/** 
 * @ClassName: IndexAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-20 上午10:26:40 
 *  
 */
@Controller
@Result(name="error",location="/WEB-INF/error.jsp")
@ExceptionMapping(exception="java.lange.RuntimeException",result="/WEB-INF/error.jsp")
public class IndexAction extends ActionUtil {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Autowired
	private LoginServiceDao loginServiceDao;
	@Action(value="/indexAction",results={@Result(name="main",location="/WEB-INF/main.jsp")})
	public String check(){
		String passwordMd5 = MD5.MD5(password);
		boolean i = false ;
		try {
			//throw new RuntimeException("错误了。。。。。"); 
			i = loginServiceDao.checkUsers(username,passwordMd5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(i);
		if(i){
			return "main";
		}else {
			System.out.println("登录错误");
			return "error";
		}
	}
	@Action(value="/execute")
	public String execute() throws Exception {
		System.out.println("dfsafdsa");
		return super.execute();
	}
}
