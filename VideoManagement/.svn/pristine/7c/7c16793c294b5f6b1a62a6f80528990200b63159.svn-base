<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>评论管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="UTF-8"></script>
<script type="text/javascript">
	function selectAll(checkbox) {
		$('input[type=checkbox]').prop('checked', $(checkbox).prop('checked'));
	}

	function checkDete() {
		var d = document.getElementsByName("ids");
		var ischeck = false;
		for (var i = 0; i < d.length; i++) {
			if (d[i].checked) {
				ischeck = true;
				break;
			} else {
				ischeck = false;
			}
		}

		if (ischeck) {
			if (window.confirm("你确定删除选中项?")) {
				return true;
			} else {
				return false;
			}
		} else {
			alert("你没有选中任何选项");
			return false;
		}

	}

	function checksig() {
		if (window.confirm("你确定删除选中项?")) {
			return true;
		} else {
			return false;
		}
	}
	/* function dete() {
		var s = '';
		$('input[name="ids"]:checked').each(function() {
			s += $(this).val() + ',';
		});
		if (s == "") {
			alert("你还没有选中任何选项！");
		} else {
			$.ajax({
				url : "delAll",
				data : "ids=" + s,
				success : function(data) {
					//删除对应的节点
					//alert(data);
					if (data == "success") {
						//alert(s)
						var element = s.split(",");
						alert(element.length);
						for ( var i = 0; i < element.length - 1; i++) {
							var id = element[i];
							$('#' + id).empty();
						}
						alert("恭喜你，删除成功");
					} else {
						alert("很抱歉，删除失败！");
					}

				}
			});
		}
	}
	function delSignal(object){
			var s1 = object.value;
			alert(s1);
			//alert('asas');
			var s=s1+",";	
			$.ajax({
				url : "delAll",
				data : "ids=" + s,
				success : function(data) {
					//删除对应的节点
					//alert(data);
					if (data == "success") {
						//alert(s)
						var element = s.split(",");
						//alert(element.length);
						for ( var i = 0; i < element.length - 1; i++) {
							var id = element[i];
							$('#' + id).empty();
						}
						alert("恭喜你，删除成功");
					} else {
						alert("很抱歉，删除失败！");
					}
				}
			});
	} */
</script>


<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<style>
#div {
	width: 765px;
	height: auto;
	padding-left: 10px;
}

tr:nth-child(odd) {
	background-color: #e9e9e9;
}

.p {
	margin-top: 12px;
	margin-left: 11px;
	font-size: 14px;
}

.table1 {
	margin: 0px;
}

td {
	height: 19px;
}

th {
	height: 19px;
}

table th,table td {
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px;
	border: 1px dashed #dddddd;
}

a {
	color: #000000;
}

a:HOVER {
	text-decoration: none;
}

#deleteAll {
	margin-left: 3px;
	color: maroon;
}

#selectAll {
	font-size: large;
	color: maroon;
}

#page {
	text-align: center;
	margin-top: 20px;
	font-family: fantasy;
	font-size: medium;
}
</style>
</head>
<body style="background-color: #fff;">

	<div id="div">
		<p class="p">评论管理</p>
		<form
			action="delAllCom?offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}"
			method="post">
			<table class="table table1 " style="margin-top: 13px;">
				<tr style="background-color: #d3ddee;">
					<th width="16px;">选框</th>
					<th>ID</th>
					<th>评论者</th>
					<th>评论时间</th>
					<th style="text-align: center;">评论内容</th>
					<th>IP</th>
					<th style="text-align: center;">操作</th>
				</tr>
				<c:forEach var="var" varStatus="vs" items="${comment}">
					<tr id="${var.id}">
						<td><input type="checkbox" name="ids" value="${var.id}"
							id="ids" /></td>
						<td>${var.id}</td>
						<td style="text-align: center;">${var.commentName}</td>
						<td style="text-align: center;">${fn:substring(var.commentTime,0,10)}</td>
						<td style="text-align: center;">${fn:substring(var.commentConent,0,10)}。。</td>
						<td style="text-align: center;">${var.userIp}</td>
						<td style="text-align: center;"><a
							href="delAllCom?ids=${var.id}&offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}"
							onclick="checksig()">删除</a>&nbsp;<a
							href="getInfo?id=${var.id}&offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}"
							">查看</a></td>
					</tr>
				</c:forEach>
			</table>
			<div align="center" style="font-size: medium;">
				<c:choose>
					<c:when test="${empty comment}">
							不存在该数据
					</c:when>
				</c:choose>
			</div>
			<div align="right">
				<input type="checkbox" onclick="selectAll(this);" />全选 <input
					type="submit" value="删除选中项" name="deleteAll" id="deleteAll"
					onclick="return checkDete()">
			</div>
		</form>
	</div>
	<div id="page">

		<c:if test="${(pageCount!=0)}">
		总共 ${pageCount} 页 当前在第${pageNow }/${pageCount}
		</c:if>
		<c:if test="${(pageCount>1) && (pageNow !=1) }">
			<a href="comment?offset=${offset-10}&pageNow=${pageNow-1}">上一页</a>
		</c:if>
		<c:if
			test="${pageCount>1 && (pageNow !=pageCount)&&(pageNow!=pageCount) }">
			<a href="comment?offset=${offset+10}&pageNow=${pageNow+1}">下一页</a>
		</c:if>
		<c:if test="${(pageCount!=0)}">
			<a href="comment?offset=${(pageCount-1)*10}&pageNow=${pageCount}">尾页</a>
		</c:if>




	</div>

</body>
</html>
