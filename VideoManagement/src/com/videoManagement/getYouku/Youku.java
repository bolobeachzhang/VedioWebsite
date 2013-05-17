package com.videoManagement.getYouku;

import java.util.ArrayList;
import java.util.List;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.VideoYoukuServiceDao;
import com.videoManagement.serviceImp.VideoYoukuServiceDaoImpl;

public class Youku {
	/**
	 * 是一个递归方法
	 * 
	 * @param url
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static List<FlashVedio> run(String url, List<String> list3)
			throws Exception {

		VideoManager videoTest = new VideoManager();
		VideoYoukuServiceDao vImpl = new VideoYoukuServiceDaoImpl();
		// 创建一个装载所有video对象的title
		List<String> iamgelList = new ArrayList<String>();
		// 取得这个网页所有有效的超链接
		List<String> list = videoTest.getVideosLink(url);
		List<FlashVedio> videos = new ArrayList<FlashVedio>();
		// System.out.println("进入后。。。");
		for (String link : list) {
			if (videoTest.check2(link)) {
				// System.out.println("第二次过滤后的链接：：：" + link);
				// 获取这个有效链接的video对象
				FlashVedio flashVedio = videoTest.getVideo(link);
				// 将titile添加到titles
				if (iamgelList.contains(flashVedio.getFlashImagePath()) == false) {
					iamgelList.add(flashVedio.getFlashImagePath());
					// 添加对象到list对象中
					if (flashVedio != null) {
						videos.add(flashVedio);
					}
				}

			}
		}
		return videos;
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * run("http://v.youku.com/v_show/id_XNTM1NjgxOTA4.html?f=19092889", null);
	 * }
	 */

}