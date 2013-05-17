<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${flashVideo1.title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="视频,搞笑,娱乐,综艺,电视剧,体育,音乐">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css"
	href="css/base_css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/front_css/video_playPage.css">

<script language="javascript" type="text/javascript"
	src="js/front_js/video_playPage.js"></script>
<!-- 播放区域的引入 -->
<script type="text/javascript"
	src="js/front_js/video_playPagePlay.js"></script>

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
		<input type="text" value="${flashVideo1.id}" id="id_href"
			style="display: none;"> <img
			src="images/front_img/triangleChange.png"
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
		<%--浮动菜单列表 --%>
		<div id="navSpanList">
			<ul>
				<c:forEach items="${flashTypes}" var="var">
					<a href="ReceptionVedio?param=${var.sortName}">
						<li>${var.sortName}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<%--播放的位置与内容的标题 --%>
		<div class="palyTitleF">
			<div class="palyTitle">
				<span> ${flashVideo1.flashType} </span>&nbsp;>&nbsp;<span>${fn:substring(flashVideo1.title,0,35)}........</span>
			</div>
		</div>
		<%--视屏播放地方--%>
		<div id="playFream" class="playFream">
			<div id="palyBox">
				<div class="playWindow" id="playWindow"></div>
				<%--end playWindow --%>
				<div class="playRightNav">
					<div class="playRightNavUpTitle">相关视频</div>
					<div id="playRightNavListF" class="playRightNavListF">
						<%--循环的列表  注意只有  4 条 --%>
						<div id="playRightNavListEveryF" class="playRightNavListEveryF">
							<div class="playRightNavListEveryImg">
								<a href="#"><img alt="" src="${flashVideo1.flashImagePath}" /></a>
							</div>
							<div class="playRightNavListEveryRF">
								<div class="playRightNavListEveryRT">
									★<a href="receptionVedioNews" title="${flashVideo1.title}">${flashVideo1.title}</a>
								</div>
								<div class="playRightNavListEveryRTimes">播放:${flashVideo1.clickNums}次</div>
							</div>
						</div>
						<%--end playRightNavListEveryF --%>
						<%--循环的列表  注意只有  4 条 --%>
						<div class="playRightNavListEveryF">
							<div class="playRightNavListEveryImg">
								<a href="getVedio?id=${flashVideo2.id}"><img alt=""
									src="${flashVideo2.flashImagePath}" /></a>
							</div>
							<div class="playRightNavListEveryRF">
								<div class="playRightNavListEveryRT">
									★<a href="receptionVedioNews" title="${flashVideo2.title}">${flashVideo2.title}</a>
								</div>
								<div class="playRightNavListEveryRTimes">播放:${flashVideo2.clickNums}次</div>
							</div>
						</div>
						<%--end playRightNavListEveryF --%>
						<%--循环的列表  注意只有  4 条 --%>
						<div class="playRightNavListEveryF">
							<div class="playRightNavListEveryImg">
								<a href="getVedio?id=${flashVideo3.id}"><img alt=""
									src="${flashVideo3.flashImagePath}" /></a>
							</div>
							<div class="playRightNavListEveryRF">
								<div class="playRightNavListEveryRT">
									★<a href="receptionVedioNews" title="${flashVideo3.title}">${flashVideo3.title}</a>
								</div>
								<div class="playRightNavListEveryRTimes">播放:${flashVideo3.clickNums}次</div>
							</div>
						</div>
						<%--end playRightNavListEveryF --%>
						<%--循环的列表  注意只有  4 条 --%>
						<div class="playRightNavListEveryF">
							<div class="playRightNavListEveryImg">
								<a href="getVedio?id=${flashVideo4.id}"><img alt=""
									src="${flashVideo4.flashImagePath}" /></a>
							</div>
							<div class="playRightNavListEveryRF">
								<div class="playRightNavListEveryRT">
									★<a href="receptionVedioNews" title="${flashVideo4.title}">${flashVideo4.title}</a>
								</div>
								<div class="playRightNavListEveryRTimes">播放:${flashVideo4.clickNums}次</div>
							</div>
						</div>
						<%--end playRightNavListEveryF --%>

					</div>
					<%--end playRightNavListF --%>
				</div>
				<%--end playRightNav --%>
			</div>
			<%--end palyBox --%>
		</div>
		<!-- end playFream  视屏播放完毕--%> -->
		<%-- 所有评论展示内容 --%>
		<div id="allContentFream">
			<div class="moviePoint">
				<img alt="喜欢" id="likeNum" src="images/front_img/video_playPageLike.png"
					style="float: left; margin-left: 15px; margin-top: 6px; cursor: pointer;" />
				<span style="float: left; margin-top: 22px; margin-left: 10px;" id="likepeople">
					<font style="color: red;" >${flashVideo1.likeNum}</font>&nbsp;人喜欢
				</span> <img id="discussCommentsOk" alt=""
					src="images/front_img/video_playPageCommentsOn.png"
					style="float: right; margin-right: 15px; margin-top: 10px; cursor: pointer;">
			</div>
			<%-- =============================品论开始===================================== --%>
			<div id="discusFream" class="discusFream">
				<%--发表哦 --%>
				<div class="discusInput">
					<div class="discusInputImgF">
						<img alt=""
							src="images/usersphotos/usersPhotos_00001.png" />
						<div class="discusInputName">当前登录的人</div>
					</div>
					<div class="discusInputText">
						<form action="#" method="post">
							<div id="discusInputTextOut">
								<img alt="" id="comment_loading" style="display: none;"
									src="images/front_img/video_img-loading.gif">
								<textarea rows="" cols="" id="commentId">
									 亲：在这里输入你的评论噢~
									</textarea>
							</div>
							<div class="discusInputBottom">
								<span>*还可以输入250个字</span> <input
									style="margin-left: 200px; margin-bottom: 50px;" type="button"
									value="发表" id="submit">
								<!-- <img src="../../../images/front_img/video_playPagePublishOn.png"> -->
							</div>
						</form>
					</div>
					<%--end discusInputText --%>
				</div>
				<%--评论列表开始 --%>
				<div class="discusListFream">
					<c:if test="${ !empty comments }">
						<c:forEach items="${comments}" var="var">
							<%--循环 每一条评论列表哦 开始的--%>
							<div class="discusListEveryF">
								<div class="discusListEveryImgF">
									<img alt="亲，喜欢就点击一下！！谢谢支持"
										src="images/usersphotos/usersPhotos_00001.png" />
									<div class="discusListEveryName">${ var.commentName}</div>
								</div>
								<div class="discusListEvContent">${ var.commentConent}</div>
							</div>
							<%--循环列表完了 end discusListEveryF --%>
						</c:forEach>
					</c:if>
					<%-- <c:if test="${empty comments }">亲，暂时还没评论，需要你评论哦！！</c:if>	 --%>
				</div>
				<%--end discusListFream --%>
				<div class="page" align="center" style="margin-top: 20px;">

					<c:if test="${pageCount != 0 }">
						<!-- <input type="button" value="" name="pageCount"> -->
						<input type="button" name="${pageCount}" value="首页" id="firstpage">
						<input type="button" name="${offset}" value="尾页" id="lastOne">
						<input type="button" name="${pageNow}" style="display: none;"
							id="pageNow">
					</c:if>
					<c:if test="${pageNow<pageCount}">
						<input type="button" name="nextPage" value="下一页" id="nextPage">
					</c:if>
					<c:if test="${ pageNow>1 && pageNow<=pageCount }">
						<input type="button" name="Uppage" value="上一页" id="Uppage">
					</c:if>
				</div>
			</div>
			<%--end discusFream --%>
		</div>
		<%--整体评论完  end allContentFream --%>

	</div>
	<%--end fream --%>
	<!-- 底部 -->
	<a name="gobottom">&nbsp;</a>
</body>
</html>
