package com.videoManagement.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceDao.ManageuploadeResource;
import com.videoManagement.serviceImp.ManageuploadeResourceImp;
import com.videoManagement.util.ActionUtil;

@Controller
public class ManageuploadeResourceAction extends ActionUtil{
	private String currentPage;
	private String buttonType;
	private String imageSortType;
	private String flashSortType;
	
	public String getFlashSortType() {
		return flashSortType;
	}
	public void setFlashSortType(String flashSortType) {
		this.flashSortType = flashSortType;
	}
	public String getImageSortType() {
		return imageSortType;
	}
	public void setImageSortType(String imageSortType) {
		this.imageSortType = imageSortType;
	}
	public String getButtonType() {
		return buttonType;
	}
	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	@Autowired
	private ManageuploadeResourceImp manageuploadeResource;
	@Action(value = "delUploudImages", results = { @Result(name = "delUploudImages", type = "redirect", location = "uploadImages?currentPage=${currentPage}&imageSortType=${imageSortType}") })
	public String delUploudImages(){
		int id = Integer.valueOf(this.getRequest().getParameter("id"));
		String sql = "from Images where id ="+id;
		List< Images> images = manageuploadeResource.query(sql);
		String path = ServletActionContext.getServletContext()
				.getRealPath("imagesResources");
		String sqlPath = images.get(0).getUrl();
		String ImageName=null;
		if (sqlPath.lastIndexOf("/") >= 0) {
			ImageName = sqlPath.substring(sqlPath
					.lastIndexOf("/"));
		}
		path = path+"/"+ImageName;
		manageuploadeResource.delUploadResource(images.get(0),path);
		return "delUploudImages";
	}
	
	
	@Action(value = "delUploudFlash", results = { @Result(name = "delUploudFlash", type = "redirect", location = "uploadVedio?currentPage=${currentPage}&flashSortType=${flashSortType}") })
	public String delUploudFlash(){
		int id = Integer.valueOf(this.getRequest().getParameter("id"));
		String sql = "from FlashVedio where id ="+id;
		List<FlashVedio> flashVedios = manageuploadeResource.query(sql);
		String sqlPath = flashVedios.get(0).getUrl();
		String path = ServletActionContext.getServletContext()
				.getRealPath("flashResources");
		String flashName = sqlPath.substring(sqlPath.lastIndexOf("/"));
		String flashImagePath = flashName.substring(0,flashName.lastIndexOf("."))+".jpg";
		
		String imagePath =  path+"/"+flashImagePath;
		String falshPath =  path+"/"+flashName;
		
		manageuploadeResource.delUploadResource(flashVedios.get(0),imagePath);
		File file = new File(falshPath);
		if(file.isFile()){
			file.delete();
		}
		return "delUploudFlash";
	}
	HttpServletRequest request = this.getRequest();
	String[] checkbox = request.getParameterValues("checkboxImg");
	@Action(value = "deelMoreImages", results = { @Result(name = "delMoreImages", type = "redirect", location = "uploadImages?currentPage=${currentPage}&imageSortType=${imageSortType}") })
	public String delMoreImages(){
		/*imageSortType = request.getParameter("imageSortType");
		this.setImageSortType(imageSortType);*/
		if(checkbox!=null){
			int count = checkbox.length;
			if(buttonType.equals("del")){//表示点击的是删除
				for(int i=0;i<count;i++){
					int id = Integer.valueOf(checkbox[i]);
					String sql = "from Images where id ="+id;
					List< Images> images = manageuploadeResource.query(sql);
					String path = ServletActionContext.getServletContext()
							.getRealPath("imagesResources");
					
					String sqlPath = images.get(0).getUrl();
					String ImageName=null;
					if (sqlPath.lastIndexOf("/") >= 0) {
						ImageName = sqlPath.substring(sqlPath
								.lastIndexOf("/"));
					}
					path = path+"/"+ImageName;
					manageuploadeResource.delUploadResource(images.get(0),path);
				}
			}
			if(buttonType.equals("publish")){//批量修改信息
				
			}
		}
		return "delMoreImages";
	}
	
	@Action(value = "delMoreFlash", results = { @Result(name = "delMoreFlash", type = "redirect", location = "uploadVedio?currentPage=${currentPage}&flashSortType=${flashSortType}") })
	public String delMoreFlash(){
		if(buttonType.equals("del")){//表示点击的是删除
			int count = checkbox.length;
			for(int i=0;i<count;i++){
				int id = Integer.valueOf(checkbox[i]);
				String sql = "from FlashVedio where id ="+id;
				List<FlashVedio> flashVedios = manageuploadeResource.query(sql);
				String sqlPath = flashVedios.get(0).getUrl();
				String path = ServletActionContext.getServletContext()
						.getRealPath("flashResources");
				String flashName = sqlPath.substring(sqlPath.lastIndexOf("/"));
				String flashImagePath = flashName.substring(0,flashName.lastIndexOf("."))+".jpg";
				
				String imagePath =  path+"/"+flashImagePath;
				String falshPath =  path+"/"+flashName;
				
				manageuploadeResource.delUploadResource(flashVedios.get(0),imagePath);
				File file = new File(falshPath);
				if(file.isFile()){
					file.delete();
				}
			}
		}
		return "delMoreFlash";
	}
	
}
