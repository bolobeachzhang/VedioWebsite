package com.videoManagement.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osm.jsoup.Jsoup;
import org.osm.jsoup.nodes.Document;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.videoHtml.LinkedQueue;

/**
 * @ClassName:VideoService
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午8:27:12
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */
public class VideoService {
	/**
	 * 
	 * @Title: getDocByUrl
	 * @Description: TODO(得到一个URL的所有代码)
	 * @param @param url 视频的url
	 * @param @return 设定文件
	 * @return Document 返回类型
	 */

	public static Document getDocByUrl(String url) {
		LinkedQueue queue = new LinkedQueue();
		queue.addVisitedUrl(url);
		Document document = null;
		try {
			if (queue.isContent(url)) {
				document = Jsoup.connect(url).data("query", "Java")
						  .userAgent("Mozilla")
						  .cookie("auth", "token")
						  .timeout(100000).get();
			} else {
				throw new RuntimeException("错误了。。");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	/**
	 * 
	 * @Title: getHtmlCode
	 * @Description: TODO(得到embed)
	 * @param @param flashUrl 视频的地址
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 */
	public static String getHtmlCode(String flashUrl) {
		return (new StringBuilder("<embed src=\""))
				.append(flashUrl)
				.append("\" allowFullScreen=\"true\" quality=\"high\" width=\"480\" height=\"400\" align=\"middle\" allowScriptAccess=\"always\" type=\"application/x-shockwave-flash\"></embed>")
				.toString();
	}

	/**
	 * 
	 * @Title: getScriptVarByName
	 * @Description: TODO(通过名字得到内容)
	 * @param String
	 *            name 一个id的名字
	 * @param String
	 *            content 传入一个字符串的内容
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public static String getScriptVarByName(String name, String content) {
		String script = content;
		if (content == null) {
			return null;
		} else {
			if (name != "iid") {
				int begin = script.indexOf(name);
				script = script.substring(begin + name.length() + 2);
				int end = script.indexOf(",");
				script = script.substring(0, end);
			} else {
				int begin = script.indexOf(name);
				script = script.substring(begin + name.length() + 1);
				int end = script.indexOf(",");
				script = script.substring(0, end);
			}
			return script.replaceAll("\"", "").trim();
		}
	}

	/**
	 * 
	 * @Title: getContent
	 * @Description: TODO(此方式适合土豆使用)
	 * @param @param document
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public static String getTudouContent(Document document) {
		String content = document.html();
		if (content!=null) {
			String scriptString = null;
			String lstr = "<script>var pageId";
			String rstr = "</script>";
			String reg = "(?=(" + lstr + "))[.\\n\\s\\S]*?(?<=(" + rstr + "))";
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				scriptString = matcher.group();
			}
			return scriptString;
		}else {
			return null;
		}
		
	}

	public FlashVedio getVideoInfo(String url) {
		FlashVedio video = new FlashVedio();
		if (url.indexOf("tudou.com") != -1) {
			try {
				video = getTudouVideo(url);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("视频为空。。。。。");
				video = null;
			}
		}
		return video;
	}

	/**
	 * @Title: getTudouVideo
	 * @Description: TODO(专门用来抓取土豆网的视频)
	 * @param @param url
	 * @param @return 设定文件
	 * @return VideoBean 返回类型
	 */
	public static FlashVedio getTudouVideo(String tudouUrl) {
		Document document = getDocByUrl(tudouUrl);
		String content = getTudouContent(document);
		if (content!=null) {
			String title = getScriptVarByName(",kw", content);
			if (title == null){
				title = "null";
			}
			String time = getScriptVarByName("time", content);
			if (time==null) {
				time = "null";
			}
			String pic = getScriptVarByName("pic", content);
			if (pic == null) {
				pic = "null";
			}
			if (pic.contains("l:")) {
				String lstr = "http";
				String rstr = "'";
				String reg = "(?=("+lstr+"))[.\\n\\s\\S]*?(?=("+rstr+"))";
				Pattern pattern = Pattern.compile(reg);
				Matcher matcher = pattern.matcher(pic);
				while (matcher.find()) {
					System.out.println(matcher.group());
					pic = matcher.group();
				}
			}
			
			String iid = getScriptVarByName("iid", content);
			if (iid==null) {
				iid = "null";
			}
			String icode = getScriptVarByName("icode", content);
			if(icode==null){
				icode ="null";
			}
			String source = getScriptVarByName(",k", content);
			if (source==null) {
				source = "null";
			}
			String flashUrl = "http://www.tudou.com/l/" + icode.trim() + "&iid="
					+ iid + "/v.swf";
			FlashVedio videoBean = new FlashVedio();
			videoBean.setFlashTime(time);
			videoBean.setPageUrl(tudouUrl);
			videoBean.setFlashImagePath(pic);
			videoBean.setUrl(flashUrl);
			videoBean.setTitle(title);
			videoBean.setDetailInfo(source);
			return videoBean;
		}else {
			return null;
		}
		
	}
}
