package com.videoManagement.videoHtml;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**   
 * @ClassName:LinkedQueue
 * @Description: TODO(这个是用来保存已经访问过的url) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午9:44:17 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class LinkedQueue {
	//用来保存以及访问过的url
	private static Set<String> visitedUrl = new HashSet<String>();
	//用来保存还没有访问的url
	private static Queue unvisitedUrl = new Queue();
	
	/** 
	* @Title: getUnvisitedUrl 
	* @Description: TODO(获取url队列 未访问的) 
	* @param @return    设定文件 
	* @return Queue    返回类型 
	*
	*/
	public static Queue getUnvisitedUrl(){
		return unvisitedUrl;
	}
	
	/** 
	* @Title: addVisitedUrl 
	* @Description: TODO(添加已经访问过的队列里面) 
	* @param     设定文件 
	* @return void    返回类型 
	*
	*/
	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}
	/**
	 * 
	* @Title: removeVisitedUrl 
	* @Description: TODO(用来移除已经访问过后的url) 
	* @param @param url
	* @param @return    设定文件 
	* @return boolean    返回类型 
	*
	 */
	public static boolean removeVisitedUrl(String url){
		return visitedUrl.remove(url);
	}
	/**
	 * 
	* @Title: unVisitedUrlDeQueue 
	* @Description: TODO(把未访问的url移除去) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	*
	 */
	public static Object unVisitedUrlDeQueue(){
		return unvisitedUrl.deQueue();
	}
	
	/** 
	* @Title: addUnvisitedUrl 
	* @Description: TODO(保证每一个url只被访问一次) 
	* @param @param url    设定文件 
	* @return void    返回类型 
	*
	*/
	public static void addUnvisitedUrl(String url){
		if(url!=null && !url.trim().equals("") && !visitedUrl.contains(url) && !unvisitedUrl.isContians(url)){
			unvisitedUrl.addQueue(url);
		}
	}
	
	//获取以及访问的URL数字
	public static int getVisitedUrlNum(){
		return visitedUrl.size();
	}
	/**
	 * 
	* @Title: UnvisitedIsEmpty 
	* @Description: TODO{判断未访问的队列是否为空 如果为空那么就不在抓取了..) 
	* @param @return    设定文件 
	* @return boolean    返回类型 
	*
	 */
	public static boolean UnvisitedIsEmpty(){
		return unvisitedUrl.isEmpty();
	}
	
	/** 
	* @Title: isContent 
	* @Description: TODO(判断是否是以及访问队列里面) 
	* @param @param url
	* @param @return    设定文件 
	* @return boolean    返回类型 
	*
	*/
	public static boolean isContent(String url){
		return visitedUrl.contains(url);
	}
}
