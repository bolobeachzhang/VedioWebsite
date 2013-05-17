package com.videoManagement.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.VideoPlayerServiceDao;
import com.videoManagement.util.ActionUtil;

/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 后台管理跳转 actoin
 * @Author 代兵
 * @Date 2013-3-27, 15:56 PM
 * @mailto 707189384@qq.com 视频播放后台加载
 */
public class VideoPlayerAction extends ActionUtil {

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	HttpServletRequest request = this.getRequest();
	HttpServletResponse respon = this.getResponse();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id; // 该资源的id
	private int pageSize = 10; // 一页显示多少条
	private int pageCount; // 页面总页数
	private int offset; // 其实查询的位置
	private int pageNow;
	@Autowired
	public VideoPlayerServiceDao videoPlayerServiceDao;

	@SuppressWarnings("static-access")
	@Action(value = "/getVedio", results = { @Result(name = "success", location = "/jsp/front_JSP/video_jsp/video_playPage.jsp") })
	public String getVedio() throws Exception {
		// 获取该资源的10条评论
		List<Comment> comments = videoPlayerServiceDao.getComment(
				"from Comment c where c.resources.id=?", offset, pageSize, id);
		// 当前的视频信息
		FlashVedio flashVedio1 = videoPlayerServiceDao.getFlash(id);
		// 获取播放次数 然后加一
		String clickNumNew = flashVedio1.getClickNums();
		//System.out.println("得到点击次数1"+clickNumNew);
		String clickNum2 = "";
		String[] str = clickNumNew.split(",");
		for (int i = 0; i < str.length; i++) {
			clickNum2 += str[i];
		}
		//System.out.println("得到点击次数2"+clickNum2);
		Integer ckickNum = Integer.parseInt(clickNum2) + 1;
		flashVedio1.setClickNums(ckickNum.toString());
		videoPlayerServiceDao.update(flashVedio1);
		FlashVedio flashVedio2 = videoPlayerServiceDao.getFlash(id + 1);
		FlashVedio flashVedio3 = videoPlayerServiceDao.getFlash(id + 2);
		FlashVedio flashVedio4 = videoPlayerServiceDao.getFlash(id + 3);

		// 获取分页的信息
		Object[] values = { id };
		// 得到总条数
		int totalMenment = videoPlayerServiceDao.getAllComment(
				"from Comment c where c.resources.id=?", values);
		if (totalMenment % pageSize == 0) {
			pageCount = totalMenment / pageSize;
		} else {
			pageCount = totalMenment / pageSize + 1;
		}

		String hql2 = "from Sort where sortType=? ";
		List flashTypes = videoPlayerServiceDao.query(hql2, 1);
		request.setAttribute("flashTypes", flashTypes);
		request.setAttribute("flashVideo1", flashVedio1);
		request.setAttribute("flashVideo2", flashVedio2);
		request.setAttribute("flashVideo3", flashVedio3);
		request.setAttribute("flashVideo4", flashVedio4);
		request.setAttribute("offset", offset);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("comments", comments);
		return "success";
	}

	/**
	 * ajax异步加载得的播放组件
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "getVedioPlayer")
	public String getVedioPlayer() throws Exception {
		FlashVedio flashVedio1 = videoPlayerServiceDao.getFlash(id);
		String picString = flashVedio1.getFlashImagePath();
		String url = flashVedio1.getUrl();
		PrintWriter pwPrintWriter = respon.getWriter();
		if (flashVedio1.getUrl().contains(".swf")) {
			pwPrintWriter.print(flashVedio1.getUrl());
		} else {
			pwPrintWriter.print("controlbar=over&image=" + picString
					+ "&file=../../../" + url + "");
		}
		return null;
	}

	@Action(value = "pageDo")
	public String pageDo() throws Exception {
		// 获取该资源评论
		List<Comment> comments = videoPlayerServiceDao.getComment(
				"from Comment c where c.resources.id=?", offset, pageSize, id);
		PrintWriter pw = respon.getWriter();
		// 获取分页的信息
		Object[] values = { id };
		// 得到总条数
		int totalMenment = videoPlayerServiceDao.getAllComment(
				"from Comment c where c.resources.id=?", values);
		if (totalMenment % pageSize == 0) {
			pageCount = totalMenment / pageSize;
		} else {
			pageCount = totalMenment / pageSize + 1;
		}
		String script = "";
		script = "<script type='text/javascript' charset='utf-8'>$(document).ready(function(){ var id = $('#id_href').val(); var offset=0; var pageNow=$('#pageNow').attr('name'); $('#firstpage').click(function(){$.ajax({url : 'pageDo',cache: true,type: 'POST',data : 'id=' +id+'&offset='+offset+'&pageNow='+pageNow,success : function(data) {$('.discusListFream').empty();$('.page').empty();$(data).appendTo('.discusListFream');}});});}); </script>";
		script += "<script type='text/javascript' charset='utf-8'>$(document).ready(function(){ var id = $('#id_href').val(); var pageCount = $('#firstpage').attr('name');  var offset=$('#lastOne').attr('name'); var pageNow=$('#pageNow').attr('name'); $('#lastOne').click(function(){ $.ajax({url : 'pageDo',cache: true,type: 'POST',data : 'id=' +id+'&offset='+(10*(pageCount-1))+'&pageNow='+pageNow,success : function(data) {$('.discusListFream').empty();$('.page').empty();$(data).appendTo('.discusListFream');}});});}); </script>";
		script += "<script type='text/javascript' charset='utf-8'>$(document).ready(function(){ var id = $('#id_href').val();	var offset=$('#lastOne').attr('name');offset=parseInt(offset);var pageNow=$('#pageNow').attr('name'); pageNow=parseInt(pageNow);$('#nextPage').click(function(){$.ajax({url : 'pageDo',cache: true,type: 'POST',data : 'id=' +id+'&offset='+(offset+10)+'&pageNow='+(pageNow+1),success : function(data) { $('.discusListFream').empty();$('.page').empty();$(data).appendTo('.discusListFream');}});});});</script>";
		script += "<script type='text/javascript' charset='utf-8'>$(document).ready(function(){ var id = $('#id_href').val();	var offset=$('#lastOne').attr('name');offset=parseInt(offset);var pageNow=$('#pageNow').attr('name'); pageNow=parseInt(pageNow);$('#Uppage').click(function(){$.ajax({url : 'pageDo',cache: true,type: 'POST',data : 'id=' +id+'&offset='+(offset-10)+'&pageNow='+(pageNow-1),success : function(data) { $('.discusListFream').empty();$('.page').empty();$(data).appendTo('.discusListFream');}});});});</script>";
		// 没有评论
		if (comments == null) {
			pw.print("<div class='discusListEveryF'>暂无数据！！</div>");
		} else {
			String divString = "";
			divString += script;
			for (Comment oneComemnt : comments) {
				divString += "<div class='discusListEveryF'><div class='discusListEveryImgF'><img alt='' src='images/usersphotos/usersPhotos_00001.png' /><div class='discusListEveryName'>"
						+ oneComemnt.getCommentName()
						+ "</div></div><div class='discusListEvContent'>"
						+ oneComemnt.getCommentConent() + "</div></div>";
			}
			divString += "<div class='page' align='center' style='margin-top: 20px;'><input type='button' name='"
					+ pageCount
					+ "' value='首页' id='firstpage'><input type='button' name='"
					+ offset
					+ "' value='尾页' id='lastOne'  ><input type='button'  name='"
					+ pageNow + "' style='display: none;' id='pageNow'>";
			if (pageNow < pageCount) {
				divString += "<input type='button' name='nextPage' value='下一页' id='nextPage'>";
			}
			if (pageNow > 1 && pageNow <= pageCount) {
				divString += "<input type='button' name='Uppage' value='上一页' id='Uppage'>";
			}
			divString += "</div>";
			pw.print(divString);
		}
		return null;

	}
}
