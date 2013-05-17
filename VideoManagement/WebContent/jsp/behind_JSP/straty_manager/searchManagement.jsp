<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>搜索策略管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet"
	href="../../../css/base_css/bootstrap.css">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<style>
#div {
	width: 770px;
	height: auto;
	margin: auto;
}

#div1 {
	width: 720px;
	height: auto;
	margin-top: 10px;
	margin-left: 11px;
}

#div2 {
	width: 720px;
	height: auto;
	margin-top: 10px;
	margin-left: 11px;
}

#url {
	width: 720px;
	height: auto;
	margin-top: 10px;
	margin-left: 11px;
}

table td {
	width: 590px;
}

.input_url {
	width: 720px;
	height: 30px;
}

#url_content {
	float: left;
	height: 30px;
	width: 585px;
	margin-left: 20px;
	line-height: 30px;
}

#add {
	height: 30px;
	width: 107px;
	float: right;
	line-height: 30px;
	border: 1px solide #000000;
}

span {
	font-size: 14px;
	color: #818181;
}

input {
	margin-left: 17px;
	height: 30px;
}

.p1 {
	width: 88px;
	height: 20px;
	font-size: 14px;
	color: #ffffff;
	background-color: #ff9600;
}

.p2 {
	width: 130px;
	height: 20px;
	font-size: 14px;
	color: #ffffff;
	background-color: #ff9600;
}

button {
	background-color: #e5e5e5;
	width: 75px;
	height: 33px;
	margin-bottom: 10px;
}

input[type="text"] {
	border-radius: 0px;
}

.usedURL table {
	margin-left: 25px;
	border: 1px dotted #ccc;
}

.usedURL table tr td,.usedURL table tr th {
	height: 30px;
	border: 1px dotted #ccc;
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
</head>
<body>
	<div id="div">
		<!-- 评论过滤关键词设定 -->
	<!-- 	<div id="div2">
			<form action="getImageUrlAction" method="post">
				<p class="p2">图片关键词搜索</p>
				<input type="text" style="width: 585px;" name="categoryName" />
				<button type="submit">确定</button>
			</form>
		</div> -->
		<!--抓取url添加 -->
		<div id="url">
			<p class="p1">抓取视频添加</p>
			<table style="margin-left: 20px;" id="tab">
				<thead>
					<tr>
						<td>请输入链接：如：http://www.tudou.com/</td>
					</tr>
				</thead>
			</table>

			<div id="input_url" class="input_url">
				<form action="spriderUrl" id="info">
					<div id="url_content">
						<input type="text" name="url" id="input_url_content"
							style="margin-left: 0; width: 570px;" />
					</div>
					<div id="add">
						<button type="submit">抓取</button>
					</div>
				</form>
			</div>
			<!--抓取过的URL -->
			<div style="width: 680px;">
				<p class="p1">曾经抓取过的URL</p>
				<div class="usedURL">
					<table>
						<tr>
							<th>URL</th>
							<th>时间</th>
						</tr>
						<c:forEach items="${resources}" var="resources">
							<tr>
								<td>${resources[0]}</td>
								<td>${resources[1]}</td>
							</tr>

						</c:forEach>
						<!-- 	<tr>
							<td>http://www.tudou.com</td>
							<td>2012-2-12 12:42:12</td>
						</tr>
						<tr>
							<td>http://www.tudou.com</td>
							<td>2012-2-12 12:42:12</td>
						</tr> -->
					</table>
				</div>


				<div id="fenye1">
					<c:if test="${strutsPageBean1.getCurrentPage()>1}">
						<a
							href="searchManagement?currentPage=${strutsPageBean1.getPreviousPage()}"
							title="上一页">上一页</a>
					</c:if>
					<span>当前${strutsPageBean1.getCurrentPage()
						}页/共${strutsPageBean1.getTotlePages() }页</span>
					<c:if
						test="${strutsPageBean1.getCurrentPage()< strutsPageBean1.getTotlePages()}">
						<a
							href="searchManagement?currentPage=${strutsPageBean1.getNextPage()}"
							title="下一页">下一页</a>
					</c:if>
					<form action="searchManagement" method="post">
						跳转到<input type="text" name="currentPage">页 <input
							type="submit" value="go">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</body>
</html>
