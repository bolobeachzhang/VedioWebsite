package com.videoManagement.test;

import java.util.List;

import com.videoManagemen.picture.PictureUtil;
import com.videoManagement.bean.Images;

/**   
 * @ClassName:PictureRun
 * @Description: TODO(采用线程的当时来进行定时的抓取) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-1 下午3:41:29 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class PictureRun implements Runnable{
	
	public void run() {
		PictureUtil pictureUtil = new PictureUtil();
		String googleUrl ="https://ajax.googleapis.com/ajax/services/search/images?rsz=8&imgtype=photo&v=1.0&hl=zh-TW"; 
		String categoryName = "信息科学与技术学院";
		/*List<Images> images3 = pictureUtil.getGoogleImage(googleUrl,categoryName,"http://computer.cdu.edu.cn","medium","gif");
		for (Images images : images3) {
			System.out.println(images.getUrl());
		}*/
	}
	public static void main(String[] args) {
		PictureRun pictureRun = new PictureRun();
		Thread thread = new Thread(pictureRun);
		thread.start();
	}
	
}
