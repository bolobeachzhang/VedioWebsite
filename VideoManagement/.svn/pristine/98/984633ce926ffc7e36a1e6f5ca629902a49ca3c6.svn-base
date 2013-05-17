/**   
 * @Title: MD5.java 
 * @Package com.video.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-24 下午12:43:19 
 * @version V1.0   成都大学信息科学与技术学院
 */
package com.videoManagement.util;

import java.security.MessageDigest;

public class MD5 {

	/**
	 * @Title: main
	 * @Description: TODO(MD5加密)
	 * @param password
	 *            需要加密的字符串
	 * @return void 返回类型
	 */
	public static String MD5(String password) {
		byte[] source = password.getBytes();
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
