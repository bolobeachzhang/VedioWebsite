package com.videoManagement.util;
/**
 * 检验url是属于的html网页
 * @author 代兵
 * @Date  2013-3-27, 15:56  PM
 * @mailto 707189384@qq.com
 */
public class CheckUrlUtil {
	public static boolean checkUrl(String  url,String header) {	
		int index= url.lastIndexOf(".");//获取url字符串中“.”的最后一个索引
		String last= url.substring(index+1);//返回a="html"
		if (url.contains(header) && last.equals("html") ) {
			return  true;
		}else {
			return false;
		}
	}  
}
