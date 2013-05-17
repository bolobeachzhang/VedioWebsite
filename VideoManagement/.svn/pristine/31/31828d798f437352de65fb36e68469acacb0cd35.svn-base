<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>基本资料</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="../../../js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<script type="text/javascript" src="../../../js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<link rel="shortcut icon" href="../../images/logo.png" />
<link rel="stylesheet" type="text/css" href="../../../css/base_css/bootstrap.css">
<style>
#div1{
		border-radius: 5px;
		border: 1px solid #999999;
		width: 610px;
		min-height: 500px;
}

#div1_1{
		background-color: #333333;
		color: #FFB100;
		font-size: 20px;
		padding-left: 20px;
		padding-top: 5px;
		height: 30px;
}

tr {
		height: 30px;
}

td:first-child {
		text-align: right;
}
</style>
</head>
<body>
<div id="div1">
<div id="div1_1">基本资料</div>
<div id="div1_2">
<form action="" method="post">
<table style="margin-top: 40px;">
		<tr>
				<td>昵称：</td>
				<td colspan="3"><input type="text" value="${user.getUserName()}"
						style="width: 200px; height: 20px; border-radius: 2px;"/></td>
		</tr>
		<tr>
				<td>性别：</td>
				<c:if test="${user.getSex()=='男' }">
					<td><input type="radio" name="sex" value="男" checked="checked"> 男</td>
					<td><input type="radio" name="sex" value="女"> 女</td>
				<td>&nbsp;</td>
				</c:if>
				<c:if test="${user.getSex()=='女' }">
					<td><input type="radio" name="sex" value="男" > 男</td>
					<td><input type="radio" name="sex" value="女" checked="checked"> 女</td>
				<td>&nbsp;</td>
				</c:if>
				
		</tr>
		<tr>
				<td>出生年月：</td>
				<td><input type="text" style="width: 30px;"> 年</td>
				<td><input type="text" style="width: 30px;"> 月</td>
				<td><input style="width: 30px;" type="text"> 日</td>
		</tr>
		<tr>
				<td>邮箱地址：</td>
				<td colspan="3"><input type="text" style="width: 200px;" value="${user.getEmail() }"></td>
				
		</tr>
		<tr>
				<td>学历：</td>
				<td colspan="3"><input type="text" style="width: 200px;"></td>
		</tr>
		<tr>
				<td>职业：</td>
				<td colspan="3"><input type="text" style="width: 200px;"></td>
		</tr>
		<tr>
				<td>行业：</td>
				<td colspan="3"><input type="text" style="width: 200px;"></td>
		</tr>
		<tr>
				<td></td>
				<td ><input type="submit" style="width: 70px; height: 30px;"
						value="保  存"></td>
		</tr>
</table>
</form>

</div>
</div>
</body>
</html>
