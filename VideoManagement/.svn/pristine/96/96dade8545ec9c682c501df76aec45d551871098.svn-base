package com.videoManagement.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.Comment;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Resources;
import com.videoManagement.serviceDao.CommitManService;
import com.videoManagement.serviceDao.VideoPlayerServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.UsersIp;
import com.videoManagement.util.strutsPageBean;

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
public class CommentManAction extends ActionUtil {

	public String getCommentText() {
		return CommentText;
	}

	public void setCommentText(String commentText) {
		CommentText = commentText;
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
	//评论的内容
	private String CommentText;
	HttpServletRequest request = ActionUtil.getRequest();
	HttpServletResponse response = ActionUtil.getResponse();
	@Autowired
	public CommitManService commitManService;
	/*@Autowired
	public VideoPlayerServiceDao videoPlayerServiceDao;*/

	/**
	 * comment主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "comment", results = { @Result(name = "comment", location = "/jsp/behind_JSP/resource_manger/existResource/comment.jsp") })
	public String comment() throws Exception {
		String properName = "id";
		List list = commitManService.getAll(Comment.class, properName, true,
				offset, pageSize, null);
		int totalNum = commitManService.getTotalCount(Comment.class);
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
		// 传送comment实体对象
		request.setAttribute("comment", list);
		return "comment";
	}

	/**
	 * comment删除跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "delAllCom", results = {
			@Result(name = "success", location = "/jsp/behind_JSP/resource_manger/existResource/comment.jsp"),
			@Result(name = "error", location = "/jsp/behind_JSP/resource_manger/existResource/comment.jsp") })
	public String delAllCom() throws Exception {
		for (int i = 0; i < ids.length; i++) {
			System.out.println("删除的id"+ids[i]);
		}
		String hql = "delete from Comment comment where comment.id=?";
		int success = commitManService.deleteSelected(hql, ids);
		String properName = "id";
		int totalNum = commitManService.getTotalCount(Comment.class);
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
		List list = commitManService.getAll(Comment.class, properName, true,
				offset, pageSize, null);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		request.setAttribute("signalSize", list.size());
		// 传递总页数
		request.setAttribute("pageCount", pageCount);
		// 传送comment实体对象
		request.setAttribute("comment", list);
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
	 * getInfo主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "getInfo", results = { @Result(name = "getInfo", location = "/jsp/behind_JSP/resource_manger/existResource/commentInfo.jsp") })
	public String getInfo() throws Exception {
		Comment comment = commitManService.getinfo(id);
		// System.out.println(comment);
		// System.out.println("name::" + comment.getResources().getTitle());
		request.setAttribute("info", comment);
		// 传递从第几条显示
		request.setAttribute("offset", offset);
		// 传递当前页码
		request.setAttribute("pageNow", pageNow);
		// 传递一页有多少条
		int signalSize = Integer.parseInt(request.getParameter("signalSize"));
		request.setAttribute("signalSize", signalSize);
		return "getInfo";
	}

	/**
	 * getInfo主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "insertComment")
	public String insertComment() throws Exception {
		PrintWriter pw = response.getWriter();
	    Comment comment = new Comment();
	    String userIp = UsersIp.getUsersIp(request);
	    Resources  resources = commitManService.getResources(id);
	    comment.setUserIp(userIp); 
	    comment.setResources(resources);
	    comment.setCommentName("张居开");
	    comment.setCommentConent(CommentText);
	    comment.setCommentTime(new Timestamp(new Date().getTime()) );
	    int flag = commitManService.insertComment(comment);
	    if (flag != 0) {
			pw.print(flag);
			return  null;
		}else{
			pw.print("0");
			return  null;
		}
	}
	/**
	 * getInfo主页跳转 方法作用：传递所有评论的list对象
	 */
	@Action(value = "addLikeNum")
	public String addLikeNum() throws Exception {
		//System.out.println("我草你妈的Id"+id);
		PrintWriter pw = response.getWriter();
		int d;
		List<Resources>  resources = commitManService.query("from Resources r where r.id=?", id);
		Resources res = resources.get(0);
		System.out.println("资源的pageUrl"+res.getPageUrl());
		System.out.println("资源的liekNUm"+res.getLikeNum());
		if (res.getLikeNum() == null) {
			d = 1;
		}else{
			d= res.getLikeNum();
			d=d+1;
		}	
	    res.setLikeNum(d);
		commitManService.update(res);
		pw.print(d);
		return null;
	}
	
}
