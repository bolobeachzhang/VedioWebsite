package com.videoManagement.test;

import java.util.Calendar;
import java.util.Iterator;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.util.VideoService;
import com.videoManagement.videoHtml.Queue;
import com.videoManagement.videoHtml.TudouHtmlService;

/**   
 * @ClassName:TestVideoService
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午8:33:45 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class TestVideoService {

	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args    设定文件 
	 * @return void    返回类型 
	 *
	 */
	public static void main(String[] args) {
		VideoService videoService = new VideoService();
		Long time = Calendar.getInstance().getTimeInMillis();
		TudouHtmlService tudouHtmlService = new TudouHtmlService();
		Queue queue = tudouHtmlService.getUrlQueue("http://www.tudou.com");
		System.err.println(queue.getQueueSize());
		Iterator iterator = queue.getQueueIterator();
		while (iterator.hasNext()) {
			FlashVedio videoBean = videoService.getTudouVideo(iterator.next().toString());
			if (videoBean!=null) {
				System.out.println("图片地址是" +videoBean.getFlashImagePath());
			}
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - time);
	}

}
