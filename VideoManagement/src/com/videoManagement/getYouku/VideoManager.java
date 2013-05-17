package com.videoManagement.getYouku;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Sort;

/**
 * 获取优酷视频
 * 
 * @author 代兵
 */
public class VideoManager {
	
	public static String clickNum ="";
	public static String time ="";
	public static boolean check2(String url) throws Exception {
		String pic = getElementAttrById("s_sina", url, "href");
		String flashUrl = getElementAttrById("link2", url, "value");
		if (flashUrl == null || pic == null) {
			return false;
		}
		return true;

	}

	/**
	 * 根据HTML的ID键及属于名，获取属于值
	 * 
	 * @param id
	 *            HTML的ID键
	 * @param attrName
	 *            属于名
	 * @return 返回属性值
	 */
	public static String getElementAttrById(String id, String url,
			String attrName) throws Exception {
		Document doc = getURLContent(url);
		Element et = doc.getElementById(id);
		if (et == null) {
			// System.out.println("无效的优酷链接");
			return null;
		} else {
			String attrValue = et.attr(attrName);
			return attrValue;
		}

	}

	/**
	 * 获取优酷网页的内容
	 */
	public static Document getURLContent(String url)
			throws MalformedURLException, IOException,
			UnsupportedEncodingException {
		Document doc = getCon(url);
		return doc;
	}

	/**
	 * 更具url获取本网页title
	 * 
	 * @param url
	 *            查询的url
	 * @return 返回title
	 * @throws IOException
	 */

	public static String getTitle(String url) throws IOException {
		Document doc = getCon(url);
		String title = doc.title();
		return title;
	}


	/**
	 * 获取网页源码
	 * 
	 * @param url
	 *            搜索的url
	 * @return 网页源码
	 * @throws IOException
	 */
	public static Document getCon(String url) throws IOException {
		Document doc = Jsoup.connect(url)
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(600000)
				  .post();
		return doc;
	}

	/**
	 * 获取网页所有的链接
	 * 
	 * @param url
	 *            搜索的url
	 * @return 网页源码
	 * @throws IOException
	 */
	public List<String> getVideosLink(String url) throws IOException {

		List<String> list = getAllsLink(url);
		// 如果集合中包含了已经存在的链接 则不添加进list对象 减少重复的抓取
		List<String> list2 = new ArrayList<String>();
		for (String link : list) {
			//System.out.println("link***" + link);
			if (checkUrl(link) && list2.contains(link) == false) {
				list2.add(link);
			}
		}
		return list2;
	}

	/**
	 * 
	 * 得到所有的链接
	 * 
	 */
	public static List<String> getAllsLink(String url) throws IOException {
		// 一个网页的所有超链接对象
		List<String> list = new ArrayList<String>();
		Document document = getCon(url);
		Elements links = (Elements) document.getElementsByTag("a");
		for (Element element : links) {
			String href = element.attr("href");
			list.add(href);
		}
		return list;
	}

	/**
	 * 确定该链接是否属于优酷
	 * 
	 * @param url
	 *            （输入的url）
	 * @return 返回boolean对象
	 */
	public static boolean checkUrl(String url) {
		// int index = url.lastIndexOf(".");// 获取url字符串中“.”的最后一个索引
		// String last = url.substring(index + 1);// 返回a="html"
		if ((url.contains("youku.com") && url.contains("html")) || ( url.contains("soku") && url.contains("search"))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param 一个已经有效的url链接
	 * @return 返回一个video对象
	 * @throws Exception
	 */
	public static FlashVedio getVideo(String url) throws Exception {
		FlashVedio flashVedio = new FlashVedio();
		String pic = getImage(url);
		//System.out.println("视频缩略图：" + pic);
		String flashUrl = getElementAttrById("link2", url, "value");
		//System.out.println("视频地址：" + flashUrl);
		String title = getTitle(url);
		flashVedio.setFlashImagePath(pic);
		System.out.println("视频缩略图：" + pic);
		flashVedio.setFlashType("微电影 ");
		flashVedio.setDetailInfo(title);
		System.out.println("视频详细信息"+title);
		flashVedio.setTitle(title);
		System.out.println("视频title：" + title);
		flashVedio.setContent("优酷的视频");
		flashVedio.setAudit(0);
		flashVedio.setContent("auto"+0);
		flashVedio.setEnableds("0");
		flashVedio.setContent("enable");
		flashVedio.setFlashTime(time);
		System.out.println("时长"+time);
		flashVedio.setOrigin(0);
		flashVedio.setContent("优酷的视频Origin"+0);
		flashVedio.setResourcesType(1);
		flashVedio.setCaptureTime(new Date());
		flashVedio.setUrl(flashUrl);
		System.out.println("视频地址：" + flashUrl);
		flashVedio.setPageUrl(url);
		flashVedio.setClickNums(clickNum);
		return flashVedio;

	}

	/**
	 * 
	 * @param url
	 *            网页的链接
	 * @param list1
	 * @return 消去重读的url对象
	 * @throws IOException
	 */

	public static List<String> removeRepeated2(String url, List<String> list1)
			throws IOException {
		// 得到已经遍历过的网站的list、
		List<String> list2 = getAllsLink(url);
		// 得到下一个页面的所有的链接 消除遍历过的
		list2.retainAll(list1);
		// 得到交集
		list1.removeAll(list2);
		return list1;

	}

	/**
	 * 
	 * 获取视频的缩略图和设置点击量和时长
	 * 
	 * @throws Exception
	 */
	public static String getImage(String url) throws Exception {
		//
		String link = getElementAttrById("s_youku", url, "href");
		Document document = getCon(link);
		Elements elements = document.getElementsByTag("img");
		time=document.getElementsByClass("num").get(0).text();
		System.out.println("时间：：："+time);
		clickNum = document.getElementsByClass("num").get(1).text();
		System.out.println("点击量：：："+clickNum);
		if (elements.size() == 0) {
			return "http://www.youku.com/";
		} else {		
			String imageUrl = elements.get(0).attr("src");		
			return imageUrl;
		}

	}

	/*public static List<FlashVedio> romoveRepeat(List<FlashVedio> flashVedios) {
		// 储存url的list集合
		List<String> urList = new ArrayList<String>();
		// 消除重复的url
		// System.out.println("vedio.size::"+vedios.size());
		for (int i = 0; i < flashVedios.size(); i++) {
			String url = flashVedios.get(i).getUrl();
			if (urList.contains(flashVedios.get(i).getUrl())) {
				flashVedios.remove(i);
			} else {
				urList.add(url);
			}
		}
		return flashVedios;
	}
*/
}
