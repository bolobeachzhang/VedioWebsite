<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>最新资源管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<script type="text/javascript" src="js/behind/bootstrap-tab.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		/* 获取页面ID */
		$pageID = $("#children-newResourceMain");
		/*下面定义不同的子页面链接searchManagement**/ 
		$menuURITwo21 = "AdminUploadResource";
		$menuURITwo22 = "UserUploadResource"; 
		$menuURITwo34 = "manageUserUploadeImages";
		$menuURITwo35 = "manageUserUploadeFlash";
		$menuURITwo36 = "addFlashmsg";
	
		
		$(".naver a").each(function(index){
			
			$(this).click(function(){
				/*if(index == 0){
					$pageID.attr("src",$menuURITwo21);
				}if(index == 1){
					$pageID.attr("src",$menuURITwo22);
				}if(index == 2){
					$pageID.attr("src",$menuURITwo36);
				}if(index == 3){
					$pageID.attr("src",$menuURITwo34);// 图片 
				}if(index == 4){
					$pageID.attr("src",$menuURITwo35);//视频 
				}*/
				if(index == 0){
					$pageID.attr("src",$menuURITwo21);
				}if(index == 1){
					$pageID.attr("src",$menuURITwo34);
				}if(index == 2){
					$pageID.attr("src",$menuURITwo35);
				}
			});
			});
		});
</script>
<style type="text/css">
body{
	background: white;
}
.naver{
	height: 35px;
	background-color: #f3f3f3;
}

#page-newResourceMain{
	width: 751px;
	min-height:1000px; 
		margin: 0px;
	padding: 0px;
}
.ifreamClass{
	width: 750px;
	min-height: 1000px; 
		margin: 0px;
	padding: 0px;
}
</style>
</head>
<body>
	<div class="naver">
		<ul class="nav nav-tabs">
		<li style="line-height: 35px;color: #0088cc;font-size: 14px;">上传资源管理>></li>
		  <li class="active"><a href="#" data-toggle="tab">管理员上传媒体资源</a></li>
		  <!-- 
		  <li><a href="#" data-toggle="tab">编辑信息</a></li>
		  <li><a href="#" data-toggle="tab">编辑视频</a></li>
		   -->
		  <li><a href="#" data-toggle="tab">用户上传的图片</a></li>
		  <li><a href="#" data-toggle="tab">用户上传的视频</a></li>
		</ul>
	</div>
	<div id="page-newResourceMain" class="span9">
			<iframe class="ifreamClass" style="border: none;scrolling:no;" id="children-newResourceMain" src="AdminUploadResource"></iframe>	
	</div>
</body>
</html>