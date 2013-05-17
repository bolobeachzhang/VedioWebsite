<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<script type="text/javascript" src="js/front_js/personalSpaceMain.js" charset="utf-8"></script>

<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css" href="css/base_css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/front_css/personalSpaceMain.css">
</head>
<body>
  <div class="content">
    <div class="header">
    	<div class="headcon">
	       	<div class="sec1">
		        	<a href="receptionImage"><img src="images/front_img/personalSpace/personalSpace_pic.png"></a>
		        	<a href="ReceptionVedio"><img src="images/front_img/personalSpace/personalSpace_video.png"></a>
		      </div>
		      <div class="sec2"><label><font color="#F0A605"><b>${user.getUserName()}的个人中心 </b></font> --<a href="">退出</a></label></div>
		      <div class="searchF" style="">
		      	<form action="" method="post">
				      <input class="searchInput" type="text"/>
				      <button class="buttt" type="submit" style="background-color: transparent;background-image: url('../../../images/front_img/personalSpace/personalSpace_search.png');"></button>
	     	  	</form>
	     	  </div>
     	 </div>
    </div><%--end header --%>
    <div class="contentFream">
              <div class="contLeftF">
                 <div class="cont1_1"><img alt="${user.getUserName()}" src="${user.getUserImageUrl()}" >  </div>
                 <div class="cont1_2"><b>${user.getUserName()}</b></div>
                 <div id="cont1_3" class="menuFream">
	                 	<ul>
											<li class="main">
													<a href="#">个人信息</a>
												<ul>
													<li>
														<a href="#">基本信息</a>
													</li>
													<li>
														<a href="#">头像设置</a>
													</li>
													<li>
														<a href="#">密码设置</a>
													</li>
												</ul>
											</li>
											<li class="main">
												<a href="#">开通会员</a>
											</li>
											<li class="main">
												<a href="#">留言信箱</a>
											</li>
										</ul>
            		 </div><%--END cont1_3 --%>
              </div><%--END "span3 cont1" --%>
              <div class="contRight" style="position: relative;">
                  <iframe  style="border: none;" id="right_content" src="personaldata" width="100%"
                              height="600px" ></iframe>
              </div>
    </div><%--end contentFream--%>
</div>
</body>
</html>
