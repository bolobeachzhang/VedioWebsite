<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>密码设置</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="../../../js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<link rel="shortcut icon" href="../../../images/logo.png" />
<link rel="stylesheet" type="text/css" href="../../../css/base_css/bootstrap.css">
<style>
#div1{
    border-radius: 5px;
    border: 1px solid #999999;
    width: 610px;
    height: 500px;
}
#div1_1{
    background-color: #333333;
		color: #FFB100;
    font-size: 20px;
    padding-left: 20px;
    padding-top: 5px;
    height: 30px;
}
tr{
    height: 40px;
}
td:first-child{
    text-align:right;
}
</style>
<script type="text/javascript">
$(function(){
	//先从数据库取出旧密码存放起来 
	$DBoldPwd = 123;
	
	$("#submit").click(function(){
		$oldPwd = $("#oldPwd").val();
		$newPwd = $("#newPwd").val();
		$newpwd2 = $("#newPwd2").val();
		if($oldPwd==""||$newPwd == ""||$newpwd2 == ""){
			alert("输入的密码不能为空！！！");
		}else{
			if($oldPwd != $DBoldPwd){
				alert("旧密码不正确！！！");
			}else if($newPwd != $newpwd2){
				alert("两次密码输入不一致！！！");
			}else{window.confirm("您确定要修改密码吗！！！");}
		}
		
	});
});
</script>
</head>
<body>
<div id="div1">
    <div id="div1_1">
        密码设置
    </div>
    <div id="div1_2">
    <form action="" method="post">
        <table style="margin-top:40px ;margin-left: 40px;">
            <tr><td>旧密码： </td><td><input type="password" id="oldPwd" style="width: 200px;height: 20px;border-radius: 5px;"></td></tr>
            <tr><td>新密码： </td><td><input type="password" id="newPwd" style="width: 200px;height: 20px;border-radius: 5px;"></td></tr>
            <tr><td>再次输入密码： </td><td><input type="password" id="newPwd2" style="width: 200px;height: 20px;border-radius: 5px;"></td></tr>
            <tr><td> </td><td><input type="submit" id="submit" style="width: 70px; height: 30px;" value="保  存"></td></tr>
        </table>
      </form>
    </div>
</div>
</body>
</html>
