/**   
* @Title: ActionUtil.java 
* @Package com.videoManagement.util 
* @Description: TODO(基本的action操作类) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-24 下午12:07:26 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpbf.extractor.PublisherTextExtractor;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: ActionUtil 
 * @Description: TODO(基本的action操作类) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-24 下午12:07:26 
 *  
 */
public class ActionUtil extends ActionSupport implements ServletRequestAware {

	
	/** 
	* @Title: getRequest 
	* @Description: TODO(返回一个request对象) 
	* @param @return    设定文件 
	* @return HttpServletRequest   返回ServletActionContext
	*/
	public static HttpServletRequest getRequest(){
		//得到上下文
		ActionContext actionContext = ActionContext.getContext();
		return (HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST);
	}

	/** 
	* @Title: getResponse 
	* @Description: TODO(返回一个response对象) 
	* @param @return    设定文件 
	* @return HttpServletResponse    返回HttpServletResponse
	*/
	public static HttpServletResponse getResponse(){
		ActionContext actionContext = ActionContext.getContext();
		return (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	}
	
	
	public void setServletRequest(HttpServletRequest request) {
		
	}

	/** 
	* @Title: getUserName 
	* @Description: TODO(获取登录后存放在session中的用户名) 
	* @return String    用户名
	*/
	public String getUserName(){
		return (String) ActionContext.getContext().getSession().get(Constant.USERNAME_KEY);
	}
	
	/** 
	* @Title: getToday 
	* @Description: TODO(得到今天字符串【2013-03-25】) 
	* @return String    今天的字符串
	*/
	public String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	/**
	 * 
	* @Title: getDate 
	* @Description: TODO(将一个时间类型转换为【2013-03-25】) 
	* @param @param date
	* @param @return    设定文件 
	* @return String    返回类型 
	*
	 */
	public String getDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);;
		return currentDate;
	}
	/** 
	* @Title: getUserRole 
	* @Description: TODO(得到session保存的权限) 
	* @param @return    设定文件 
	* @return String    返回类型 
	*/
	public String getUserRole(){
		return (String) ActionContext.getContext().getSession().get(Constant.UserRole_KEY);
	}
	
	/** 
	* @Title: setSession 
	* @Description: TODO(像session里面添加一个键值对) 
	* @param  key 要设置属性的key值
	* @param  val 要设置属性的value值
	* @return void    返回类型 
	*/
	public void setSession(String key,Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	/** 
	* @Title: getSession 
	* @Description: TODO(获取session里面的值) 
	* @param  key 要获取属性的key值
	* @return Object    key值对应的session中的value值 
	*/
	public Object getSession(String key){
		return ActionContext.getContext().getSession().get(key);
	}
}
