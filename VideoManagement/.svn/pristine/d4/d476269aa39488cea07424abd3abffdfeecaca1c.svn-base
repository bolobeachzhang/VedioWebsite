package com.videoManagement.action;

import java.util.List;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.pool.ObjectPool;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoManagement.bean.SubmitMessage;
import com.videoManagement.serviceDao.LiuYanManServiceDao;
import com.videoManagement.util.ActionUtil;
import com.videoManagement.util.strutsPageBean;

/**
 * @ClassName:LiuYanManAction
 * @Description: TODO(留言管理的anction)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-29 下午9:52:19
 * @version V1.0
 * @Copyright: Copyright (c) 2013
 * @Company: 成都大学信息科学与技术学院重点工作室
 */
@Controller
@Result(name = "error", location = "/WEB-INF/error.jsp")
@ExceptionMapping(exception = "java.lange.RuntimeException", result = "/WEB-INF/error.jsp")
public class LiuYanManAction extends ActionUtil {
	@Autowired
	private LiuYanManServiceDao liuYanManServiceDao;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * liuyanManagment主页跳转
	 * 
	 */
	@Action(value = "liuyanManagment", results = { @Result(name = "liuyanManagment", location = "/jsp/behind_JSP/liuyan_manager/liuyanManagment1.jsp") })
	public String liuyanManagment() throws Exception {
		HttpServletRequest request = this.getRequest();
		int pageSize = 5;
		// 得到当前页
		String pageNow = request.getParameter("currentPage");
		//回复内容
		String repaly = request.getParameter("content");
		// 得到是删除还是回复
		String type = request.getParameter("type");
		String messageId = request.getParameter("messagesId");
		if ("delete".equals(type) && messageId!=null) {
			String hql = "delete from SubmitMessage where messageId = ?";
			Object[] object = new Object[]{Integer.valueOf(messageId)};
			liuYanManServiceDao.deleteByHql(hql, object);
		}
		//说明要添加什么。
		if (repaly!=null && "add".equals(type) && messageId!=null) {
			String hql = "update from SubmitMessage set replayContent = ? where messageId=?";
			Object[] objects = new Object[]{repaly,Integer.valueOf(messageId)};
			liuYanManServiceDao.update(hql, objects);
		}
		int currentPage = 1;
		int offset = 0;
		if (pageNow != null) {
			currentPage = Integer.valueOf(pageNow);
			if (currentPage == 1) {
				offset = 0;
			} else {
				offset = (currentPage - 1) * pageSize;
			}
		}
		System.out.println(offset + "offset");

		String hql = "from SubmitMessage where messageType=?";
		Object[] params = new Object[] { String.valueOf(1) };
		// 得到总记录数
		int totleRows = liuYanManServiceDao.affectNumber(hql, params);
		strutsPageBean strutsPageBean = new strutsPageBean();
		strutsPageBean strutsPageBean1 = strutsPageBean.getstrutsPageBean(
				pageSize, currentPage, totleRows);
		System.out.println(strutsPageBean1.getCurrentPage() + "当前页。。。。。。。");
		@SuppressWarnings("unchecked")
		List<SubmitMessage> messages = liuYanManServiceDao.findByPage2(hql,
				offset, pageSize, params);
		System.out.println("offset的值。。。。" + offset);
		for (SubmitMessage submitMessage : messages) {
			System.out.println(submitMessage.getMessageContent());
		}
		request.setAttribute("messages", messages);
		request.setAttribute("strutsPageBean1", strutsPageBean1);
		return "liuyanManagment";
	}
}
