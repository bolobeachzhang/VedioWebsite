package com.videoManagement.longThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public  class LongThread extends HttpServlet implements
		ServletContextListener {
	public LongThread() {
	}
	private java.util.Timer timer = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer.cancel();
		System.out.println("定时器销毁");
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer = new java.util.Timer(true);
		System.out.println("定时器已启动");
		timer.schedule(new MyTask(), 0,  60*6*10000);
		System.out.println("已经添加任务调度表");
	}
}