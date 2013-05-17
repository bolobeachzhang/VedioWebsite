<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jsp????</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="jquery???" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#div {
	width: 700px;
	height: 500px;
	margin: auto;
	border: 1px solid #dddddd;
}

#div_1 {
	width: 100%;
	height: 170px;
}

#div1 {
	width: 150px;
	height: 150px;
	float: left;
	margin-left: 24px;
	margin-top: 24px;
	background-color: #000000;
}

#div2 {
	width: 500px;
	height: 150px;
	float: right;
	margin-left: 20px;
	margin-top: 24px;
}

.label {
	float: left;
	margin-left: 5px;
	font-size: 14px;
}

input[type="text"] {
	width: 400px;
	height: 20px;
}

#div3 {
	width: 100%;
	height: auto;
	margin-left: 24px;
	margin-top: 20px;
}

select {
	width: 150px;
	height: 30px;
	font-size: 12px;
	border: 1px solid #dddddd;
}

textarea {
	width: 80%;
	height: 100px;
}

button {
	margin-left: 30px;
	width: 107px;
	height: 41px;
}
</style>

</head>
<body>
	 <div id="div">
       <div id="div_1">
           <div id="div1"></div>
           <div id="div2">
               <p> <label class="label">名称：</label>  <input type="text"/></p>
               <p>  <label class="label">来源：</label> <label >土豆网</label></p>
               <p>  <label class="label">大小:</label> <label >15mb</label></p>
               <p> <label class="label">标签：</label>  <input type="text"/></p>
           </div>
       </div>

       <div id="div3">
         <p > 分类:
           <select>
           <option>选择分类</option>
           <option>选择分类</option>
           <option>选择分类</option>
           <option>选择分类</option>
           <option>选择分类</option>
       </select>  </p>
          <label>描述 ：</label><br>
           <textarea ></textarea>
       </div>
       <div style="margin-top: 10px;margin-left: 100px;">
           <div style="margin-top: 10px;margin-left: 100px;">
               <button  type="button">保存</button>
               <button  type="button" >返回</button>
               <button type="button" >删除</button>
           </div>
       </div>
   </div>
</body>
</html>
