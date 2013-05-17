package com.videoManagement.videoHtml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osm.jsoup.Jsoup;
import org.osm.jsoup.nodes.Document;

/**   
 * @ClassName:TudouHtmlService
 * @Description: TODO(这个是用来抓取土豆所有的html里面的超链接代码) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午10:09:55 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class TudouHtmlService {
	public static String htmlCode(String url){
		String htmlCode = null;
		Document document = null;
		try {
			document = Jsoup.connect(url).get();
			htmlCode = document.html();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return htmlCode;
	}
	
	public static Queue getUrlQueue(String url){
		Queue queue = new Queue();
		String htmlCode = htmlCode(url);
		String reg ="(http://([\\w-]+\\.)+[\\w-]+(:[0-9]+)*(/[\\w-]+)*(/[\\w-]+\\.(html|jsp|php|asp|aspx)))";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(htmlCode);
		while (matcher.find()) {
			if (!queue.isContians(matcher.group())) {
				queue.addQueue(matcher.group());
			}
		}
		return queue;
	}
	
	public static void main(String[] args) {
		Queue queue  = getUrlQueue("http://www.tudou.com");
		Iterator iterator = queue.getQueueIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
