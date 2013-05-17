<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>主页焦点图</title>
<!-- 采用jquery的ajax技术实现上传文件成功之后的预览效果 -->
<script type="text/javascript" src="jquery-1.8.0.js"></script>
<script type="text/javascript"
	src="js/base_Js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript">
	//上传之前客户端预览焦点图
	function preview(file) {
		var prevDiv = document.getElementById('light');
		if (file.files && file.files[0]) {
			var reader = new FileReader();
			reader.onload = function(evt) {
				prevDiv.innerHTML = '<div><span class="close"><a href="#" onclick="disp_alert()">关闭预览</a></span><img src="' + evt.target.result + '" /></div>';
			}
			reader.readAsDataURL(file.files[0]);
		} else {

			//prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
			alert("请使用火狐、谷歌、opera、IE10及以上的版本进行预览,否则无法预览!");
			return false;
		}
		document.getElementById('light').style.display = 'block';
		//document.getElementById('fade').style.display='block';//弹出对话框
	}
	//判断上传图片的合法性，只能支持jpg、png、gif
	function checkType(obj) {
		var imageFileName = obj.value;
		if (imageFileName == "") {
			alert("请上传图片");
			return false;
		}
		if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f)) {
			alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
			return false;
		}
	}
</script>
<script type="text/javascript">
	function disp_alert() {
		document.getElementById('light').style.display = 'none';
	}
	function checkConfirm(obj) {
		var ImageFile = obj.image.value;
		if (ImageFile == "") {
			alert("确认更换前请先选择上传焦点图!");
			return false;
		}
		if (ImageFile != "") {
			if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ImageFile)) {

				alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
				obj.imageFile.value = "";
				return false;
			} else {
				if (confirm("你确定你要替换该焦点图?")) {
					return true;
				} else {
					obj.imageFile.value = "";
					return false;
				}
			}
		}

	}
</script>
<script type="text/javascript">
	//该jquery函数实现弹出div并且在div中追加<img>标签，
	$(function() {
		// 使用的类选择器，id选择器效果是只有第一条记录才会弹出效果
		$(".scan").change(function() {
			var fileObj = document.getElementsByName("image");
			var realyFile = null;
			for ( var i = 0; i < fileObj.length; i++) {
				if (fileObj[i].value != "") {
					realyFile = fileObj[i];
				}
			}
			//验证图片格式额有效性
			var imageFileName = realyFile.value;
			if (imageFileName == "") {
				alert("请上传图片");
				return false;
			}
			if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(imageFileName)) {

				alert("图片类型必须是.gif,jpeg,jpg,png中的一种");

				return false;
			}
			//在弹出的div中预览图片
			preview(realyFile);
		});
	});
</script>
<style>
.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 30%;
	width: 650px;
	height: 250px;
	padding: 16px;
	/* background-color: lime;  */
	background-color: orange;
	z-index: 1002;
	overflow: hidden;
	margin-left: auto;
}

.close {
	float: right;
}
</style>
</head>
<body>
	<c:if test="${!empty flag}">
		<script type="text/javascript">
			$(function() {
				alert('恭喜你，成功上传图片');
			});
		</script>
	</c:if>
	<table border="0">
		<c:forEach items="${images }" var="var" varStatus="status">
			<tr>
				<td>当前图片${status.count}: <img src="${var.url }" height="100px"
					width="90%" />
				</td>
				<td>
					<form name="form" action="upLoadImage?type=${var.content}" method="POST"
						enctype="multipart/form-data" onsubmit="return checkConfirm(this)">
						<c:if test="${var.content=='mainFocus'}">
						<input type="hidden" name="fileMark" value="mainFocus${status.count}"> 
						</c:if>
						<c:if test="${var.content=='videoFocus'}">
						<input type="hidden" name="fileMark" value="videoFocus${status.count}"> 
						</c:if>
						<c:if test="${var.content=='imageFocus'}">
						<input type="hidden" name="fileMark" value="imageFocus${status.count}"> 
						</c:if>
						<input type="file"
							name="image" class="scan"> <input type="submit"
							value="确认更换">
						<!-- 显示预览图片的div -->
						<div id="light" class="white_content" style="cursor: move;">
						</div>
					</form> <br>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		$(function() {
			$("#light").draggable();
		});
	</script>
</body>
</html>