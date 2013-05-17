package com.videoManagemen.picture;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;


/**   
* @ClassName:NetworkUtil
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2013-3-31 上午11:19:26 
* @version V1.0   
* @Copyright: Copyright (c) 2013
* @Company:	成都大学信息科学与技术学院重点工作室
*/
public class NetworkUtil {
	/**
	 *  
	* @Title: getStringContentFromURL 
	* @Description: TODO(根据指定的URL获取其返回的内容 ) 
	* @param  url
	* @param     设定文件 
	* @return String    返回类型 
	 */
	public static String getStringContentFromURL(String url){
		StringBuffer sb = new StringBuffer();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try{
			is = new URL(url).openConnection().getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String line = null;
			while(null != (line=br.readLine())){
				sb.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != isr){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	* @Title: writeToLocalFromInternet 
	* @Description: TODO(完成文件的写入操作) 
	* @param @param imageUrl
	* @param @param file    设定文件 
	* @return void    返回类型 
	*
	 */
	public static void writeToLocalFromInternet(String imageUrl, File file){
		InputStream is = null;
		OutputStream os = null;
		try{
			is = new URL(imageUrl).openStream();
			os = new FileOutputStream(file);
			int length = -1;
			byte[] buffer = new byte[7092];
			while(-1 != (length=is.read(buffer,0,7092))){
				os.write(buffer, 0, length);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != os){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}