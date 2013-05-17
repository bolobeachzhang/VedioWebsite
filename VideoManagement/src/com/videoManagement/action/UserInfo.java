package com.videoManagement.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Users;
import com.videoManagement.longThread.OperateImage;
import com.videoManagement.serviceImp.Ximages;
import com.videoManagement.util.ActionUtil;

public class UserInfo extends ActionUtil {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private BasicServiceImp basicServiceImp;

	Ximages ximages = new Ximages();
	
	private File uploadify;
	private String fileInputFileName;
	private int width;
	private int height;
	private int x;
	private int y;
	private int id;

	public int getWidth() {
		return width;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	
	// 进入个人中心的action
	@Action(value = "UserInfo", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/personalSpaceMain.jsp") })
	public String UserInfo() throws Exception {
		/* String sql = "from Users where userName = name"; */
		String sql = "from Users";
		List<Users> users = basicServiceImp.query(sql);
		Users user = users.get(0);
		this.getRequest().setAttribute("user", user);
		return "success";
	}

	// 进入个人中心的personaldata action
	@Action(value = "personaldata", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/personaldata.jsp") })
	public String personaldata() throws Exception {
		String sql = "from Users";
		List<Users> users = basicServiceImp.query(sql);
		Users user = users.get(0);
		this.getRequest().setAttribute("user", user);
		return "success";
	}

	// 进入个人中心的photoSet action
	@Action(value = "photoSet", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/photoSet.jsp") })
	public String photoSet() throws Exception {
		String sql = "from Users";
		List<Users> users = basicServiceImp.query(sql);
		Users user = users.get(0);
		this.getRequest().setAttribute("user", user);
		return "success";
	}

	// 进入个人中心的photoSet action
	@Action(value = "passwordSet", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/passwordSet.jsp") })
	public String passwordSet() throws Exception {
		System.out.println("竟来了！！！");
		return "success";
	}

	// 进入个人中心的photoSet action
	@Action(value = "openVIP", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/openVIP.jsp") })
	public String openVIP() throws Exception {
		System.out.println("竟来了！！！");
		return "success";
	}

	// 进入个人中心的photoSet action
	@Action(value = "leaveMessageBox", results = { @Result(name = "success", location = "/jsp/front_JSP/personalSpace_jsp/leaveMessageBox.jsp") })
	public String leaveMessageBox() throws Exception {
		System.out.println("竟来了！！！");
		return "success";
	}

	// 头像上传
	String pathString = ServletActionContext.getServletContext().getRealPath(
			"images")+"/usersphotos/";
	
	@Action(value = "photoSetAction")
	public String PhotoSetAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		pathString = pathString +id+".jpg";
		uploadify.renameTo(new File(pathString));
		PrintWriter out = response.getWriter();
		out.print("images/usersphotos/"+id+".jpg");
		out.flush();
		out.close();
		return null;
	}

	//头像截图
	@Action(value = "XImages")
	public String XImages() throws Exception {
		if (width==0 || height == 0) {
			return null;	
		}else {
			int artworkwidth = 0;
			int artworkHeight = 0;
			// 下面更新数据库数据
			String sql = "From Users where id = "+id;
			List<Users> users = basicServiceImp.query(sql);
			Users user = users.get(0);
			String sqlPath = user.getUserImageUrl();
			// 获取随机数
			Random r = new Random();
			int rannum = (int) (r.nextDouble() * (999999 - 100000 + 1)) + 100000;

			String savePath = ServletActionContext.getServletContext().getRealPath(
					"images");
			String newPath = savePath + "/usersphotos/" + rannum + ".jpg";
			pathString = pathString +id+".jpg";
			if(new File(pathString).isFile()){
				String ratio = ximages.getImageRatio(pathString);
				if (ratio.lastIndexOf("X") >= 0) {
					artworkwidth = Integer.parseInt(ratio.substring(0,
							ratio.indexOf("X")));
					artworkHeight = Integer.parseInt(ratio.substring(ratio
							.lastIndexOf("X") + 1));
				}
				width = width * artworkwidth / 450;
				height = height * artworkwidth / 450;
				x = x * artworkwidth / 450;
				y = y * artworkwidth / 450;
				OperateImage o = new OperateImage(x, y, width, height);
				o.setSrcpath(pathString);
				o.setSubpath(newPath);
				o.cut();
				user.setUserImageUrl("images/usersphotos/" + rannum + ".jpg");
				basicServiceImp.update(user);
				if(sqlPath.lastIndexOf("/")>0){
					String oldTitleName = sqlPath.substring(sqlPath.lastIndexOf("/"));
					sqlPath = savePath+"/usersphotos"+oldTitleName;
				}
				File file = new File(sqlPath);
				File fl = new File(pathString);
				if (fl.isFile()) {
					fl.delete();
				}
				if (file.isFile()) {
					file.delete();
				}
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print("ok");
				out.flush();
				out.close();
			}
			return null;
		}
	}
	// 处理取消修改头像的 action
		@Action(value = "cancleUploadeHeaderImage")
		public String CancelUploadeHeaderImage() throws Exception {
			pathString = pathString +id+".jpg";
			System.out.println("aaaa"+id);
			File file = new File(pathString);
			if(file.isFile()){
				file.delete();
			}
			return null;
		}
}
