package com.videoManagement.longThread;

import java.util.*;

import org.springframework.stereotype.Controller;
@Controller
public class MyTask extends TimerTask {
	private static final int A_SCHEDULE_HOUR = 0;
	private static final int B_SCHEDULE_HOUR = 0;
	private static final int C_SCHEDULE_HOUR = 0;
	private static final int D_SCHEDULE_HOUR = 0;
	private static final int E_SCHEDULE_HOUR = 0;
	private static boolean isRunning = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		//获取某个进程是否在运行
		RunCmd runCmd = new RunCmd();
		//判断监听器是否执行
		if (!isRunning) { 
			//设置每天晚上12点到一点执行
			/*if (A_SCHEDULE_HOUR <= cal.get(Calendar.HOUR_OF_DAY) || B_SCHEDULE_HOUR >= cal.get(Calendar.HOUR_OF_DAY)) {
				isRunning = true;
					System.out.println("执行当中");
					daoImp imp = new daoImp();
					imp.getFlashVedios();
				//事件执行完后，将isRunning设置为false
				isRunning = false;
			}
			*/
			if(C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY) || D_SCHEDULE_HOUR ==cal.get(Calendar.HOUR_OF_DAY)){
				if(!runCmd.getProcess("ffmpeg.exe")){
					System.out.println("线程没有运行");
					daoImp imp = new daoImp();
					imp.delOldFlash();
				}
				//事件执行完后，将isRunning设置为false
				isRunning = false;
			}
			
			if(cal.get(Calendar.HOUR_OF_DAY) == E_SCHEDULE_HOUR){
				daoImp imp = new daoImp();
				imp.deelNoFlashSql();
				imp.deelNoImagesSql();
				System.out.println("ok_ok");
			}
		}else {
			System.out.println("线程运行中");
		}
	}
}
