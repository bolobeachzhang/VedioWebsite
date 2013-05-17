package com.videoManagement.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.Comment;
import com.videoManagement.bean.Users;
import com.videoManagement.serviceDao.UserServiceDao;
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
public class UserManagerAction extends ActionUtil {
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageNow() {
		return pageNow;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	// 获取Ids
	private int[] ids;
	// 获取单个id并删除
	private int id;
	// 每页的显示条数
	private int pageSize = 10;
	// 第几条显示
	private int offset;
	// 当前页面的页数
	private int pageNow;
	private int type;
	HttpServletRequest request = ActionUtil.getRequest();
	HttpServletResponse response = ActionUtil.getResponse();
	@Autowired
	public UserServiceDao userServiceDao;

	/**
	 * 用户VIP主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "/user_vip", results = { @Result(name = "user_vip", location = "/jsp/behind_JSP/users_manager/VIP.jsp") })
	public String user_vip() throws Exception {
		String hql = "from Users u where u.userType=? ";
		Object[] params = { type };
		List list = userServiceDao.getAll(hql, offset, pageSize, params);
		//System.out.println("删除前:::::::*****"+list.size());
		int totalNum = userServiceDao.getTotalCount(hql, params);
		// System.out.println("toalNum"+totalNum);
		int pageCount;
		if (totalNum % pageSize == 0) {
			pageCount = totalNum / pageSize;
		} else {
			pageCount = (totalNum / pageSize) + 1;
		}
		// System.out.println("**************"+pageNow);
		// System.out.println("**************"+offset);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		request.setAttribute("signalSize", list.size());
		// 传递总页数
		request.setAttribute("pageCount", pageCount);
		// 传递type
		request.setAttribute("type", type);
		// 传送comment实体对象
		request.setAttribute("user", list);
		return "user_vip";
	}

	/**
	 * user删除跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "delVip", results = {
			@Result(name = "success", location = "/jsp/behind_JSP/users_manager/VIP.jsp"),
			@Result(name = "error", location = "/jsp/behind_JSP/users_manager/VIP.jsp") })
	public String delVip() throws Exception {
		String hql1 = "delete from Users user where user.id=?";
		int success = userServiceDao.deleteSelected(hql1, ids);
		String hql2 = "from Users u where u.userType=? ";
		Object[] params = { type };
		int totalNum = userServiceDao.getTotalCount(hql2, params);
		int pageCount;
		if (totalNum % pageSize == 0) {
			pageCount = totalNum / pageSize;
		} else {
			pageCount = (totalNum / pageSize) + 1;
		}
		int signalSize = Integer.parseInt(request.getParameter("signalSize"));
		// 如果删除的个数大于或者等于signalSize 将pageNow-1
		if (success >= signalSize) {
			if (pageNow==1) {
				pageNow =1;
				offset += 10;
			}else{
				pageNow--;
				offset -= 10;
			}
		}
		System.out.println("总页数：："+pageCount);
		List<Users> list = userServiceDao.getAll(hql2, offset, pageSize, params);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		request.setAttribute("signalSize", list.size());
		// 传递总页数
		request.setAttribute("pageCount", pageCount);
		// 传递type
		request.setAttribute("type", type);
		// 传送comment实体对象
		request.setAttribute("user", list);
		// signalSize是指单也所显示的条数
		if (success == ids.length) {
			request.setAttribute("result", "successs");
			return "success";
		} else {
			request.setAttribute("result", "error");
			return "error";
		}

	}
	
	/**
	 * getInfo主页跳转 方法作用：传递所有users的list对象
	 */
	@Action(value = "getInfoUser", results = { @Result(name = "getInfoUser", location = "/jsp/behind_JSP/users_manager/userInfo.jsp") })
	public String getInfoUser() throws Exception {
		Users users = userServiceDao.getinfo(id);
		// System.out.println(comment);
		// System.out.println("name::" + comment.getResources().getTitle());
		request.setAttribute("info", users);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		int signalSize = Integer.parseInt(request.getParameter("signalSize"));
		request.setAttribute("signalSize",signalSize);
		request.setAttribute("type", type);
		return "getInfoUser";
	}
	
	/**
	 * 用户VIP主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "ModifyAuthority")
	public String ModifyAuthority() throws Exception {
		//System.out.println("id*******"+id);
		//System.out.println("type*******"+type);
		Object[] params={type,id};
		//修改用户权限
		String hql ="update Users u set u.userType=? where u.id=?";	
		PrintWriter pwWriter = response.getWriter();
        userServiceDao.modifyAuthority(hql, params);
        pwWriter.print(1);
		return null;
	}
	

	/**
	 * 用户VIP主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "register", results = { @Result(name = "register", location = "/jsp/behind_JSP/users_manager/Register.jsp") })
	public String register() throws Exception {
		String hql = "from Users u where u.userType=? ";
		Object[] params = { type };
		List list = userServiceDao.getAll(hql, offset, pageSize, params);
		//System.out.println("删除前:::::::*****"+list.size());
		int totalNum = userServiceDao.getTotalCount(hql, params);
		// System.out.println("toalNum"+totalNum);
		int pageCount;
		if (totalNum % pageSize == 0) {
			pageCount = totalNum / pageSize;
		} else {
			pageCount = (totalNum / pageSize) + 1;
		}
		// System.out.println("**************"+pageNow);
		// System.out.println("**************"+offset);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		request.setAttribute("signalSize", list.size());
		// 传递总页数
		request.setAttribute("pageCount", pageCount);
		// 传递type
		request.setAttribute("type", type);
		// 传送comment实体对象
		request.setAttribute("register", list);
		return "register";
	}
	
	
	/**
	 * user删除跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "delReg", results = {
			@Result(name = "success", location = "/jsp/behind_JSP/users_manager/Register.jsp"),
			@Result(name = "error", location = "/jsp/behind_JSP/users_manager/Register.jsp") })
	public String delReg() throws Exception {
		String hql1 = "delete from Users user where user.id=?";
		int success = userServiceDao.deleteSelected(hql1, ids);
		String hql2 = "from Users u where u.userType=? ";
		Object[] params = { type };
		int totalNum = userServiceDao.getTotalCount(hql2, params);
		int pageCount;
		if (totalNum % pageSize == 0) {
			pageCount = totalNum / pageSize;
		} else {
			pageCount = (totalNum / pageSize) + 1;
		}
		int signalSize = Integer.parseInt(request.getParameter("signalSize"));
		// 如果删除的个数大于或者等于signalSize 将pageNow-1
		if (success >= signalSize) {
			pageNow=pageNow-1;
			offset -= 10;
		}
		//System.out.println("总页数：："+pageCount);
		List<Users> list = userServiceDao.getAll(hql2, offset, pageSize, params);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		request.setAttribute("signalSize", list.size());
		// 传递总页数
		request.setAttribute("pageCount", pageCount);
		// 传递type
		request.setAttribute("type", type);
		// 传送comment实体对象
		request.setAttribute("register", list);
		// signalSize是指单也所显示的条数
		if (success == ids.length) {
			request.setAttribute("result", "successs");
			return "success";
		} else {
			request.setAttribute("result", "error");
			return "error";
		}

	}
	
}
