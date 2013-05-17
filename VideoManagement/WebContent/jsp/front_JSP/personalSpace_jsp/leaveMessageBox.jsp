<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>留言信箱</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="../../../js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<script type="text/javascript" src="../../../js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"></script>
<link rel="shortcut icon" href="../../images/logo.png" />
<link rel="stylesheet" type="text/css" href="../../css/base_css/bootstrap.css">
<style>
#div{
    border-radius: 5px;
    border: 1px solid #999999;
    width: 632px;
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
.div2{
   width: 400px;
    height: 120px;

    margin-left: 40px;
}
.div2_1{
    width: 100px;
    height: 100PX;
    float: left;
}
.div2_1_1{
    width: 60px;
    margin: auto;
    height:60px ;
    margin-top: 20px;
    background-color: #AAAAAA;
}
.div2_1_2{
    text-align: center;
}
.div2_2{
    width: 280px;
    height: 80px;
    border-radius: 6px;
    border: 1px solid #222222;
    float: right;
    margin-top: 10px;
}
.label1{
    float: right;
    margin-top: 60px;
}
a{
    text-decoration: none;
    color: #000000;
}
</style>
</head>
<body>
<div id="div">
   <div id="div1_1">
      留言箱
    </div>
    <div class="div2">
        <div class="div2_1"><div class="div2_1_1"></div><div class="div2_1_2"><label class="label">ID</label></div></div>
        <div class="div2_2"><label class="label1"><a href="#">回复</a><a href="#">删除</a></label></div>
    </div>
    <div class="div2">
        <div class="div2_1"><div class="div2_1_1"></div><div class="div2_1_2"><label class="label">ID</label></div></div>
        <div class="div2_2"><label class="label1"><a href="#">回复</a><a href="#">删除</a></label></div>
    </div>
    <div class="div2">
    <div class="div2_1"><div class="div2_1_1"></div><div class="div2_1_2"><label class="label">ID</label></div></div>
    <div class="div2_2"><label class="label1"><a href="#">回复</a><a href="#">删除</a></label></div>
</div>
</div>
</body>
</html>
