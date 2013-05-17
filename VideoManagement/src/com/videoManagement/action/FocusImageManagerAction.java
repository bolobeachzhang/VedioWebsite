package com.videoManagement.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.FocusImageManagerServiceDao;
import com.videoManagement.util.ActionUtil;

/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 后台管理跳转 actoin
 * @Author 代兵
 * @Date 2013-3-27, 15:56 PM
 * @mailto 707189384@qq.com 评论资源管理
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class FocusImageManagerAction extends ActionUtil {

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileMark() {
		return fileMark;
	}

	public void setFileMark(String fileMark) {
		this.fileMark = fileMark;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String downloadFile() {
		return "download";
	}

	public InputStream getInputStream() {
		String dir = "\\"+pageUrl;
		System.out.println("路径：："+dir);
		// 取相对路径，此相对路径是取webRoot下面的相对路径
		return ServletActionContext.getServletContext()
				.getResourceAsStream(dir);
	}
	private String fileMark;   // 图片的标志 标示是第几张
	private File image;      // 上传的fileiamge
	private String fileType;   // 上传文件的类型
	private String imageFileName; // 上传文件的name
	private String type;   //文件属于哪种焦点图  如主页焦点图
	private String fileRealName; // 文件的真名
	private String pageUrl;
	private InputStream inputStream;
	@Autowired
	private FocusImageManagerServiceDao focusImageManagerServiceDao;
	HttpServletRequest request = ActionUtil.getRequest();
	HttpServletResponse response = ActionUtil.getResponse();

	@Action(value = "focusImage", results = { @Result(name = "focusImage", location = "/jsp/behind_JSP/focusImageManager/focusIamgeManager.jsp") })
	public String focusImage() throws Exception {
		return "focusImage";
	}

	@Action(value = "upLoadImage", results = { @Result(name = "upLoadImage", location = "/jsp/behind_JSP/focusImageManager/MainFocus.jsp") })
	public String upLoadImage() throws Exception {
		// 获得文件的名字
		System.out.println("要换的照片是：：：" + fileMark);
		// 文件夹保存的路径
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"imageFocus");
		// 获取文件的后缀名
		if (imageFileName.lastIndexOf(".") > 0) {
			fileType = imageFileName.substring(imageFileName.lastIndexOf("."));
		}
		String realFilename = fileMark + fileType;
		// 获取文件的保存路径 在下载的时候使用
		String filepath = savePath + "\\" + realFilename;
		System.out.println("filepath:::" + filepath);
		String sqlPath = "imageFocus" + "/" + realFilename;
		// 删除数据库以前存在的
		List<Images> imageOld = focusImageManagerServiceDao.query(
				"from Images i where i.imageType=?", fileMark);
		focusImageManagerServiceDao.delete(imageOld.get(0));
		// 存入数据库
		Images images = new Images();
		images.setCaptureTime(new Date());
		images.setContent(type);
		images.setImageType(fileMark);
		images.setResolution("682*700");
		images.setFormat(fileType); // 设置图片的type
		images.setUrl(sqlPath); // 存储前台显示的路径
		images.setPageUrl(filepath); // 存储下载的路径
		images.setTitle(imageFileName); // 存储文件名
		focusImageManagerServiceDao.save(images);
		// 开始将文件上传
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 建立文件输出流
			fos = new FileOutputStream(filepath);
			// 建立文件上传流
			fis = new FileInputStream(image);
			byte[] buffer = new byte[1024 * 1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
		} finally {
			close(fos, fis);
		}
		// 得到六张主页的焦点图
		List<Images> imagesNew = focusImageManagerServiceDao.query(
				"from Images i where i.content=? order by imageType", type);
		request.setAttribute("images", imagesNew);
		request.setAttribute("flag", 1);
		return "upLoadImage";
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	@Action(value = "focusImage1", results = { @Result(name = "focusImage1", location = "/jsp/behind_JSP/focusImageManager/MainFocus.jsp") })
	public String focusImage1() throws Exception {
		// 得到六张主页的焦点图
		List<Images> images = focusImageManagerServiceDao.query(
				"from Images i where i.content=? order by imageType", type);
		request.setAttribute("images", images);
		return "focusImage1";
	}

	@Action(value = "focusImage2", results = { @Result(name = "focusImage2", location = "/jsp/behind_JSP/focusImageManager/MainFocus.jsp") })
	public String focusImage2() throws Exception {
		// 得到六张视频主页的焦点图
		List<Images> images = focusImageManagerServiceDao.query(
				"from Images i where i.content=? order by imageType", type);
		request.setAttribute("images", images);
		return "focusImage2";
	}

	@Action(value = "focusImage3", results = { @Result(name = "focusImage3", location = "/jsp/behind_JSP/focusImageManager/MainFocus.jsp") })
	public String focusImage3() throws Exception {
		// 得到六张图片主页的焦点图
		List<Images> images = focusImageManagerServiceDao.query(
				"from Images i where i.content=? order by imageType", type);
		request.setAttribute("images", images);
		return "focusImage3";
	}
	
    /**
     * 以下为测试代码
     * @return
     * @throws Exception
     */
	@Action(value = "forWord", results = { @Result(name = "forWord", location = "/jsp/behind_JSP/focusImageManager/downLoad.jsp") })
	public String forWord() throws Exception {
		// 得到下载的资源显示
		List<Images> images = focusImageManagerServiceDao.query(
				"from Images i where i.content=? order by imageType",
				"mainFocus");
		request.setAttribute("images", images);
		return "forWord";
	}

	@Action(value = "downLoadImage", results={@Result(type="stream", name="success" ,
            params={"contentType","application/octet-stream",  
            "inputName","inputStream",  
            "contentDisposition","attachment;filename=\"${fileRealName}\"", 
            /*"inputPath","\\imageFosus\\${fileRealName}",*/
            "bufferSize","4096"  
        })}/*, 
           params={"inputPath","\\imageFosus\\SQLFULL_CHS.iso"} */ 
			)
	
	public String downLoad() throws Exception {
		// 下载的方法  后缀名为临时添加
		fileRealName=fileRealName+".jpg";
		return "success";
	}

}
