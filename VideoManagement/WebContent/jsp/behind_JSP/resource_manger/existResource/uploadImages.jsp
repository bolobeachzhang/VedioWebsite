<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>已上传图片资源</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="UTF-8"></script>
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<script type="text/javascript">
	$(document).ready(function() {
		//定义全选框的名称为$chkall 
		var $chkall = $('#button1');
		var $delete = $("#delete");
		var $hidden = $("#hidden");
		var $chkarry = $('input[type="checkbox"]');//取到除全选框的其它复选框 
		//全选框 的实现函数 
		$chkall.click(function() {
			$chkarry.each(function() {
				$(this).attr('checked', 'checked');
			});//设置其它复选框值与全选框同步 ，实现全选，取消全选功能 
		});
		$delete.click(function(e) {
			//如果为真说明要提交。
			if (window.confirm("您确定要删除选中想吗？")) {
				return true;
			} else {
				//阻止提交
				return false;
				e.preventDefault();
			}
		});
	});
</script>
<script type="text/javascript">
	function deleteA() {
		return window.confirm("确认要删除选择信息吗？？");
	}
	function publishImage() {
		return window.confirm("确认要发布吗？？");
	}

	function delAll() {
		document.getElementById("buttonType").value = "del";
		var a = document.getElementById("buttonType").value;
		if (window.confirm("确认要删除选择信息吗？")) {
			var form = document.getElementById("form");
			//提交表单
			form.submit();
		} else {
			return false;
		}
	}
	function publishAll() {
		document.setElementById("buttonType").value = "publish";
		if (window.confirm("确认要更改选择的信息吗？")) {
			var form = document.getElementById("form");
			//提交表单
			form.submit();
		} else {
			return false;
		}
	}
	function changeType(){
		//提交表单
		typeForm.submit();
	}
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
	height: 120px;
	margin-left: 0px;
	margin-top: -15px;
}
</style>
</head>
<body>
		<div style="float: left;width: 100%;margin-top: 10px;">
		<div style="width:300px;float: left;margin-left: 25px;">
		<form style="width:200px;" action="uploadImages?currentPage=${strutsPageBean2.getPreviousPage()}&imageSortType=${imageSortType}" id="typeForm">
			<select name="imageSortType" id="imageSortType" onchange="changeType()">				
				<c:choose>
					<c:when test="${imageSortType!=null}">
						<option value="${imageSortType }">${imageSortType }</option>
					</c:when>
					<c:otherwise>
						<option >选择分类</option>
					</c:otherwise>
				</c:choose>
				
				<c:forEach items="${imagesSorts}" var="imagesSorts">
				<option value="${imagesSorts.getSortName()}">${imagesSorts.getSortName()}</option>
				</c:forEach>
			</select>
			</form>
			</div>
			<div style="float: left;margin-left: 280px;">
			<button class="btn" id="button1"
				style="float: right; margin-right: 20px;">全选</button>
				</div>
		</div>
		<c:if test="${empty exitImage}">
		<div align="center" style="font-size: 14px; color: #0088CC;">>>>>>>>暂无数据>>>>>></div>
		</c:if>
		<div style="width: 100%;float: left;">
			<form
				action="deelMoreImages?currentPage=${strutsPageBean2.getCurrentPage()}&imageSortType=${imageSortType}"
				method="post" id="form">
				<input type="hidden" id="buttonType" value="" name="buttonType">
				<c:forEach items="${exitImage}" var="exitImage">
					<div class="div1">
						<div class="checkBox">
							<input type="checkbox" name="checkboxImg"
								value="${exitImage.getId() }" />
						</div>
						<div class="div1_1">
							<a href="${exitImage.getUrl() }" target="_blank"><img
								src="${exitImage.getUrl()}" class="imgshow"></a>
						</div>
						<div class="div1_2">
							<a href="#"><img src="images/behind_img/Edit.png"></a> <a
								href="#"><img src="images/behind_img/Document-Check.png"></a>
							<a
								href="delUploudImages?id=${exitImage.getId()}&currentPage=${strutsPageBean2.getCurrentPage()}&imageSortType=${imageSortType}"
								onclick="return deleteA()" name="deleteImages"><img
								src="images/behind_img/Garbage.png"></a>
						</div>
					</div>
				</c:forEach>
				</form>
			</div>
	<c:if test="${!empty exitImage}" >
		<div style="padding-left: 100px; width: 600px; float: left;">
			<button type="button"
				style="margin-left: 30px; background-color: #ff9600; width: 107px; height: 41px; color: #ffffff;">发布</button>
			<button type="button" onclick="delAll()"
				style="margin-left: 50px; background-color: #ff9600; width: 107px; height: 41px; color: #ffffff;">删除</button>
			<button type="button" onclick="publishAll()"
				style="margin-left: 50px; background-color: #ff9600; width: 107px; height: 41px; color: #ffffff;">取消</button>
		</div>
	
	<div id="fenye1">
		<c:if test="${strutsPageBean2.getCurrentPage()>1}">
			<a
				href="uploadImages?currentPage=${strutsPageBean2.getPreviousPage()}&imageSortType=${imageSortType}"
				title="上一页">上一页</a>
		</c:if>
		<span>当前${strutsPageBean2.getCurrentPage()
			}页/共${strutsPageBean2.getTotlePages() }页</span>
		<c:if
			test="${strutsPageBean2.getCurrentPage()< strutsPageBean2.getTotlePages()}">
			<a href="uploadImages?currentPage=${strutsPageBean2.getNextPage()}&imageSortType=${imageSortType}"
				title="下一页">下一页</a>
		</c:if>
		<form action="uploadImages?imageSortType=${imageSortType}" method="post">
			跳转到<input type="text" name="currentPage">页 <input
				type="submit" value="go">
		</form>
	</div>
	</c:if>
</body>
</html>
