package com.videoManagement.test;

import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.videoManagemen.picture.PictureUtil;
import com.videoManagement.bean.Images;

public class JavaThreadPictureTest extends HttpServlet implements Runnable {

	public void run() {
		try {
			Calendar c;
			while (true) {
				c = Calendar.getInstance();// 时间对象
				int mm = 5;// 默认线程间隔时间
				System.out.println("定期执行的。。。。。");
				PictureUtil pictureUtil = new PictureUtil();
				String flickrURL = "http://api.flickr.com/services/rest/?method=flickr.photos.search&content_type=7&api_key=da8e8c6840579831969d1a87d37ae545&per_page=10&format=json&extras=original_format&page=1&tags=";
				List<Images> images = pictureUtil.getFlickrImage(flickrURL,
						"黄山");
				for (Images images2 : images) {
					System.out.println(images2.getUrl());
				}
				System.out.println("执行完成了。。。。");
				Thread.sleep(mm * 1000L);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		System.out.println("------------Thread init()-------------");
		JavaThreadPictureTest t = new JavaThreadPictureTest();
		new Thread(t).start();
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.SECOND));
		JavaThreadPictureTest t = new JavaThreadPictureTest();
		new Thread(t).start();
	}

}