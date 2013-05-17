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

.div2 {
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

.p3 {
	width: 130px;
	height: 20px;
	font-size: 16px;
	font-weight: bolder;
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
</style>
</head>
<body>
	<div id="div">
		<!-- 评论过滤关键词设定 -->
		<div class="googleResercach">
			<p class="p3">指定网站搜索:</p>
			<form action="getImageUrlAction" method="POST">
				<div class="div2">
					<p class="p2">图片属性限制</p>
					<select style="width: 130px; margin-left: 15px;" name="imgsz">
						<option value="medium" selected="selected">请选择图片大小</option>
						<option value="icon">icon图片</option>
						<option value="small">小图片</option>
						<option value="medium">中等图片</option>
						<option value="large">大图片</option>
						<option value="xlarge">较大图片</option>
						<option value="xxlarge">很大图片</option>
						<option value="huge">巨大图片</option>
					</select> <select style="width: 130px; margin-left: 15px;"
						name="as_filetype">
						<option value="jpg" selected="selected">请选择图片格式</option>
						<option value="jpg">jpg</option>
						<option value="png">png</option>
						<option value="gif">gif</option>
						<option value="BMP">BMP</option>
					</select> <select style="width: 130px; margin-left: 15px;" name="imgcolor">
						<option value="black" selected="selected">请选择图片颜色</option>
						<option value="black">黑色</option>
						<option value="blue">蓝色</option>
						<option value="brown">棕色</option>
						<option value="gray">灰色</option>
						<option value="green">绿色</option>
						<option value="orange">橘黄色</option>
						<option value="purple">紫色</option>
						<option value="red">红色</option>
						<option value="teal">水鸭色</option>
						<option value="white">白色</option>
						<option value="yellow">黄色</option>
					</select> <select style="width: 130px; margin-left: 15px;" name="imgc">
						<option value="color" selected="selected">请选择颜色灰度</option>
						<option value="gray">灰度图像</option>
						<option value="color">彩色图像</option>
					</select>
				</div>
				<div class="div2">
					<p class="p2">关键词抓取</p>
					<input type="text" name="categoryName" style="width: 585px;" /><br>
				</div>
				<div class="div2">
					<p class="p2">url抓取</p>
					<input type="text" name="url" style="width: 585px;" /> <br>
				</div>
				<div class="div2">
					<p class="p2">线程日期抓取</p>
					<input type="text" style="width: 585px;" />
					<button type="submit">自动搜索</button>
					<br> <label style="color: #818181; margin-left: 20px;">
						* 以分号隔开关键字，点击确定上传</label>
				</div>
			</form>
		</div>
		
		
		
		<div class="googleResercach">
			<p class="p3">全球搜索:</p>
			<form action="getImageUrlByFlickr" method="POST">
				<div class="div2">
					<p class="p2">关键词抓取</p>
					<input type="text"  name="categoryName" style="width: 585px;" /><br>
				</div>
				<div class="div2">
					<p class="p2">线程日期抓取</p>
					<input type="text" style="width: 585px;" />
					<button type="submit">自动搜索</button>
					<br> <label style="color: #818181; margin-left: 20px;">
						* 以分号隔开关键字，点击确定上传</label>
				</div>
			</form>
		</div>
	</div>
</body>
</body>
</html>
