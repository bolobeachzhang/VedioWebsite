<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图片</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="图片,美女,景物,汽车,动物">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(window).scroll(
						function() {
							// 当滚动到最底部以上100像素时， 加载新内容  
							if ($(document).height() - $(this).scrollTop()
									- $(this).height() < 200) {
								var currentPage1 = $("#hidden").val();
								var imageType1 = $("#imageType").val();
								var currentPage1 = $("#hidden").val();
								var hiddenValue = ++currentPage1;
								$("#hidden").attr("value",hiddenValue);
								var mostPopularListF = $("#mostPopularListF");
								$.ajax({
									url:"executeImage",
									datatype:"json",
									type:"POST",
									data:{currentPage:currentPage1,imageType:imageType1},
									success:function(json){
									for(var i=0;i<json.length;i++){
										var url = json[i]['url'];
										var format = json[i]['resolution'];
										var id = json[i]['id'];
										var pageUrl1 = json[i]['pageUrl'];
										var pageUrl =pageUrl1.substring(0,24);
										var title = json[i]['title'];
										if(format!=null){
											$("<div class='mostPopularListListF item'><a href='recpetionImageNews?imageId="+id+" 'target='_blank' title='"+title+"'><img src="+url+" class='mostPopularListImg'/></a><span class='mostPopularS'>来自：<a href="+pageUrl+">"+pageUrl+"</a><span style='float: right;'>"+format+"</span></span></div>").appendTo(mostPopularListF); 
										}else{
											$("<div class='mostPopularListListF item'><a href='recpetionImageNews?imageId="+id+" 'target='_blank' title='"+title+"'><img src="+url+" class='mostPopularListImg'/></a><span class='mostPopularS'>来自：<a href="+pageUrl+">"+pageUrl+"</a><span style='float: right;'></span></span></div>").appendTo(mostPopularListF); 
										}
									}
									//同时在这里执行一个js函数的调用
									$("#mostPopularListF").gridalicious({
								        gutter: 10,
								        width: 194,
								        animate: true,
								        animationOptions: {
								                speed: 1,
								                duration: 400
								        }
								    });
								} 
								});
								
							}
						});
			});
</script>
<script type="text/javascript"
	src="js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<script type="text/javascript"
	src="js/base_Js/jquery.waterFall.min.js" charset="utf-8"></script>
<link rel="shortcut icon" href="images/logo.png" />
<!-- <link rel="stylesheet" type="text/css"
	href="css/base_css/bootstrap.css"> -->
<link rel="stylesheet" type="text/css"
	href="css/front_css/image_index.css">
<!-- 滚动条当在底部100px的时候执行此函数 -->
<style type="text/css">
/*焦点图样式  */
* {
	margin: 0;
	padding: 0;
}

img {
	border: 0;
}

.focusFream {
	background: -webkit-gradient(linear, 20% 20%, 100% 100%, from(#FFB958),
		to(#FF9C0F) );
	width: 100%;
	height: 300px;
	margin: 0 auto;
	float: left;
	margin-bottom: 30px;
}

#focus {
	margin-left: 25%;
	width: 930px;
	height: 300px;
	overflow: hidden;
	position: relative;
}

#focus ul {
	height: 300px;
	position: absolute;
}

#focus ul li {
	float: left;
	width: 930px;
	height: 300px;
	overflow: hidden;
	position: relative;
	background: #000;
}

#focus ul li img {
	width: 930px;
	height: 300px;
}

#focus ul li div {
	position: absolute;
	overflow: hidden;
}

#focusFream .btnBg {
	position: absolute;
	width: 100%;
	height: 30px;
	left: 0;
	background: #000;
}

#focusFream .btn {
	position: absolute;
	width: 880px;
	height: 20px;
	padding: 5px 10px;
	right: 35%;
	text-align: right;
}

#focusFream .btn span {
	display: inline-block;
	_display: inline;
	_zoom: 1;
	width: 35px;
	height: 20px;
	_font-size: 0;
	margin-left: 5px;
	cursor: pointer;
	background: #fff;
}

#focusFream .btn span.on {
	background: #fff;
}

#focus .preNext {
	width: 45px;
	height: 100px;
	position: absolute;
	top: 90px;
	background: url(images/front_img/sprite.png) no-repeat 0 0;
	cursor: pointer;
}

#focus .pre {
	left: 15%;
}

#focus .next {
	right: 15%;
	background-position: right top;
}
</style>

<script language="javascript" type="text/javascript"
	src="js/front_js/image_index.js"></script>
<!-- 滚动图的引入 -->
<script type="text/javascript"
	src="js/front_js/image_indexFocus.js"></script>

<style type="text/css">
/*返回顶部 */
.go {
	z-index: 202;
	width: 47px;
	height: 106px;
	background-color: #Fff;
	position: fixed;
	_position: absolute;
	_top: expression(eval(document.documentElement.scrollTop +        
		        document.documentElement.clientHeight-this.offsetHeight- (  
		      
		       parseInt(this.currentStyle.marginTop, 10)||200 )-(parseInt(this.currentStyle.marginBottom, 10)||0
		) ) );
	right: 8px;
	bottom: 6%;
	border-radius: 5px;
	box-shadow: 0 0 2px #6E6E6E
}

.go a {
	background: url(images/front_img/toTopAndBottom.png) no-repeat;
	display: block;
	text-indent: 999em;
	width: 37px;
	margin: 5px;
	border: 0;
	overflow: hidden;
	float: left
}

.go .top {
	background-position: 0 -33px;
	height: 22px
}

.go .feedback {
	background-position: 0 -54px;
	height: 32px
}

.go .bottom {
	background-position: 0 -88px;
	height: 22px
}

.go .top:hover {
	background-position: -38px -33px
}

.go .feedback:hover {
	background-position: -38px -54px
}

.go .bottom:hover {
	background-position: -38px -88px
}
</style>
</head>
<body>
	<input type="hidden" id="imageType" value="${imageType}">
	<c:if test="${strutsPageBean2.getCurrentPage()!=null}">
		<input type="hidden" value="${strutsPageBean2.getCurrentPage()}" id="hidden" />
	</c:if>
	<c:if test="${strutsPageBean2.getCurrentPage()==null}">
		<input type="hidden" value="${strutsPageBean2.getCurrentPage()}" id="hidden"/>
	</c:if>
	<!-- 抬头小三角-->
	<div id="img">
		<img src="images/front_img/image_triangleChange.png"
			usemap="#planetmap" alt="Planets" border="0" hidefocus="true" />
		<map name="planetmap" id="planetmap">
			<area shape="rect" coords="0,0,115,125" href="ReceptionVedio"
				target="_blank" alt="视频" />
			<area shape="rect" coords="116,0,231,125" href="receptionImage"
				target="_blank" alt="图片" />
		</map>
	</div>
	<!---- -返回顶部和底部--开始- -->
	<div class="go">
		<a title="返回顶部" class="top" href="#gotop"></a> <a
			title="如果您有意见，请反馈给我们！" class="feedback" href="#" target="_blank"></a>
		<a title="返回底部" class="bottom" href="#gobottom"></a>
	</div>

	
	<!---- -返回顶部和底部--结束- -->
	<!-- 要显示的全部内容-->
	<div class="fream" id="fream">
		<!-- 头部 -->
		<div id="head">
			<a id="gotop" name="gotop" style="float: left; width: 20px;">&nbsp;</a>
			<div class="logo">
				<img alt="" src="images/front_img/image_logo.png">
			</div>
			<%--登录 注册 留言 --%>
			<div class="headRight">
				<%--未登录之前是下面内容，登录后“登录”二字变为“欢迎XXX登录”，并且“注册”二字变为“个人主页” --%>
				<span><a href="UserInfo">登录</a>&nbsp;|&nbsp;<a href="">注册</a>&nbsp;|&nbsp;<a
					href="">给我们留言</a></span>
			</div>
		</div>
		<!-- 导航 -->
		<div id="nav">
			<div id="allNav" class="allNav">
				<span>所有分类</span>
			</div>
			<div class="search">
				<form action="" method="post">
					<input type="text"
						style="width: 240px; height: 23px; float: left; border: none;" />
					<input type="submit" class="btn searchButt" value="搜索" />
				</form>
			</div>

		</div>
		<%--end nav --%>
		<%--浮动菜单列表 --%>
		<div id="navSpanList">
			<ul>
				<c:forEach items="${sorts}" var="sorts">
					<a href="receptionImage?imageType=${sorts.getId()}"><li>${sorts.getSortName()}</li></a>
				</c:forEach>
				<!-- <a href="receptionImage?imageType=美女"><li>美女</li></a>
				<a href="receptionImage?imageType=明星"><li>明星</li></a>
				<a href="receptionImage?imageType=美女"><li>壁纸</li></a>
				<a href="receptionImage"><li>动漫</li></a>
				<a href="receptionImage"><li>宠物</li></a>
				<a href="receptionImage"><li>摄影</li></a>
				<a href="receptionImage"><li>搞笑</li></a>
				<a href="receptionImage"><li>美女</li></a>
				<a href="receptionImage"><li>设计</li></a>
				<a href="receptionImage"><li>旅游</li></a>
				<a href="receptionImage"><li>汽车</li></a>
				<a href="receptionImage"><li>植物</li></a>
				<a href="receptionImage"><li>服装</li></a>
				<a href="receptionImage"><li>贴图</li></a>
				<a href="receptionImage"><li>军事</li></a> -->
			</ul>
		</div>
		<%-- 焦点图 --%>
		<div id="focusFream" class="focusFream">
			<div id="focus">
				<ul>
				  <c:forEach items="${imagesFocus}" var="var">
					<li><a href="recpetionImageNews" target="_blank"><img
							src="${var.url }" /></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- end focusFream -->
		<%-- 所有展示内容 --%>
		<div id="allContentFream">
			<div class="mostPopularFream">
				<div class="latestInfoTop">
					<img alt=""
						src="images/front_img/image_mostPopularTitleLine.png">
					<span class="latestSL">${imageType}</span><span class="latestSR"><a
						href="#"> <!-- 更多》 -->
					</a></span>
				</div>
				<!-- end latestInfoTop -->
				<%--列表狂 --%>
				<div id="mostPopularListF" class="mostPopularListF">

					<c:forEach items="${images}" var="images">
						<div class="mostPopularListListF item">
							<a href="recpetionImageNews?imageId=${images.getId()}"
								target="_blank" title=""><img src="${images.getUrl()}"
								class="mostPopularListImg" /></a>
							<c:if test="${images.getPageUrl()!=null}">
								<%-- <span class="mostPopularS"> 来自：<a
									href="${images.getPageUrl()}" target="_blank"> <c:out
											value="${fn:substring(images.getPageUrl(),0,25)}"></c:out>

								</a>  <span style="float: right;"> <c:out
											value="${images.getResolution()}"></c:out>
								</span>
								</span>--%>

							</c:if>
						</div>
					</c:forEach>


					<%--循环的列表 --%>
					<!-- <div class="mostPopularListListF item">
								<a href="recpetionImageNews" target="_blank" title=""><img src="../../../imagesResources/222666.jpg" class="mostPopularListImg"/></a>
								<span class="mostPopularS">来自：<a href="recpetionImageNews">www.baidu.com</a><span style="float: right;">480x720</span></span>
							</div> -->
				</div>
				<%--end mostPopularListF 最新热图列表框完--%>
			</div>
			<%--ene mostPopularFream最新热图完--%>
			<%--最新热图完 --%>



			<%--搞笑开始 --%>
			<%-- 下面注释的代码先不用
					<div class="funnyFream">
						<div class="funnyInfoTop">
							<img alt="" src="../../../images/front_img/image_funnyTitleLine.png">
							<span class="funnySL">搞笑</span><span class="funnySR"><a href="#">更多》 </a></span>
						</div>
						<div class="funnyListF">
							<div class="funnyListListF">
								<img src="../../../images/front_img/image_funny/image_funny_00001.jpg" class="funnyListImg"/>
								<span class="funnyS">描述哟！！</span>
							</div>
						</div>
					</div>
					--%>
			<%--搞笑完了 --%>
		</div>
		<%-- end allContentFream --%>
	</div>
	<!-- 底部 -->
	<a name="gobottom">&nbsp;</a>
	<div id="test">
	
	</div>
</body>
</html>
