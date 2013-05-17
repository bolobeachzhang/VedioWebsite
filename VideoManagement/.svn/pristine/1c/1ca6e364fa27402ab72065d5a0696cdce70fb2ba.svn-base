/**   
 * @Title: TestSpring.java 
 * @Package com.videoManagement.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-21 上午8:07:14 
 * @version V1.0   成都大学信息科学与技术学院
 */
package com.videoManagement.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.videoManagement.action.AudioImagesAction;
import com.videoManagement.bean.Users;
import com.videoManagement.serviceDao.LoginServiceDao;

/**
 * @ClassName: TestSpring
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-21 上午8:07:14
 * 
 */
public class TestSpring {
	@Test
	public void testSpring() throws Exception {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		AudioImagesAction loginServiceDao = (AudioImagesAction) applicationContext
				.getBean("audioImagesAction");
		System.out.println(loginServiceDao.getToday());
	}

	@Test
	public void add() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		LoginServiceDao loginServiceDao = (LoginServiceDao) applicationContext
				.getBean("loginServiceImp");
			Users users = new Users(1, "张兵", "390125214", new Date(), "390125214",
					"http://www.baidu.com", 1, "1", "张兵", new Date());
		loginServiceDao.save(users);

	}
}
