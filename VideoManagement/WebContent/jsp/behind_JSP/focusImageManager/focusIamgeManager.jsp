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
</head>
<!-- 采用jquery的ajax技术实现上传文件成功之后的预览效果 -->
<script type="text/javascript" src="jquery-1.8.0.js"></script>
<script type="text/javascript"
	src="js/base_Js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript">
//用于页面的跳转
$(function(){
	//获取选择的页面	
	//alert("asca");
	 $('#selected').change(function(){
		var value=$('#selected').val();
		//cx calert(value);
		if (value == "mainFocus") {
			$('#focusImage').attr("src","focusImage1?type="+value) ;
		}else if (value == "videoFocus") {
			$('#focusImage').attr("src","focusImage2?type="+value) ;
		}else if (value == "imageFocus") {
			$('#focusImage').attr("src","focusImage3?type="+value) ;
		}
	}); 
});
</script>

<body>
	<span style="font-size: 24px; font-weight: 500; margin-left: 20px;">焦点图管理<br /></span>
	<hr color=#1f8ada size=1>
	<table>
	<tr>
	<td>
	焦点图选择：
	</td>
	<td>
	<select name="focus" id="selected">
		<option value="mainFocus" selected="selected" >主页焦点图</option>
		<option value="videoFocus">视频焦点图</option>
		<option value="imageFocus">图片焦点图</option>
	</select>
	</td>
	</tr>
	</table>
	<iframe scrolling="auto" src="focusImage1?type=mainFocus" id="focusImage"   style="height: 1000px; width: 700px;  border: 1px solid blue ;"> 
	</iframe>
</body>
</head>
</html>