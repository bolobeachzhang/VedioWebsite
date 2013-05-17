package com.videoManagement.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceImp.Ximages;
import com.videoManagement.util.ActionUtil;

@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class UploadFileDemoAction extends ActionUtil {

	@Resource
	private BasicServiceImp basicServiceImp;
	private static final long serialVersionUID = 1L;
	private Date fileUploadeTime;
	private File uploadify;
	private String fileInputFileName;
	private String fileType;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public File getUploadify() {
		return uploadify;
	}

	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}

	public String getFileInputFileName() {
		return fileInputFileName;
	}

	public void setFileInputFileName(String fileInputFileName) {
		this.fileInputFileName = fileInputFileName;
	}

	@Action(value = "uploadifyAction")
	public String uploadFile() {
		Images images = new Images();
		FlashVedio flashVedio = new FlashVedio();
		Ximages ximages = new Ximages();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		// 获取随机数
		Random r = new Random();
		int rannum = (int) (r.nextDouble() * (999999 - 100000 + 1)) + 100000;
		// 获取拓展名
		String extName = null;
		if (fileInputFileName.lastIndexOf(".") >= 0) {
			extName = fileInputFileName.substring(fileInputFileName
					.lastIndexOf("."));
		}
		if (extName.equals(".jpg") || extName.equals(".png")
				|| extName.equals(".gif") || extName.equals(".jpeg")
				|| extName.equals(".JPG") || extName.equals(".PNG")
				|| extName.equals(".GIF") || extName.equals(".JPEG")) {
			// 上传文件保存路径
			String savePath = ServletActionContext.getServletContext()
					.getRealPath("imagesResources");
			// 判断文件夹是否存在
			File dirname = new File(savePath);
			if (!dirname.isDirectory()) { // 目录不存在
				dirname.mkdir(); // 创建目录
			}
			fileInputFileName = rannum + extName;
			String realyImagePath = savePath + "/" + fileInputFileName;

			uploadify.renameTo(new File(savePath + "/" + fileInputFileName));

			String sqlPath = "imagesResources" + "/" + fileInputFileName;
			String imagesRadtio = ximages.getImageRatio(realyImagePath);
			// 文件大小
			Long fileSize = uploadify.length();
			fileUploadeTime = new Date();
			System.out.println(fileUploadeTime);
			// 资源名称
			images.setTitle(fileInputFileName);
			// 资源后缀名
			images.setFormat(extName);
			// 是否有效
			images.setEnableds("0");
			// 图片或flash资源1表示是flash
			images.setResourcesType(0);
			// 文件大小
			images.setResourceSize(fileSize.toString());
			// 文件路径
			images.setUrl(sqlPath);
			// 父路径,用于存放全路径
			images.setPageUrl(realyImagePath);
			// 代表上传的还是网上抓取的1表示上传的
			images.setOrigin(1);
			images.setCaptureTime(new Date());
			// 0表示未审核
			images.setAudit(1);
			images.setCaptureTime(fileUploadeTime);
			images.setClickNums("0");
			images.setResolution(imagesRadtio);
			System.out.println(imagesRadtio);
			images.setImageType(fileType);
			basicServiceImp.save(images);
			// ajax返回数据
			try {
				response.getWriter().println(
						"成功上传文件《" + fileInputFileName + "》！");
			} catch (IOException e) {
				throw new RuntimeException();
			}
		} else {
			if (fileInputFileName.lastIndexOf(".") >= 0) {
				extName = fileInputFileName.substring(fileInputFileName
						.lastIndexOf("."));
			}
			// 上传文件保存路径
			String savePath = ServletActionContext.getServletContext()
					.getRealPath("flashResources");
			File dirname = new File(savePath);
			if (!dirname.isDirectory()) {
				dirname.mkdir();
			}
			fileInputFileName = rannum + extName;
			uploadify.renameTo(new File(savePath + "/" + fileInputFileName));
			// 视频文件
			String videoRealPath = ServletActionContext.getServletContext()
					.getRealPath("flashResources") + "/" + fileInputFileName;
			String flashSavePath = "flashResources" + "/" + fileInputFileName;

			String sqlPath = "flashResources" + "/" + fileInputFileName;
			String exePath = ServletActionContext.getServletContext()
					.getRealPath("ffmpeg") + "/ffmpeg.exe";

			// 获取视频截图
			ximages.processImg(videoRealPath, exePath);
			// 视频截图保存路径
			String imageRealPath = sqlPath.substring(0, sqlPath.indexOf("."))
					+ ".jpg";

			// 获取视频播放时间
			String flashTime = ximages.getTime(videoRealPath);

			if (extName.equals(".flv")) {
				flashVedio.setTranscoding(1);
			}
			Long fileSize = null;
			fileUploadeTime = new Date();
			// 文件大小
			fileSize = uploadify.length();
			flashVedio.setCaptureTime(fileUploadeTime);
			flashVedio.setTitle(fileInputFileName);
			flashVedio.setEnableds("0");
			// 表示是视频
			flashVedio.setResourcesType(1);
			flashVedio.setResourceSize(fileSize.toString());
			flashVedio.setUrl(sqlPath);
			flashVedio.setFlashImagePath(imageRealPath);
			// 表示上传的
			flashVedio.setOrigin(1);
			flashVedio.setClickNums("0");
			flashVedio.setAudit(1);
			flashVedio.setFlashType(fileType);
			flashVedio.setFlashTime(flashTime);
			flashVedio.setPageUrl(videoRealPath);
			basicServiceImp.save(flashVedio);

			try {
				response.getWriter().println(
						"成功上传文件《" + fileInputFileName + "》！");
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
		return null;
	}

}