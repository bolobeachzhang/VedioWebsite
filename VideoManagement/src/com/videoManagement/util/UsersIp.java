/**   
 * @Title: UsersIp.java 
 * @Package com.videoManagement.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-23 下午1:50:17 
 * @version V1.0   成都大学信息科学与技术学院
 */
package com.videoManagement.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: UsersIp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-23 下午1:50:17
 * 
 */
public class UsersIp {
	/** 
	* @Title: getUsersIp 
	* @Description: TODO(获取ip地址) 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 ip地址
	*/
	public static String getUsersIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
