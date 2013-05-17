<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户上传资源审核</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"></script>
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript">
	var content_id = null;
	$(document).ready(function() {
		$("textarea").focus(function() {
			content_id = document.activeElement.id;
		}).blur(function() {
			if (content_id != 0) {
				var lg = content_id.length;
				var index = content_id.indexOf('_');
				var id = content_id.substr(index + 1, lg);
				//把表单的数据进行序列化
				var params = $("#form_" + id).serialize();
				params = params + "&id=" + id;
				//使用jQuery中的$.ajax({});Ajax方法
				$.ajax({
					url : "ImagesMsg",
					type : "POST",
					data : params,
					dataType : "json",
					success : function(data) {
						alert(data);
					}
				});
			} else {
				//把表单的数据进行序列化
				var params = $("#form").serialize();
				params = params + "&id=0";
				//使用jQuery中的$.ajax({});Ajax方法
				$.ajax({
					url : "ImagesMsg",
					type : "POST",
					data : params,
					dataType : "json",
					success : function(data) {
						alert(data);
					}
				});
			}

		});
	});
</script>
<style>
body{background-color: #fff;}
/*最外层div*/
#div {
	width: 700px;
	height: auto;
	background-color: #ffffff;
	margin: auto;
}

.div1 {
	width: 146pX;
	height: 190px;
	margin-left: 24px;
	float: left;
	margin-top: 10px;
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

.imgshow {
	width: 146px;
	height: 134px;
	margin-left: 0px;
	margin-top: -15px;
}

.addAll {
	width: 100%;
	float: left;
	margin-top: 20px;
	margin-left: 24px;
}
</style>

</head>
<body>
<div style="font-size: 24;color: #0088CC;margin-top: 20px;">编辑上传视频信息</div>
<c:if test="${empty flashVedios}" >
	<div align="center" style="font-size: 24;color: #0088CC;">>>>>>>>暂无数据>>>>>></div>
</c:if>
<c:if test="${!empty flashVedios}" >
	<div id="div">
		<div class="addAll" id="add_all">
			<form action="" id="form">
				<div style="float: left; width: 81%;">
					<div style="float: left; font-size: 24px; font-family: fantasy;">统一添加视频信息
					</div>
					<div style="float: left; font-size: 18px;">
						\<a href="addFlashmsg?change=ok" onclick="change()">编辑单个视频信息</a>
					</div>
				</div>
				<div style="float: left; margin-right: 7px;">
					<input type="submit" value="保存并去查看视频">
				</div>
				<c:if test="${change==null}">
					
						<div style="padding-top: 30px; width: 100%; font-size: 14px">
							视频名称：<input type="text" style="height: 30px; width: 450px;" name="title">
						</div>
						<div style="font-size: 14px">
							视频描述：
							<textarea rows="" cols="" style="height: 60px; width: 450px;" id="0" name="content"></textarea>
						</div>
			
				</c:if>
			</form>
		</div>
		<c:if test="${change==null}">
			
				<c:forEach items="${flashVedios}" var="flashVedios">
					<div class="div1">
						<div class="div1_1">
							<a href="${flashVedios.getUrl() }" target="_blank"><img
								src="${flashVedios.getFlashImagePath()}" class="imgshow"></a>
						</div>
						<div class="div1_2">
							<a href="#"><img src="images/behind_img/Edit.png"></a> <a
								href="#"><img src="images/behind_img/Document-Check.png"></a>
							<a href="#"><img src="images/behind_img/Garbage.png"></a>
						</div>
					</div>
				</c:forEach>
			<div id="fenye1">
				<c:if test="${strutsPageBean2.getCurrentPage()>1}">
					<a
						href="addFlashmsg?currentPage=${strutsPageBean2.getPreviousPage()}"
						title="上一页">上一页</a>
				</c:if>
				<span>当前${strutsPageBean2.getCurrentPage()
					}页/共${strutsPageBean2.getTotlePages() }页</span>
				<c:if
					test="${strutsPageBean2.getCurrentPage()< strutsPageBean2.getTotlePages()}">
					<a
						href="addFlashmsg?currentPage=${strutsPageBean2.getNextPage()}"
						title="下一页">下一页</a>
				</c:if>
				<form action="addFlashmsg" method="post">
					跳转到<input type="text" name="currentPage">页 <input
						type="submit" value="go">
				</form>
			</div>
		</c:if>
	</div>
	<c:if test="${change=='ok'}">

		<c:forEach items="${flashVedios}" var="flashVedios">
			<div style="float: left; margin-bottom: -40px; margin-top: 20px;">
				<div class="div1">
					<div class="div1_1">
						<a href="${flashVedios.getUrl() }" target="_blank"><img
								src="${flashVedios.getFlashImagePath()}" class="imgshow"></a>
					</div>
				</div>
				<div style="margin-left: 10px; margin-top: -5px; float: left;">
					<form name="form_${flashVedios.getId()}" id="form_${flashVedios.getId()}">
						图片名称：<br> <input type="text" name="title"
							id="title_${flashVedios.getId() }" style="width: 170px; height: 30px"><br>
						图片简介：<br>
						<textarea rows="3" name="content" id="content_${flashVedios.getId() }"
							style="width: 170px; height: 60px;"></textarea>
					</form>
				</div>
			</div>
		</c:forEach>
		<div>
			<div id="fenye1">
				<c:if test="${strutsPageBean2.getCurrentPage()>1}">
					<a
						href="addFlashmsg?currentPage=${strutsPageBean2.getPreviousPage()}&change=ok"
						title="上一页">上一页</a>
				</c:if>
				<span>当前${strutsPageBean2.getCurrentPage()
					}页/共${strutsPageBean2.getTotlePages() }页</span>
				<c:if
					test="${strutsPageBean2.getCurrentPage()< strutsPageBean2.getTotlePages()}">
					<a
						href="addFlashmsg?currentPage=${strutsPageBean2.getNextPage()}&change=ok"
						title="下一页">下一页</a>
				</c:if>
				<form action="addFlashmsg?change=ok" method="post">
					跳转到<input type="text" name="currentPage">页 <input
						type="submit" value="go">
				</form>
			</div>
		</div>
	</c:if>
</c:if>
</body>
</html>
