/**   
* @Title: PictureDown.java 
* @Package com.videoManagement.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-23 下午7:38:07 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osm.jsoup.Jsoup;
import org.osm.jsoup.nodes.Document;

import com.videoManagement.bean.Images;

/** 
 * @ClassName: PictureDown 
 * @Description: TODO(将图片写入到服务器上) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-23 下午7:38:07 
 *  
 */
public class PictureDown {
	
	/**
	 * 
	* @Title: getHtmlCode 
	* @Description: TODO(得到一个页面的html代码) 
	* @param @param url
	* @param @return    设定文件 
	* @return String    返回类型 
	 */
	public static String getHtmlCode(String url){
		Document document = null;
		try {
			document = Jsoup.connect(url).data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(100000).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (document!=null) {
			return document.html();
		}else {
			return null;
		}
	}
	
	/** 
	* @Title: getPictureUrl 
	* @Description: TODO(通过htmlCode得到image的url) 
	* @param @param htmlCode
	* @param @return    设定文件 
	* @param pageUrl 只抓取网页的源地址
	* @return Set<String>    返回类型 
	*/
	public static List<Images> getPictureUrl(String htmlCode,String pageUrl){
		if (htmlCode!=null) {
			List<Images> images = new ArrayList<Images>();
			String searchImgReg = "(?x)(alt|src|SRC|background|BACKGROUND)=('|\")/?(([\\w-]+/)*([\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";// 用于在网页代码Content中查找匹配的图片链接。
			String searchImgReg2 = "(?x)(alt|src|SRC|background|BACKGROUND)=('|\")(http://([\\w-]+\\.)+[\\w-]+(:[0-9]+)*(/[\\w-]+)*(/[\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";
			Pattern pattern = Pattern.compile(searchImgReg);//首先抓取内容里面的图片
			Matcher matcher = pattern.matcher(htmlCode);
			while (matcher.find()) {
				String url = pageUrl+"/"+matcher.group(3);
				int formatStart = url.lastIndexOf(".");
				int formatEnd = url.length();
				String format = url.substring(formatStart, formatEnd);
				Images images2 = new Images();
				images2.setUrl(url);
				images2.setFormat(format);
				images2.setAudit(0);
				images2.setEnableds("1");
				images2.setPageUrl(pageUrl);
				images2.setResourcesType(0);
				images2.setCaptureTime(new Date());
				images.add(images2);
			}
			Pattern pattern2 = Pattern.compile(searchImgReg2);
			Matcher matcher2 = pattern2.matcher(htmlCode);
			while (matcher2.find()) {
				String url = matcher2.group(3);
				int formatStart = url.lastIndexOf(".");
				int formatEnd = url.length();
				String format = url.substring(formatStart, formatEnd);
				Images images2 = new Images();
				images2.setUrl(url);
				images2.setFormat(format);
				images2.setAudit(0);
				images2.setEnableds("1");
				images2.setPageUrl(pageUrl);
				images2.setResourcesType(0);
				images.add(images2);
			}
			return images;
		}else {
			throw new RuntimeException("对不起没有获取html代码");
		}
	}
	
	/** 
	 * 
	* @Title: downloadPicture 
	* @Description: TODO(得到图片的url并且下载到本地上) 
	* @param @param setUrl    图片的url地址
	* @return void    返回类型 
	* @throws 
	*/
	public static void downloadPicture(Set<String> setUrl){
		try {
			File file ;
			String picUrl;
			BufferedInputStream bufferedInputStream = null;
			FileOutputStream fileOutputStream = null;
			Iterator<String> iterator = setUrl.iterator();
			while (iterator.hasNext()) {
				picUrl = iterator.next();
				System.out.println(picUrl);
				//得到图片的名字
				String fileName = picUrl.substring(picUrl.lastIndexOf("/"));
				String imageFile= "D:/images/";
				//如果不存在那么我们就创建文件
				if (!new File(imageFile).exists()) {
					file = new File(imageFile);
					file.mkdir();
				}
				URL url = new URL(picUrl);
				bufferedInputStream = new BufferedInputStream(url.openStream());
				fileOutputStream = new FileOutputStream(new File(imageFile+fileName));
				int len ;
				while ((len =bufferedInputStream.read())!=-1) {
					fileOutputStream.write(len);
				}
			}
			fileOutputStream.close();
			bufferedInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	* @Title: getPicUrl 
	* @Description: TODO(得到css里面的url,类似于url(../images/header_bei.gif) 的图片url列表) 
	* @param @return    设定文件 
	* @return Set<String>    返回类型 
	* @throws 
	*/
	public static List<String>  getPicUrlByCss(String pageUrl,String htmlCode){
		List<String> set = new ArrayList<String>();
		if (htmlCode!=null) {
			String lstr = "<link";
			String rstr = ">";
			String reg = "(?=("+lstr+"))[.\\n\\s\\S]*?(?<=("+rstr+"))";
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(htmlCode);
			while (matcher.find()) {
				String css = matcher.group();
				//然后得到href的值
				String lstr1 = "href=\"";
				String rstr1 = "\"";
				String reg1 = "(?<=("+lstr1+"))[.\\n\\s\\S]*?(?=("+rstr1+"))";
				Pattern pattern2 = Pattern.compile(reg1);
				Matcher matcher2 = pattern2.matcher(css);
				while (matcher2.find()) {
					String cssUrlString;
					String cssUrl = matcher2.group();
					//cssUrl.replaceAll("href=", "").replaceAll("\"", "");
					//System.out.println(cssUrl);
					if (!cssUrl.contains("http:")) {
						cssUrlString = pageUrl+"/"+cssUrl;
					}else {
						cssUrlString = cssUrl;
					}
					
					if (cssUrlString.contains("ico")) {
						break;
					}
					System.out.println(cssUrlString);
					String str = getHtmlCode(cssUrlString);
					int n1=str.indexOf("url");
					
					while((n1=str.indexOf("url"))!=-1){
						 String s=str.substring(n1);
						 int n2=s.indexOf(")");
						 String s1=s.substring(0,n2+1);
						 str=s.substring(n2+1);
						set.add(s1);
					}
				}
			}
			return set;
		}else {
			return null;
		}
	}
	

	/** 
	* @Title: getStrUrl 
	* @Description: TODO(根据图片的域名 和上面的url列表  得到 图片完整的url) 
	* @param @param abUrl pageUrl抓取网站的URL
	* @param @param urlList
	* @param @return    设定文件 
	* @return Set<String>    返回类型 
	*/
	public static List<Images> getStrUrl(String abUrl,List<String> urlList){
		List<Images> listImages=new ArrayList<Images>();
		for(int i=0;i<urlList.size();i++){
			int n=urlList.get(i).indexOf("/");
			if(n>1){
				String s=urlList.get(i).substring(n);
				String url = abUrl+s.substring(0, s.length()-1);
				
				int formatStart = url.lastIndexOf(".");
				int formatEnd = url.length();
				String format = url.substring(formatStart, formatEnd);
				Images images = new Images();
				images.setUrl(url);
				images.setFormat(format);
				images.setAudit(0);
				images.setEnableds("1");
				images.setPageUrl(abUrl);
				images.setResourcesType(0);
				images.setCaptureTime(new Date());
				listImages.add(images);
			}
		}
		return listImages;
	}
	
	public static void main(String[] args) {
		//得到css里面的url
		Long bs = Calendar.getInstance().getTimeInMillis();
		String url = "http://www.cdu.edu.cn/";
		String htmlCode = getHtmlCode(url);
		List<Images> images = getPictureUrl(htmlCode, url);
		for (Images images2 : images) {
			System.out.println(images2.getUrl());
		}
		
		List<String> urlList = getPicUrlByCss(url,htmlCode);
		List<Images> images2 = getStrUrl(url, urlList);
		for (Images images3 : images2) {
			System.out.println(images3.getUrl()+"css属性的。。。");
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - bs);
	}
}
