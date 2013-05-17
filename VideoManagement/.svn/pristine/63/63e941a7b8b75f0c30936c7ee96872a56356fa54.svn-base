<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>留言管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/behind_css/liuyan.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="UTF-8"></script>
<style type="text/css">
#fenye1 {
	width: 700px;
	text-align: center;
	font-size: 16px;
	margin-top: 20px;
	vertical-align: middle;
	float: left;
	padding-top: 10px;
}

/* #fenye1 form {
	float: right;
}
 */
</style>

<script type="text/javascript">
function deleteA(){
	return window.confirm("确认要删除选择信息吗？？");
}
</script>
</head>
<body>
	<div class="div">
		<!-- ---------------------------start 留言 -------------------->
		<c:forEach items="${messages}" var="messages">
			<div class="div1">
				<div class="div1_1">
					<div class="div1_1_1">
						<div class="liuContent">这个放置头像</div>
						<label class="label">
							<c:out value="${messages.getMessager()}"></c:out>
						</label>
					</div>
				</div>
				<div class="div1_2">
					<div class="div1_2_1">
						<div class="div_text">
							<c:out value="${messages.getMessageContent()}"></c:out>
						</div>
						<label class="lable">
						<a onclick="return deleteA()" href="deleteMessage?type=delete&messagesId=${messages.getMessageId()}&currentPage=${strutsPageBean1.getCurrentPage()}">删除</a></label>
					</div>
					<div class="div1_2_2">
						<span> 回复：</span> <input type="text">
						<button type="button">确定</button>
					</div>
				</div>
			</div>
		</c:forEach>
		
		 <div id="fenye1">
	 	 <c:if test="${strutsPageBean1.getCurrentPage()>1}">
			<a href="liuyanManagment?currentPage=${strutsPageBean1.getPreviousPage()}" 
			title="上一页">上一页</a>
		</c:if> 
		<span>当前${strutsPageBean1.getCurrentPage()}页/共${strutsPageBean1.getTotlePages() }页</span>
		<c:if test="${strutsPageBean1.getCurrentPage()< strutsPageBean1.getTotlePages()}">
			<a href="liuyanManagment?currentPage=${strutsPageBean1.getNextPage()}" title="下一页">下一页</a>
		</c:if>
		<form action="liuyanManagment" method="post">
			跳转到<input type="text" name="currentPage">页 <input
				type="submit" value="go">
		</form>
	</div> 
		<!-- -----------------------end 留言------------------------>

		<!-- <div class="div1" style="margin-top: 11px;">
			<div class="div1_1">
				<div class="div1_1_1">
					<label class="label">用户名</label>
				</div>
			</div>
			<div class="div1_2">
				<div class="div1_2_1">
					<div class="div_text">fgrgrrrrrryr</div>
					<label class="lable"><a href="#">删除</a></label>
				</div>
				<div class="div1_2_2">
					<span> 回复：</span> <input type="text">
					<button type="button">确定</button>
				</div>
			</div>
		</div> -->
		<!-- <div class="div1" style="margin-top: 11px;">
			<div class="div1_1">
				<div class="div1_1_1">
					<label class="label">用户名</label>
				</div>
			</div>
			<div class="div1_2">
				<div class="div1_2_1">
					<div class="div_text">fgrgrrrrrryr</div>
					<label class="lable"><a href="#">删除</a></label>
				</div>
				<div class="div1_2_2">
					<span> 回复：</span> <input type="text">
					<button type="button">确定</button>
				</div>
			</div>
		</div>
		<div class="div1" style="margin-top: 11px;">
			<div class="div1_1">
				<div class="div1_1_1">
					<label class="label">用户名</label>
				</div>
			</div>
			<div class="div1_2">
				<div class="div1_2_1">
					<div class="div_text">fgrgrrrrrryr</div>
					<label class="lable"><a href="#">删除</a></label>
				</div>
				<div class="div1_2_2">
					<span> 回复：</span> <input type="text">
					<button type="button">确定</button>
				</div>
			</div>
		</div> -->
	</div>
</body>
</html>
