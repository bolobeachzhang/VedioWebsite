package com.videoManagemen.picture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.JsonObject;
import com.videoManagement.bean.Images;

/**   
 * @ClassName:PictureUtil
 * @Description: TODO(使用google reach image API 以及 flickr API 来抓取图片) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-3-31 上午11:08:12 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 * @see ================================================================================================================ 
 * @see 找到Google Image Search API页面 
 * @see 1、进入'http://code.google.com'网站，点击左侧AJAX APIs后，会转向到'https://developers.google.com/loader/?hl=zh-CN' 
 * @see 2、展开左侧APIs Using the Loader，点击Image Search，跳转到'https://developers.google.com/image-search/?hl=zh-cn' 
 * @see 3、点击页面中的developer documentation链接，跳转到'https://developers.google.com/image-search/v1/index?hl=zh-cn' 
 * @see 4、点击页面中的JSON Developer's Guide链接，跳转到'https://developers.google.com/image-search/v1/jsondevguide?hl=zh-cn' 
 * @see ================================================================================================================ 
 * @see 解析Google返回的json字符串的方法 
 * @see Google所返回的json字符串中，会直接把图片的URL以'url'参数加入到json中返回给我们 
 * @see 所以我们直接解析其返回的json字符串中的'url'参数值，即可。下面是Google返回的json字符串的示例格式 
 * @see {"responseData": {"results":[{"GsearchResultClass":"GimageSearch","width":"220","height":"204", 
 * @see "imageId":"ANd9GcSvKWlLJwv3gayNuFIpl0eCPwIcdEwUzdFo-HsTZv-z1l5JL7WYMhacZg","tbWidth":"107","tbHeight":"99", 
 * @see "unescapedUrl":"http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/IBM_Thinkpad_R51.jpg/220px-IBM_Thinkpad_R51.jpg", 
 * @see "url":"http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/IBM_Thinkpad_R51.jpg/220px-IBM_Thinkpad_R51.jpg", 
 * @see "visibleUrl":"en.wikipedia.org","title":"\u003cb\u003eThinkPad\u003c/b\u003e - Wikipedia, the free encyclopedia", 
 * @see "titleNoFormatting":"ThinkPad - Wikipedia, the free encyclopedia","originalContextUrl":"http://en.wikipedia.org/wiki/ThinkPad", 
 * @see "content":"IBM \u003cb\u003eThinkPad\u003c/b\u003e R51","contentNoFormatting":"IBM ThinkPad R51", 
 * @see "tbUrl":"http://t3.gstatic.com/images?q\u003dtbn:ANd9GcSvKWlLJwv3gayNuFIpl0eCPwIcdEwUzdFo-HsTZv-z1l5JL7WYMhacZg"}, 
 * @see {......}, 
 * @see "responseDetails": null, "responseStatus": 200} 
 * @see 所以我们得到的图片URL就是第27行'url'参数的值http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/IBM_Thinkpad_R51.jpg/220px-IBM_Thinkpad_R51.jpg 
 * @see ================================================================================================================ 
 * @see 找到flickr.photos.search API页面 
 * @see 1、点击Flickr首页'http://www.flickr.com'底部的'API说明文件'链接，会转向到'http://www.flickr.com/services/api/' 
 * @see 2、点击右侧photos下的'flickr.photos.search'链接，跳转到'http://www.flickr.com/services/api/flickr.photos.search.html' 
 * @see 3、另外还有一个'http://kylerush.net/blog/flickr-api/'是我在Google上搜索到的，在这里可以找到Flickr的图片服务器的URL 
 * @see 4、如果想查看Flickr返回的json格式，可以点击'API说明文件'页面左侧'回應格式'下的'JSON'链接 
 * @see   其具体页面为'http://www.flickr.com/services/api/response.json.html' 
 * @see ================================================================================================================  
 * @see 解析Flickr返回的json字符串的方法 
 * @see 0、Flickr与Google不同，Google会直接在返回的json中加入图片的URL，而Flickr需要我们解析其返回的json后，再拼装出来图片的URL 
 * @see 1、点击Flickr首页'http://www.flickr.com'底部的'API说明文件'链接，会转向到'http://www.flickr.com/services/api/' 
 * @see 2、然后点击该页面左侧的'URL'链接，会跳转到'http://www.flickr.com/services/api/misc.urls.html' 
 * @see 3、阅读该页面得知Flickr的图片URL需要自行拼接，如http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg 
 * @see 4、以下是Flickr返回的json字符串的示例格式 
 * @see   jsonFlickrApi({"photos":{"page":1, "pages":429, "perpage":300, "total":"128631", 
 * @see   "photo":[{"id":"6845488017", "owner":"71906482@N04", "secret":"0f4c482ced", "server":"7007", "farm":8, 
 * @see             "title":"Mini-Mini Schnauzers", "ispublic":1, "isfriend":0, "isfamily":0}, 
 * @see             {......}]}, 
 * @see             "stat":"ok"}) 
 * @see 5、那么根据这个json字符串所拼接出来的图片URL就是'http://farm8.staticflickr.com/7007/6845488017_0f4c482ced.jpg' 
 * @see ================================================================================================================ 
 */
public class PictureUtil {
	/**
	 * 
	* @Title: getGoogleImage 
	* @Description: TODO(这个方法是用来使用googleImage API抓取图片的,google返回6400个) 
	* @param  googleUrl google服务器的名字
	* @see String googleUrl = "https://ajax.googleapis.com/ajax/services/search/images?rsz=8&imgtype=photo&v=1.0&hl=zh-TW"; 
	* @param  categoryName 您要检索的关键字
	* @param as_filetype 图片的格式 只能jpg,png,gif,BMP 
	* @param imgsz 图片的大小     imgsz=icon|small|medium|large|xlarge|xxlarge|huge 
	* @param imgcolor imgcolor=black|blue|brown|gray|green|orange|pink|purple|red|teal|white|yellow
	* @param WebSite 您要搜索的网站
	* @param imgc 颜色灰度 imgc = gray(灰度图像)|color (彩色图像)
	* @param @return    设定文件 
	* @return List<Images>    返回一个list<images>对象
	*
	 */
	public List<Images> getGoogleImage(String googleUrl,String imgc,String imgcolor,String categoryName,String WebSite,String imgsz,String as_filetype){
		NetworkUtil networkUtil = new NetworkUtil();
		//用来存放抓取过来的images属性的
		List<Images> listImages  = new ArrayList<Images>();
		//用来存放google返回过来的数据信息 json数据格式
		List<String> jsonImages = new ArrayList<String>();
		//每次取出4*8张图片
		String url ;
		for (int i = 0; i < 8; i++) {
				url = new StringBuffer(googleUrl).append("&q=").append(categoryName).append("&as_sitesearch=")
						.append(WebSite).append("&imgsz=").append(imgsz).append("&as_filetype=").append(as_filetype)
						.append("&imgcolor=").append(imgcolor).append("&imgc=").append(imgc)
						.append("&start=").append(8*i).toString(); 
			String code = networkUtil.getStringContentFromURL(url);
            jsonImages.add(code);  
           System.out.println(code);
		}
		//然后把得到的遍历出来
		for (String result : jsonImages) {
			JSONObject jsonStr = JSONObject.fromObject(result);  
            JSONObject responseData = jsonStr.getJSONObject("responseData");  
            JSONArray results = responseData.getJSONArray("results");  
            for(int i=0; i<results.size(); i++){  
                JSONObject jsonObject = results.getJSONObject(i);  
                Images images = new Images();
                images.setPageUrl(jsonObject.getString("unescapedUrl")); //得到抓取的url
                images.setUrl(jsonObject.getString("url"));//得到图片的url
                images.setTitle(jsonObject.getString("title"));//得到图片的title
                images.setContent(jsonObject.getString("content"));//得到图片的内容
                images.setCaptureTime(new Date());//得到抓取的时间
                images.setEnableds("0");//判断是否审核
                images.setAudit(0);
                images.setResourcesType(0);
                images.setCaptureTime(new Date());
                images.setResolution(jsonObject.getString("height")+"*"+jsonObject.getString("width"));//得到像素
                listImages.add(images); //得到图片的URL，并放到returnedList中  
            }  
		}
		return listImages;
	}
	/**
	 * 
	* @Title: getFlickrImage 
	* @Description: TODO(这里使用flickr服务器抓取图片,本次抓取4000个图片) 
	* @param  flickrUrl flickrUrl的服务器地址
	* @param categoryName 您要检索的信息(可以是中文)
	* @see String flickrURL = "http://api.flickr.com/services/rest/?method=flickr.photos.search&content_type=7&api_key=da8e8c6840579831969d1a87d37ae545&per_page=500&format=json&extras=original_format&page=1&tags=";  
	* @param @return    设定文件 
	* @return List<Images>    返回images类型的服务器地址
	*
	 */
	public List<Images> getFlickrImage(String flickrUrl,String categoryName){
		List<Images> listImages = new ArrayList<Images>();
		
		String jsonContent = NetworkUtil.getStringContentFromURL(flickrUrl + categoryName);  
        //将Flickr返回的json字符串中，开始部分的'jsonFlickrApi('和结尾部分的')'截掉，剩下的就是一个标准的json格式的字符串了  
        jsonContent = jsonContent.substring(14, jsonContent.length()-1);  
          
        JSONObject jsonObject = JSONObject.fromObject(jsonContent);  
        //先获取到photos对应的对象，然后再获取到photo对应的数组  
        JSONArray jsonArray = jsonObject.getJSONObject("photos").getJSONArray("photo");  
        
        for (int i = 0; i < jsonArray.size(); i++) {
        	//得到传过来的json对象
			JSONObject object = jsonArray.getJSONObject(i);
			String ID = object.getString("id");  
            String secretID = object.getString("secret");  
            String serverID = object.getString("server");  
            int farmID = object.getInt("farm"); //Flickr返回的farm值是一个整型数字  
            //拼接http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg  
            StringBuffer sb = new StringBuffer();  
            sb.append("http://farm").append(farmID).append(".staticflickr.com/").append(serverID).append("/").append(ID).append("_").append(secretID).append(".jpg"); 
            Images images = new Images();
            images.setUrl(sb.toString());
            String title = object.getString("title");
            if (title==null) {
				title = "null";
			}
            images.setTitle(title);
            images.setContent(title);
            images.setFormat("jpg");
            images.setAudit(0);
            images.setResourcesType(0);
            images.setPageUrl("http://farm9.staticflickr.com/");
            images.setCaptureTime(new Date());
            listImages.add(images);
        }
		return listImages;
	}
	public static void main(String[] args) {
		PictureUtil pictureUtil= new PictureUtil();
	/*	String flickrURL = "http://api.flickr.com/services/rest/?method=flickr.photos.search&content_type=7&api_key=da8e8c6840579831969d1a87d37ae545&per_page=500&format=json&extras=original_format&page=1&tags=";
		List<Images> images = pictureUtil.getFlickrImage(flickrURL, "黄山");
		for (Images images2 : images) {
			System.out.println(images2.getUrl()+"*****"+images2.getTitle());
		}*/
		System.out.println("***************************************************");
		String googleUrl ="https://ajax.googleapis.com/ajax/services/search/images?rsz=8&v=1.0&as_sitesearch=cdu.edu.cn&hl=zh-TW"; 
		String categoryName = "computer";
		List<Images> images3 = pictureUtil.getGoogleImage(googleUrl,"color","red",categoryName,"http://www.cdu.edu.cn","medium","jpg");
		System.out.println(images3.size());
		for (Images images2 : images3) {
			System.out.println(images2.getUrl());
		}
	}
}
