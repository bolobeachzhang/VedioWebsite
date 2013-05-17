<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户上传资源审核</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body{background-color: #fff;}
/*最外层div*/
#div {
	width: 730px;
	height: auto;
	background-color: #ffffff;
	margin: auto;
}

.div1 {
	width: 146pX;
	height: 198px;
	margin-left: 24px;
	float: left;
}

.div1_1 {
	width: 146px;
	height: 120px;
	background-color: #aaaaaa;
}

.div1_2 {
	width: 146px;
	height: 35px;
	background-color: #bbb;
	margin-top: 3px;
}

img {
	margin-left: 12px;
}

p {
	margin-left: 24px;
}
.checkBox {
	float: left;
	margin: -6px 0 0 -15px;
}

#fenye1 {
	width:700px;
	text-align: center;
	font-size: 14px;
	margin-top:20px;
	vertical-align: middle;
	float: left;
	padding-top:10px;
}
#fenye1 form{
	float: right;
}

.imgshow{
	width: 146px;
	height: 120px;
	margin-left: 0px;
	margin-top: -15px;
}
</style>

</head>
<body>
<c:if test="${empty UserUploadeFlashs}" >
	<div align="center" style="font-size: 14px;color: #0088CC;margin-top: 50px;">>>>>>>>暂无数据>>>>>></div>
</c:if>
<c:if test="${!empty UserUploadeFlashs}" >
  <div id="div">
    
    <p ><select style="border-radius: 0px;">
        <option>选择分类</option>
        <option>选择分类</option>
        <option>选择分类</option>
        <option>选择分类</option>
        <option>选择分类</option>
    </select>
    <button  class="btn" style="float: right;margin-right: 20px;">全选</button>
    </p>
    	<c:forEach items="${images}" var="images">
			<div class="div1">
				<div class="checkBox">
					<input type="checkbox" />
				</div>
				<div class="div1_1">
					<a href="${images.getUrl() }" target="_blank"><img
						src="${images.getUrl()}" class="imgshow"></a>
				</div>
				<div class="div1_2">
					<a href="#"><img src="images/behind_img/Edit.png"></a> 
					<a href="#"><img src="images/behind_img/Document-Check.png"></a>
					<a href="#"><img src="images/behind_img/Garbage.png"></a>
				</div>
			</div>
		</c:forEach>

</div>
	<div style="padding-left:100px;width:600px;float:left;">
        <button type="button" style="margin-left: 30px;background-color:#ff9600; width: 107px;height: 41px; color: #ffffff;">发布</button>
        <button type="button" style="margin-left: 50px;background-color:#ff9600; width: 107px;height: 41px;color: #ffffff;">删除</button>
        <button type="button" style="margin-left: 50px;background-color:#ff9600; width: 107px;height: 41px;color: #ffffff;">取消</button>
    </div>
    	<div id="fenye1">
		<c:if test="${strutsPageBean2.getCurrentPage()>1}">
			<a href="UserUploadResource?currentPage=${strutsPageBean2.getPreviousPage()}" title="上一页">上一页</a>
		</c:if>
		<span>当前${strutsPageBean2.getCurrentPage() }页/共${strutsPageBean2.getTotlePages() }页</span>
		<c:if test="${strutsPageBean2.getCurrentPage()< strutsPageBean2.getTotlePages()}">
			<a href="UserUploadResource?currentPage=${strutsPageBean2.getNextPage()}" title="下一页">下一页</a>
		</c:if>
		<form action="UserUploadResource" method="post">
			跳转到<input type="text" name="currentPage">页 <input
				type="submit" value="go">
		</form>
	</div>
	</c:if>
  </body>
</html>
