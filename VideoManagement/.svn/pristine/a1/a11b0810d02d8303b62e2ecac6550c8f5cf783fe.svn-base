<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var contentRight = $(".contentRight");
		var submit = $("#submit");
		var contentLeft = $(".contentLeft");
		var deleteNode = $(".delete");
		var headImage = $(".headImage");
		var messager = $(".messager");
		window.onload = function() {
			var height = contentRight.height();

			var height1 = headImage.height();

			var MessagecontentHeight = $(".Messagecontent").height();

			contentLeft.css("height", height);
			var height2 = contentLeft.height();
			var messheight = height2 - height1;

			messager.css({
				"height" : "messheight",
				"margin-top" : "height",
			});
			deleteNode.css("height", MessagecontentHeight);
		};
	});
</script>
<style type="text/css">
body {
	width: 719px;
	margin: 0 auto;
	padding: 0px;
	font-size: 12px;
}

.frame {
	width: 100%;
	padding: 0px;
	margin: 0px;
}

.messageOne {
	width: 98%;
	min-height: 150px;
	max-height: 300px;
	margin-top: 15px;
}

.contentLeft {
	width: 100px;
	min-height: 150px;
	max-height: 300px;
	float: left;
	border: 1px solid #DBDBDB;
	overflow: hidden;
}

.contentRight {
	border: 1px solid #DBDBDB;
	border-left: none;
	width: 600px;
	min-height: 150px;
	max-height: 300px;
	float: right;
}

.headImage {
	width: 100px;
	min-height: 100px;
	max-height: 250px;
}

.headImage img {
	width: 100px;
	min-height: 100px;
	max-height: 250px;
}

.messager {
	width: 100px;
	height: 50px;
	text-align: center;
	line-height: 50px;
	border-top: 1px solid #DBDBDB;
	vertical-align: middle;
	font-size: 15px;
}

.Messagecontent {
	width: 549px;
	float: left;
	min-height: 55px;
	max-height: 130px;
	text-indent: 2em;
	overflow: hidden;
}

.replay {
	width: 100%;
	min-height: 55px;
	max-height: 130px;
	text-indent: 2em;
	float: right;
	border-top: 2px solid #DBDBDB;
	overflow: hidden;
}

.delete {
	width: 45px;
	float: right;
	height: 100%;
	text-align: center;
	vertical-align: middle;
	border-left: 1px solid #DBDBDB
}

.delete a {
	vertical-align: middle;
	font-size: 16px;
	line-height: 48px;
}

.table {
	width: 100%;
	border: 1px solid #DBDBDB;
	border-left: none;
	text-align: center;
}

#fenye1 {
	width: 700px;
	text-align: center;
	font-size: 16px;
	margin-top: 20px;
	vertical-align: middle;
	float: left;
	padding-top: 10px;
}

#fenye1 form {
	float: right;
}
</style>
<title>留言页面</title>
</head>
<body>
	<div class="frame">
		<c:if test="${strutsPageBean1.getTotleRows()!=0}">
			<!------------------------- 分页开始-------------------->
			<c:forEach items="${messages}" var="messages">
				<div class="messageOne">
					<!--留言左边放置头像以及名字部分 -->
					<div class="contentLeft">
						<!--头像部分 -->
						<div class="headImage">
							<img
								src="http://www.baidu.com/img/shouye_b5486898c692066bd2cbaeda86d74448.gif">
						</div>
						<div class="messager">
							<c:out value="${messages.getMessager()}"></c:out>
						</div>
					</div>
					<div class="contentRight">
						<div class="Messagecontent">
							<c:out value="${messages.getMessageContent()}"></c:out>
						</div>
						<div class="delete">
							<a
								href="liuyanManagment?type=delete&messagesId=${messages.getMessageId()}&currentPage=${strutsPageBean1.getCurrentPage()}"
								title="删除">删除</a>
						</div>

						<!-- 下面是回复内容 -->
						<div class="replay">
							<span style="color: red">管理员回复的内容：</span>
							<c:out value="${messages.getReplayContent()}"></c:out>
						</div>
						<!-- 这里就是表单部分 -->
						<form
							action="liuyanManagment?type=add&currentPage=${strutsPageBean1.getCurrentPage()}&messagesId=${messages.getMessageId()}"
							method="POST">
							<table class="table">
								<tr>
									<td style="width: 8%; font-size: 16px;">回复:</td>
									<td style="width: 82%"><input style="width: 95%"
										type="text" name="content" /></td>
									<td style="width: 10%"><input style="width: 90%"
										id="submit" type="submit" value="确定" /></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</c:forEach>

			<!------------------------- 分页结束-------------------->

			<div id="fenye1">
				<c:if test="${strutsPageBean1.getCurrentPage()>1}">
					<a
						href="liuyanManagment?currentPage=${strutsPageBean1.getPreviousPage()}"
						title="上一页">上一页</a>
				</c:if>
				<span>当前${strutsPageBean1.getCurrentPage()
					}页/共${strutsPageBean1.getTotlePages() }页</span>
				<c:if
					test="${strutsPageBean1.getCurrentPage()< strutsPageBean1.getTotlePages()}">
					<a
						href="liuyanManagment?currentPage=${strutsPageBean1.getNextPage()}"
						title="下一页">下一页</a>
				</c:if>
				<form action="liuyanManagment" method="post">
					跳转到<input type="text" name="currentPage">页 <input
						type="submit" value="go">
				</form>
		</c:if>
		<c:if test="${strutsPageBean1.getTotleRows()==0}">
			<div>
				对不起，数据不存在。。。。
			</div>
		</c:if>
	</div>
	</div>
</body>
</html>