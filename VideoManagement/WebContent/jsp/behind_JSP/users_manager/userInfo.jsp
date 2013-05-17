<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评论详情</title>
</head>
<body>
	<div id="firstDiv">
		<table>
			<tr>
				<td>用户名:</td>
				<td name="title" id="title">${info.userName }</td>
			</tr>
			<tr>
				<td>头像:</td>
				<td name="info" id="info">${info.email }</td>
			</tr>
			<tr>
				<td>注册时间：</td>
				<td name="observer" id="observer">${info.registTime }</td>
			</tr>
		</table>
	</div>
	<div align="right" id="secondDiv" style="margin-right: 60px">
		<a
			href="user_vip?offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}&type=${type}"><input
			type="button" value="返回"></a>
	</div>
</body>
</html>