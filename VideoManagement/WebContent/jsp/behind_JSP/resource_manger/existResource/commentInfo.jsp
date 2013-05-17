<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评论详情</title>
</head>
<body style="background-color: #fff;">
<div id="firstDiv">
	<table>
		<tr>
			<td>资源标题:</td>
			<td name="title" id="title">${info.resources.title }</td>
		</tr>
		<tr>
			<td>资源简介:</td>
			<td name="info" id="info">${info.resources.content }</td>
		</tr>
		<tr>
			<td>评&nbsp;论&nbsp;者:</td>
			<td name="observer" id="observer">${info.commentName }</td>
		</tr>
		<tr>
			<td>评&nbsp;论&nbsp;IP:</td>
			<td name="IP" id="IP">${info.userIp}</td>
		</tr>
		<tr>
			<td>评论内容:</td>
		</tr>
		<tr>
		    <td></td>
			<td ><textarea cols="40" rows="15" name="obContent" id="obContent">${info.commentConent}</textarea></td>
		</tr>		
	</table>
</div>	
<div align="right" id="secondDiv" style="margin-right: 60px">
<a href="comment?offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}"><input type="button" value="返回"></a> 
</div>
</body>
</html>