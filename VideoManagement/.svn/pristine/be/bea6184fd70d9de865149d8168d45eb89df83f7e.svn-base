<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实验室网络视频</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="视频,搞笑,娱乐,综艺,电视剧,体育,音乐">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js" charset="utf-8"></script>
<script type="text/javascript" src="js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<link rel="shortcut icon" href="images/logo.png" />
<!-- <link rel="stylesheet" type="text/css" href="css/base_css/bootstrap.css"> -->
<link rel="stylesheet" type="text/css" href="css/front_css/video_index.css">
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
	background: -webkit-gradient(linear, 20% 20%, 100% 100%, from(#27C6A2),
		to(#019C7A) );
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
	src="js/front_js/video_index.js"></script>
<!-- 滚动图的引入 -->
<script type="text/javascript"
	src="js/front_js/video_indexFocus.js"></script>
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
		document.documentElement.clientHeight-this.offsetHeight- ( parseInt(this.currentStyle.marginTop
		, 10)||200 )-(parseInt(this.currentStyle.marginBottom, 10)||0 ) ) );
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
	<!-- 抬头小三角-->
	<div id="img">
		<img src="images/front_img/triangleChange.png"
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
				<img alt="" src="images/front_img/video_logo.png">
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
		<%--浮动菜单列表   传入的时候带上参数，通过参数进来遍历（张兵） --%>
		<div id="navSpanList">
			<ul>
			    <c:forEach items="${flashTypes}" var="var">
				<a href="ReceptionVedio?param=${var.sortName}"><li>${var.sortName}</li></a>
				</c:forEach>

			</ul>
		</div>
		<%-- 焦点图 --%>
		<div id="focusFream" class="focusFream">
			<div id="focus">
			
				<ul>
				<c:forEach items="${images}" var="var">
					<li><a href="receptionVedioNews" target="_blank"><img
							src="${var.url }" /></a></li>
				</c:forEach>	
				</ul>
			</div>
		</div>
		<!-- end focusFream -->
		<%-- 所有展示内容 --%>
		<div id="allContentFream">
			<%-- =============================最新动态开始===================================== --%>
			<div class="latestInfo">
				<div class="latestInfoTop">
					<img alt=""
						src="images/front_img/video_latestTitleLine.png"> <span
						class="latestSL">最新动态</span><span class="latestSR"><a
						href="#">更多》 </a></span>
				</div>
				<!-- end latestInfoTop -->
				<!-- 列表内容 -->
				<div class="latestInfoListF">
					<!--左边  -->
					<div class="latestInfoListLeftF">
					  <c:forEach items="${lasteVideo1}" var="var">
						<div class="latestlistLeft">
							<span>◆&nbsp;
							<a href="getVedio?id=${var.id}&pageNow=1" target="_blank">
							<script type="text/javascript">
							var title1="${var.title}";
							var title=title1.substring(0,27)+".......";
							document.write(title);
							</script>
							</a>	
							</span>
						</div>
					</c:forEach>
					</div>
					<!-- end latestInfoListLeftF -->
					<div class="verticalLine">&nbsp;</div>
					<div class="latestInfoListLeftF">
					<c:forEach items="${lasteVideo2}" var="var">
						<div class="latestlistLeft">
							<span>◆&nbsp;<a href="getVedio?id=${var.id}&pageNow=1" target="_blank">
							<script type="text/javascript">
							var title1="${var.title}";
							var title=title1.substring(0,27)+".......";
							document.write(title);
							</script>
							</a></span>
						</div>
						</c:forEach>
					</div>
					<!-- end latestInfoListLeftF -->
				</div>
				<!--end latestInfoListF -->
			</div>
			<!-- end latestInfo最新动态结束 -->
			<%-- =====================娱乐节目 entertainmentFream===================--%>
			<div id="entertainmentFream">
				<div class="entertainmentInfoTop">
					<img alt=""
						src="images/front_img/video_entertainmentTitleLine.png">
					<span class="entertainmentSL">${flashType}</span><span
						class="entertainmentSR"><a href="#">更多》 </a></span>
				</div>
				<!-- end entertainmentInfoTop -->
				<%--娱乐 列表 --%>
				<div class="entertainmentContentF">
				  <c:if test="${!empty list1}">
					<c:forEach items="${list1}" var="var">
						<div class="everyPartF">
							<div class="everyPartImg">
								<a href="getVedio?id=${var.id}&pageNow=1" title="${var.title }"><img
									src="${var.flashImagePath}" /></a>
							</div>
							<div class="everyPartFont">
								<a   href="getVedio?id=${var.id}&pageNow=1" title="${var.title}">
								<script type="text/javascript">
								var title1="${var.title}";
								var title=title1.substring(0,10)+".......";
								document.write(title);
							    </script>
								</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty list1}">还没上传！！亲！不要急</c:if>
				</div>
			</div>
			<!-- 娱乐节目结束end entertainmentFream -->
			
			<%-- =========================排行榜 rankinList============================--%>

			<div class="rankinListFram">
				<div class="rankinListInfoTop">
					<img alt=""
						src="images/front_img/video_classTitleLine.png"> <span
						class="rankinListSL">排行榜</span><span class="rankinListSR"><a
						href="#">更多》 </a></span>
				</div>
				<%-- end rankinListInfoTop --%>

				<div class="rankinListListF">
					<%--列表循环  14条记录--%>
					<c:forEach items="${ byclickNum}" varStatus="status" var="var" >
					<div class="rankinListList">
						<span class="rankinListListSL">${status.count}</span>
						<span
							class="rankinListListSR">
							<a href="getVedio?id=${var.id}&pageNow=1" title="${var.title}">
							<script type="text/javascript">
								var title1="${var.title}";
								var title=title1.substring(0,20)+".......";
								document.write(title);
							 </script>
							</a></span>
					</div>
					</c:forEach>
					
				</div>
				<%--列表外部框结束 end rankinListListF --%>
			</div>
			<%--end rankinListFram --%>
		</div>
		<%-- end allContentFream --%>
	</div>
	<!-- 懒加载设置 -->
	<script type="text/javascript">
$(function(){
	$("img").lazyload({
		container: $("#entertainmentFream"),
		effect: "fadeIn"
		});
});
</script>
	<!-- 底部 -->
	<a name="gobottom">&nbsp;</a>
</body>
</html>
