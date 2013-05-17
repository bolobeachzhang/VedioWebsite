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
		for ( var i = 0; i < d.length; i++) {
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
	function ModifyAuthority(type,id) {
		if (window.confirm("你确定更改本用户的权限？")) {
			$.ajax({
				url : "ModifyAuthority",
				data : "type=" + type+"&id="+id,
				success : function(data) {
					//alert("csacas");
					//$('#'+id).remove();
					if (data == 1) {
						alert("恭喜你，修改成功！");
					} else {
						alert("系统繁忙，请稍后！");
					}
				}
			});
		}
	}

	/* function delSignal(object) {
		var id  = object.value();
		//alert()
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
	width: 700px;
	height: auto;
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
	margin-left: 19px;
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
<body>

	<div id="div">
		<p class="p">会员管理</p>
		<form
			action="delVip?offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}&type=${type}"
			method="post">
			<table class="table table1 " style="margin-top: 13px;">
				<tr style="background-color: #d3ddee;">
					<th>选框</th>
					<th style="text-align: center;">ID</th>
					<th style="text-align: center;">用户名</th>
					<th style="text-align: center;">email</th>
					<th style="text-align: center;">注册时间</th>
					<th style="text-align: center;">权限</th>
					<th style="text-align: center;">操作</th>
				</tr>
				<c:forEach var="var" varStatus="vs" items="${user}">
					<tr id="${var.id}" >
						<td><input type="checkbox" name="ids" value="${var.id}"
							id="ids" /></td>
						<td>${var.id}</td>
						<td style="text-align: center;">${var.userName}</td>
						<td style="text-align: center;">${var.email}</td>

						<td id="time" style="text-align: center;">${fn:substring(var.registTime,0,10)}</td>

						<td>
						<select id="${var.id}" name="select" onchange="ModifyAuthority(this.value,this.id)" style="width: 100px;">
								<option selected="selected" value="0">系统会员</option>
								<option value="1">注册人员</option>
								<option value="2">系统管理员</option>
						</select>
						</td>
						<td style="text-align: center;"><a
							href="delVip?ids=${var.id}&offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}&type=1"
							onclick="checksig()">删除</a><a
							href="getInfoUser?id=${var.id}&offset=${offset}&pageNow=${pageNow}&signalSize=${signalSize}&type=1"
							style="margin-left: 10px">查看</a></td>
					</tr>
				</c:forEach>
			</table>
			<div align="center" style="font-size: medium;">
				<c:choose>
					<c:when test="${empty user}">
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
		<c:if test="${(pageCount>=1)}">
			<a href="user_vip?offset=0&pageNow=1&type=1">首页</a>
		</c:if>
		<c:if test="${(pageCount>1) && (pageNow !=1) }">
			<a href="user_vip?offset=${offset-10}&pageNow=${pageNow-1}&type=1">上一页</a>
		</c:if>
		<c:if
			test="${pageCount>1 && (pageNow !=pageCount)&&(pageNow!=pageCount) }">
			<a href="user_vip?offset=${offset+10}&pageNow=${pageNow+1}&type=1">下一页</a>
		</c:if>
		<c:if test="${(pageCount!=0)}">
			<a
				href="user_vip?offset=${(pageCount-1)*10}&pageNow=${pageCount}&type=1">尾页</a>
		</c:if>




	</div>

</body>
</html>
