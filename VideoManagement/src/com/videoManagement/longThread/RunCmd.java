/**
 * 张居开
 * 测试某个应用程序是否开启了
 */

package com.videoManagement.longThread;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class RunCmd {
	
	public  boolean getProcess(String exe) {
		boolean flag = false;
		try {
			Process p = Runtime.getRuntime().exec("cmd   /c   tasklist ");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream os = p.getInputStream();
			byte b[] = new byte[256];
			while (os.read(b) > 0)
				baos.write(b);
			String s = baos.toString();
			if (s.indexOf(exe) >= 0) {
				System.out.println("yes ");
				flag = true;
			}
			else {
				System.out.println("no ");
				flag = false;
			}
		} catch (java.io.IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}
}
