package com.videoManagement.videoHtml;

import java.util.Iterator;
import java.util.LinkedList;


/**   
 * @ClassName:Queue
 * @Description: TODO(用来存放将要访问的url，使用链表来实现队列) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午9:34:41 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class Queue {
	
	private LinkedList queue = new LinkedList();
	
	/** 
	* @Title: addQeue 
	* @Description: TODO(用来加入队列的) 
	* @param @param url    设定文件 
	* @return void    返回类型 
	*
	*/
	public void addQueue(Object url){
		queue.add(url);
	}
	
	/** 
	* @Title: deQueue 
	* @Description: TODO(移除掉以及访问的url) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	*
	*/
	public Object  deQueue (){
		return queue.removeFirst();
	}
	/**
	 * 
	* @Title: isContians 
	* @Description: TODO(判断url是否在在队列里面) 
	* @param @param url
	* @param @return    设定文件 
	* @return boolean    返回类型 
	*
	 */
	public boolean isContians(Object url){
		return queue.contains(url);
	}
	/**
	 * 
	* @Title: isEmpty 
	* @Description: TODO(判断一个队列是否为空) 
	* @param @return    设定文件 
	* @return boolean    返回类型 
	*
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public int getQueueSize(){
		return queue.size();
	}
	
	public Iterator getQueueIterator(){
		return queue.descendingIterator();
	}
}
