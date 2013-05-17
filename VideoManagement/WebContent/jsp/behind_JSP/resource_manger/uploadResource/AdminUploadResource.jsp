<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文件上传</title>
<script type="text/javascript" src="js/behind/jQuery.js"></script>
<link href="js/jquery.uploadify/uploadify.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/jquery.uploadify/swfobject.js"></script>
<script type="text/javascript"
	src="js/jquery.uploadify/jquery.uploadify.js"></script>

<!--ready事件-->
<script type="text/javascript">
	var resType = null;
	$(document).ready(function() {
		fileDesc =  "支持格式:jpg/gif/jpeg/png/bmp.";
		fileTypeExts = "*.jpg;*.gif;*.jpeg;*.png;*.bmp;";
				$.uploade();
			});
	 jQuery.extend({
		uploade:function() {
						$("#uploadify")
								.uploadify(
										{
											//开启调试
											'debug' : false,
											//是否自动上传
											'auto' : false,
											//支持多文件上传
											'multi' : true,
											//超时时间
											'successTimeout' : 99999,
											//flash
											'swf' : "js/jquery.uploadify/uploadify.swf",
											//不执行默认的onSelect事件
											'overrideEvents' : [ 'onDialogClose' ],
											//文件选择后的容器ID
											'queueID' : 'fileQueue',
											//服务器端脚本使用的文件对象的名称 $_FILES个['upload']
											'fileObjName' : 'uploadify',
											//上传处理程序
											'uploader' : 'uploadifyAction.action',
											//浏览按钮的背景图片路径
											'buttonImage' : 'js/jquery.uploadify/browse-btn2.png',
											//浏览按钮的宽度
											'width' : '100',
											//浏览按钮的高度
											'height' : '32',
											'rollover' : true,
											'removeCompleted' : true,
											'removeTimeout' : 1,
											//expressInstall.swf文件的路径。
											//'expressInstall':'expressInstall.swf',
											//在浏览窗口底部的文件类型下拉菜单中显示的文本
											'fileDesc' : fileDesc, //如果配置了以下的'fileExt'属性，那么这个属性是必须的 
											'simUploadLimit' : 5,//每次最大上传文件数   
											'displayData' : 'percentage',//有speed和percentage两种，一个显示速度，一个显示完成百分比 
											//允许上传的文件后缀
											'fileTypeExts' : fileTypeExts,
											//上传文件的大小限制
											'fileSizeLimit' : '100000MB',
											'buttonText' : '选择文件',//浏览按钮
											//上传数量
											/* 'queueSizeLimit' : 25, */
											//每次更新上载的文件的进展
											'onUploadProgress' : function(file,
													bytesUploaded, bytesTotal,
													totalBytesUploaded,
													totalBytesTotal) {
												//有时候上传进度什么想自己个性化控制，可以利用这个方法
												//使用方法见官方说明
											},
											//选择上传文件后调用
											'onSelect' : function(file) {
											},
											//返回一个错误，选择文件的时候触发
											'onSelectError' : function(file,
													errorCode, errorMsg) {
												switch (errorCode) {
												case -100:
													alert("上传的文件数量已经超出系统限制的"
															+ $('#uploadify')
																	.uploadify(
																			'settings',
																			'queueSizeLimit')
															+ "个文件！");
													break;
												case -110:
													alert("文件 ["
															+ file.name
															+ "] 大小超出系统限制的"
															+ $('#uploadify')
																	.uploadify(
																			'settings',
																			'fileSizeLimit')
															+ "大小！");
													break;
												case -120:
													alert("文件 [" + file.name
															+ "] 大小异常！");
													break;
												case -130:
													alert("文件 [" + file.name
															+ "] 类型不正确！");
													break;
												}
											},
											//检测FLASH失败调用
											'onFallback' : function() {
												alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
											},
											//上传到服务器，服务器返回相应信息到data里
											'onUploadSuccess' : function(file,
													data, response) {
												/* $('#uploadify').uploadify(
														'upload'); */
											},

											//把文件名传给后台
											'onUploadStart' : function(file) {
												getFileType();
												$("#uploadify")
														.uploadify(
																"settings",
																'formData',
																{
																	'fileInputFileName' : file.name,
																	'fileType' : resType
																});
											},
											'onQueueComplete' : function(stats) {
												var res = document
														.getElementById("resType");
												var resType = res.options[res.selectedIndex].value;
												if (resType == "图片") {
													if (window
															.confirm("图片上传成功，是否继续上传？")) {
														window.location.href = "AdminUploadResource.action";
													} else {
														window.location.href = "UserUploadResource.action";
													}
												} else {
													if (window
															.confirm("视频上传成功，是否继续上传？")) {
														window.location.href = "AdminUploadResource.action";
													} else {
														window.location.href = "addFlashmsg.action";
													}
												}
											}

										});
		}
	});

	function getFileType() {
		var res1 = document.getElementById("type1");
		var res2 = document.getElementById("type2");
		var resType1 = res1.options[res1.selectedIndex].value;
		var resType2 = res2.options[res2.selectedIndex].value;
		if (resType1 == "请选择类型") {
			resType = resType2;
		} else {
			resType = resType1;
		}
	}
</script>
<script type="text/javascript">
	function typeChange() {
		var res = document.getElementById("resType");
		var resType = res.options[res.selectedIndex].value;
		if (resType == "图片") {
			fileDesc =  "支持格式:jpg/gif/jpeg/png/bmp.";
			fileTypeExts = "*.jpg;*.gif;*.jpeg;*.png;*.bmp;";
			$.uploade();
			document.getElementById("image").style.display = "";
			document.getElementById("car").style.display = "none";
			document.getElementById("flash").style.display = "none";
		} else {
			fileDesc = "支持格式:ASF/nAVI/AVI/MPEG/MPG/WMV/flv/MP4/3GP/MOV/ASX/RMVB.";
			fileTypeExts="*.ASF;*.nAVI;*.AVI;*.MPEG;*.MPG;*.WMV;*.flv;*.MP4;*.3GP;*.MOV;*.ASX;*.RMVB";
			$.uploade();
			document.getElementById("image").style.display = "none";
			document.getElementById("flash").style.display = "";
			document.getElementById("car").style.display = "";
		}
	}
</script>

<style>
body{background-color: #fff;}
.uploadify-button {
	background-color: transparent;
	border: none;
	padding: 0;
	
}

.uploadify:hover .uploadify-button {
	background-color: transparent;
}

body {
	font: 12px/16px Arial, Helvetica, sans-serif;
}

#fileQueue {
	height: 400px;
	overflow: auto;
	border: 1px solid #0088CC;
}

.div1 {
	margin-left: 0px;
	color: #0088CC;
	font-size: 14px;
	float: left;
	margin-left: -50px;
}

.div2 {
	margin-top: 15px;
}
#uploadeImg{
	cursor: hand;
}
.uploadeImgOp{
	opacity:0.6;
}
</style>
<script type="text/javascript">
//改变开始上传和取消样式
$(function(){
	
	$("#uploadeImg").hover(function(){
		$(this).addClass("uploadeImgOp");
	},function(){
		$(this).removeClass("uploadeImgOp");
	});
	$("#littleImage").hover(function(){
		$(this).addClass("uploadeImgOp");
	},function(){
		$(this).removeClass("uploadeImgOp");
	});
});
</script>
</head>
<body>
	<div class="allFream"
		style="width: 700px; margin-left: 80px; margin-top: 10px;">
		<div id="div" class="div1">
		
			<div id="d2" class="div2" >
				资源类型： <select style="border-radius: 0px;" id="resType"
					onchange="typeChange()">
					<option value="图片">图片</option>
					<option value="视频">视频</option>
				</select>
			</div>
			<div id="image" class="div2">
				图片分类： <select style="border-radius: 0px;" id="type1">
					<option>请选择类型</option>
					<c:forEach items="${imagesSorts}" var="imagesSorts">
						<option value="${imagesSorts.getSortName()}">${imagesSorts.getSortName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="div2" id="flash" style="display: none">
				视频分类：<select style="border-radius: 0px;" id="type2">
					<option>请选择类型</option>
					<c:forEach items="${flashSorts}" var="flashSorts">
						<option value="${flashSorts.getSortName()}">${flashSorts.getSortName()}</option>
					</c:forEach>
				</select>
			</div>
			<div
				style="width: 100%; color: #0088CC; font-size: 18px; display: none;"
				id="car">部分视频格式请转换后上传</div>
		</div>
		<div style="float: left; margin-left: 20px">
			<div style="width: 100%">
				<div style="float: left; margin-top: 15px;">
					<input type="file" name="uploadify" id="uploadify" />
				</div>
				<p style="float: left; margin-left: 30px; font-size: 18px;">
				<a href="javascript:$('#uploadify').uploadify('upload','*')" style="text-decoration: none;">
					<img id="uploadeImg" alt="" src="js/jquery.uploadify/uploade.png"/>
				</a>
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:$('#uploadify').uploadify('cancel','*')" >
					<img alt="" src="js/jquery.uploadify/cancel.png" id="littleImage"/>
				</a>
				</p>
			</div>
			<div id="fileQueue" style="width: 372px;"></div>
		</div>
	</div>
</body>
</html>
