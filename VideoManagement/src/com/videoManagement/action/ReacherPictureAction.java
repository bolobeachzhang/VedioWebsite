package com.videoManagement.action;

import java.util.List;

import org.apache.poi.hpbf.extractor.PublisherTextExtractor;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagemen.picture.PictureUtil;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.ReacherPictureServiceDao;
import com.videoManagement.util.ActionUtil;

/**
 * @ClassName:ReacherPictureAction
 * @Description: TODO(用来抓取图片)
 * @author 张兵 【390125214@qq.com】
 * @date 2013-3-31 下午1:42:39
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class ReacherPictureAction extends ActionUtil {
	@Autowired
	private ReacherPictureServiceDao reacherPictureServiceDao;
	private String categoryName;
	private String imgsz;// 图片大小
	private String as_filetype;// 图片后缀类型
	private String imgcolor;// 图片颜色
	private String imgc;// 图片灰度
	private String url;// 图片URL

	public String getImgsz() {
		return imgsz;
	}

	public void setImgsz(String imgsz) {
		this.imgsz = imgsz;
	}

	public String getAs_filetype() {
		return as_filetype;
	}

	public void setAs_filetype(String as_filetype) {
		this.as_filetype = as_filetype;
	}

	public String getImgcolor() {
		return imgcolor;
	}

	public void setImgcolor(String imgcolor) {
		this.imgcolor = imgcolor;
	}

	public String getImgc() {
		return imgc;
	}

	public void setImgc(String imgc) {
		this.imgc = imgc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	//根据网址查询url
	@Action(value = "/getImageUrlAction", results = { @Result(name = "pictureSeatch", type = "chain", location = "pictureSeatchAction") })
	public String getImageUrl() throws Exception {
		PictureUtil pictureUtil = new PictureUtil();
		String googleUrl = "https://ajax.googleapis.com/ajax/services/search/images?rsz=8&imgtype=photo&v=1.0&hl=zh-TW"; 
		// google
		List<Images> images2 = pictureUtil.getGoogleImage(googleUrl, imgc,
				imgcolor, categoryName, url, imgsz, as_filetype);
		for (Images images3 : images2) {
			reacherPictureServiceDao.save(images3);
		}
		return "pictureSeatch";
	}

	//url的查询跳转
	@Action(value = "pictureSeatchAction", results = { @Result(name = "pictureSeatch", location = "/jsp/behind_JSP/straty_manager/tupianSearchManage.jsp") })
	public String pictureSeatchAction() {
		return "pictureSeatch";
	}
	@Action(value = "/getImageUrlByFlickr", results = { @Result(name = "pictureSeatch", type = "chain", location = "pictureSeatchAction") })
	public String getImageUrlByFlickr(){
		PictureUtil pictureUtil = new PictureUtil();
		for (int i = 0; i < 10; i++) {
			String flickrURL = "http://api.flickr.com/services/rest/?method=flickr.photos.search&content_type=7&api_key=da8e8c6840579831969d1a87d37ae545&per_page=500&format=json&extras=original_format&page="+i+"&tags="; 
			List<Images> images = pictureUtil.getFlickrImage(flickrURL, categoryName);
			for (Images images2 : images) {
				reacherPictureServiceDao.save(images2);
			}
		}
		return "pictureSeatch";
	}
}
