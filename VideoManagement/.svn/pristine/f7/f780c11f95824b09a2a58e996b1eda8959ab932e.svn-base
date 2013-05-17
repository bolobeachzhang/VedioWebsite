<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>已经审核图片</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="utf-8"></script>
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
				$hidden.val("delete");
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
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
}

.div1_1 img {
	width: 146px;
	height: 110px;
	margin: 0px;
	padding: 0px;
}

.div1_2 {
	width: 146px;
	height: 35px;
	background-color: #bbb;
	margin-top: 13px;
}

img {
	margin-left: 12px;
}

p {
	margin-left: 24px;
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

.flashContent {
	text-align: center;
	widht: 146px;
	height: 18px;
	overflow: hidden;
	position: relative;
	top: -10px;
	background-color: black;
	opacity: 0.8;
	color: white;
}

.checkBox {
	float: left;
	margin: -6px 0 0 -15px;
}
</style>

</head>
<body>
	<c:if test="${strutsPageBean1.getTotleRows()!=0}">
		<button class="btn" id="button1"
			style="float: right; margin-right: 20px;">全选</button>
		<form action="audioDeleteImages" method="post">
			<input type="hidden" value="${strutsPageBean1.getCurrentPage()-1}"
				name="currentPage" /> <input type="hidden" id="hidden"
				value="publish" name="type" />
			<div id="div">
			<p style="height:35px;">&nbsp;</p>
				<c:forEach items="${images}" var="images">
					<!-- 資源列表 -->
					<div class="div1">
						<div class="checkBox">
							<input type="checkbox" name="checkbox" value="${images.getId()}" />
						</div>
						<div class="div1_1">
							<a href="${images.getUrl() }" target="_blank"><img
								src="${images.getUrl()}"></a>
							<div class="flashContent">${images.getTitle() }</div>
						</div>
						<div class="div1_2">
							<a href="#" title="编辑"><img src="images/behind_img/Edit.png"></a>
							<c:if test="${strutsPageBean1.getTotleRows()%12 ==1}">
								<a
									href="audioDeleteImages?currentPage=${strutsPageBean1.getCurrentPage()-1}&publish=delete&imageId=${images.getId() }"
									onclick="return deleteA()" name="deleteImages"><img
									title="删除" src="images/behind_img/Garbage.png"></a>
							</c:if>
							<c:if test="${strutsPageBean1.getTotleRows()%12 !=1}">
								<a
									href="audioDeleteImages?currentPage=${strutsPageBean1.getCurrentPage()}&imageId=${images.getId() }&publish=delete"
									onclick="return deleteA()" name="deleteImages"><img
									title="删除" src="images/behind_img/Garbage.png"></a>
							</c:if>
						</div>
					</div>
				</c:forEach>
				<!-- 資源列表 -->
				<!-- <div class="div1">
    	<div class="checkBox"><input type="checkbox" name="checkbox" value=""/></div>
     	<div class="div1_1"></div>
     	<div class="div1_2">
     		<a href="#"><img src="images/behind_img/Edit.png"></a>
     		<a href="#"><img src="images/behind_img/Document-Check.png"></a>
     		<a href="#"><img src="images/behind_img/Garbage.png"></a>	
     	</div>
    </div> -->
				<!-- 一样的 -->
			</div>
			<div style="padding-left: 100px; width: 600px; float: left;">
				<input type="submit" id="delete"
					style="margin-left: 50px; background-color: #ff9600; width: 107px; height: 41px; color: #ffffff;"
					value="删除" />
				<button type="button"
					style="margin-left: 50px; background-color: #ff9600; width: 107px; height: 41px; color: #ffffff;">取消</button>
			</div>
		</form>

		<div id="fenye1">
			<c:if test="${strutsPageBean1.getCurrentPage()>1}">
				<a
					href="audioImage?currentPage=${strutsPageBean1.getPreviousPage()}"
					title="上一页">上一页</a>
			</c:if>
			<span>当前${strutsPageBean1.getCurrentPage()
				}页/共${strutsPageBean1.getTotlePages() }页</span>
			<c:if
				test="${strutsPageBean1.getCurrentPage()< strutsPageBean1.getTotlePages()}">
				<a href="audioImage?currentPage=${strutsPageBean1.getNextPage()}"
					title="下一页">下一页</a>
			</c:if>
			<form action="audioImage" method="post">
				跳转到<input type="text" name="currentPage">页 <input
					type="submit" value="go">
			</form>
		</div>
	</c:if>
	<c:if test="${strutsPageBean1.getTotleRows()==0}">
		<div>对不起数据不存在。。。。。</div>
	</c:if>
</body>
</html>
