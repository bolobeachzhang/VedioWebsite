<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>头像设置</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"></script>
<link rel="shortcut icon" href="images/logo.png" />
<script type="text/javascript" src="js/behind/jQuery.js"></script>
<link href="js/jquery.uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.uploadify/swfobject.js"></script>
<script type="text/javascript" src="js/jquery.uploadify/jquery.uploadify.js"></script>
<link rel="stylesheet" href="css/front_css/lanrenzhijia.css" type="text/css" />
<script type="text/javascript" src="js/jquery.uploadify/jquery.Jcrop.js"></script>
<!--ready事件-->
<script type="text/javascript">
var resType = null;
var rx = null;
var ry = null;
var width = null;
var height = null;
var x = null;
var y = null;
var a = null;
var id = null;
	$(document)
			.ready(
					function() {
						$("#uploadify")
								.uploadify(
										{
											//开启调试
											'debug' : false,
											//是否自动上传
											'auto' : true,
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
											'uploader' : 'photoSetAction.action',
											//浏览按钮的背景图片路径
											// 'buttonImage':'${pageContext.request.contextPath}/js/jquery.uploadify/uploadify-cancel.png',
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
											'fileDesc' : '支持格式:jpg.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的 
											'simUploadLimit' : 5,//每次最大上传文件数   
											'displayData' : 'percentage',//有speed和percentage两种，一个显示速度，一个显示完成百分比 
											//允许上传的文件后缀
											'fileTypeExts' : '*.jpg',
											//上传文件的大小限制
											'fileSizeLimit' : '100000MB',
											'buttonText' : '选择图片',//浏览按钮
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
												id = document.getElementById("id").value;
												$("#uploadify")
												.uploadify(
														"settings",
														'formData',
														{
															'fileInputFileName' : file.name,
															'id' : id
															
														});
											},
											'onUploadSuccess' : function(file,data,response){
													
												$("#crop_preview").attr("src",data);
												$("#bPic").attr("src",data);
												$("#btdiv").css("display","block");
												$("#oldImage").css("display","none");
												//记得放在jQuery(window).load(...)内调用，否则Jcrop无法正确初始化
												$("#bPic").Jcrop({
													onChange:showPreview,
													onSelect:showPreview,
													aspectRatio:1
												});	
												}
										});
						
						//简单的事件处理程序，响应自onChange,onSelect事件，按照上面的Jcrop调用
						function showPreview(coords){
							if(parseInt(coords.w) > 0){
								//计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
								rx = $("#preview_box").width() / coords.w; 
								ry = $("#preview_box").height() / coords.h;
							   
								//通过比例值控制图片的样式与显示
								$("#crop_preview").css({
									width:Math.round(rx * $("#bPic").width()) + "px",	//预览图片宽度为计算比例值与原图片宽度的乘积
									height:Math.round(rx * $("#bPic").height()) + "px",	//预览图片高度为计算比例值与原图片高度的乘积
									marginLeft:"-" + Math.round(rx * coords.x) + "px",
									marginTop:"-" + Math.round(ry * coords.y) + "px"
								});
								 	
									width =coords.w;
									height = coords.h;
								 	x =coords.x;
									y =coords.y;  
							
							}
						}
						
						
						$("#button").click(function() {
							id = document.getElementById("id").value;
							if(width==null||height==null){
								alert("请截取头像");
							}
							params = "width="+width+"&height="+height+"&x="+x+"&y="+y+"&id="+id;
							//使用jQuery中的$.ajax({});Ajax方法
							$.ajax({
								url : 'XImages',
								type : 'POST',
								data : params,
								success : function(data) {
									/* window.location.href="UserInfo"; */
									/* window.location.reload();  */
									window.parent.location.reload();  
								}
							});
							
						});
						
						$("#button1").click(function(){
							id = document.getElementById("id").value;
							params = "id="+id;
							//使用jQuery中的$.ajax({});Ajax方法
							$.ajax({
								url : 'cancleUploadeHeaderImage',
								type : 'POST',
								data : params,
								success : function(data) {
									window.parent.location.reload();  
								}
							});
						});
					});
	
	
</script>
<style>
#div1 {
		border-radius: 5px;
		border: 0px solid #999999;
		width: 610px;
		height: 500px;
}

#div1_1 {
		background-color: #333333;
		color: #FFB100;
		font-size: 20px;
		padding-left: 20px;
		padding-top: 5px;
		height: 30px;
}

#div1_2 {
		margin-top: 20px;
		margin-left: 70px;
		width: 300px;
		height: 300px;
}

#div1_2_1 {
		width: 150px;
		height: 150px;
		margin-top: 10px;
		background-color: #000000;
		text-align: center;
}
.div1_2_1 img{
	width: 150px;
	max-height: 150px
}
 input[type="button"] {
		width: 70px;
		height: 30px;
} 
</style>
</head>
<body>
<div id="div1">
<div id="div1_1">头像设置</div>
		<div style="width: 100%" style="width: 100%;float: left;">
			<div style="float: left; margin-top: 5px; margin-bottom: 10px;">
				<input name="uploadify" id="uploadify" />
			</div>
		</div>
		<div id="fileQueue" style="margin-top: 50px;"></div>
	<div class="box-lanrenzhijia" style="float: left;">
	<input type="hidden" value="${user.getId()}" id="id">
	<div  id="oldImage"><img alt="" src="${user.getUserImageUrl()}" style="width: 150px;height: 150px;"> </div>
	<div class="part01-jscrop"><span id="preview_box" class="crop_preview"><img id="crop_preview" src="" /></span>	</div>
	
	<div style="float: left;margin-left: 130px;"><img style="width: 450px;" id="bPic" src=""/></div>
	
</div>
<div style="float: left;margin-left: 170px;margin-top: 10px;display: none;" id="btdiv"><input type="button" value="保存" id="button">
 <input type="button" value="取消" id="button1"> </div>

</div>

</body>
</html>
