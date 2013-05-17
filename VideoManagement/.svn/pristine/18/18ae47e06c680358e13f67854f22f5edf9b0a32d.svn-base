<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>seeEveryPicture</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="图片,美女,景物,汽车,动物">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="js/base_Js/jquery.lazyload.js" charset="utf-8"></script>
<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css"
	href="css/base_css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/front_css/image_seeEveryone.css">

<script language="javascript" type="text/javascript"
	src="js/front_js/image_seeEveryone.js"></script>
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
	<input type="text" value="${images.id}" id="id_href"
		style="display: none;">
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
				<span><a href="">登录</a>&nbsp;|&nbsp;<a href="">注册</a>&nbsp;|&nbsp;<a
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
				<!-- <a href="receptionImage"><li>美女</li></a>
				<a href="receptionImage"><li>明星</li></a>
				<a href="receptionImage"><li>壁纸</li></a>
				<a href="receptionImage"><li>动漫</li></a>
				<a href="receptionImage"><li>宠物</li></a>
				<a href="receptionImage"><li>摄影</li></a>
				<a href="receptionImage"><li>搞笑</li></a>
				<a href="receptionImage"><li>设计</li></a>
				<a href="receptionImage"><li>旅游</li></a>
				<a href="receptionImage"><li>汽车</li></a>
				<a href="receptionImage"><li>植物</li></a>
				<a href="receptionImage"><li>服装</li></a>
				<a href="receptionImage"><li>贴图</li></a>
				<a href="receptionImage"><li>军事</li></a> -->
				<c:forEach items="${sorts}" var="sorts">
					<a href="receptionImage?imageType=${sorts.getId()}" target="_blank"><li>${sorts.getSortName()}</li></a>
				</c:forEach>
			</ul>
		</div>
		<%--图片顶部的间隔--%>
		<div class="palyTitleF">
			<div class="palyTitle">&nbsp;</div>
		</div>
		<%--图片展示地方--%>
		<div id="playFream" class="playFream">
			<div id="palyBox">
				<div class="boxLeft">
					<div class="seeImgWindow">
						<img alt="${images.getTitle()}" src="${images.getUrl()}" />
					</div>
					<%--end seeImgWindow --%>


					<%-- 所有评论展示内容 --%>
					<div id="allContentFream">
						<div class="moviePoint">
							<img alt="喜欢"	 id="likeNum" src="images/front_img/video_playPageLike.png"
								style="float: left; margin-left: 15px; margin-top: 6px; cursor: pointer;" />
							<span style="float: left; margin-top: 22px; margin-left: 10px;" id="likepeople">
								<font style="color: red;">${images.likeNum}</font>&nbsp;人喜欢
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
									<textarea rows="" cols="" id="commentId">亲：在这里输入你的评论噢~</textarea>
									<div class="discusInputBottom">
										<span>*还可以输入250个字</span> <input
											style="margin-left: 200px; margin-bottom: 50px;"
											type="button" value="发表" id="submit">
										<!-- <img src="../../../images/front_img/video_playPagePublishOn.png"> -->
									</div>
								</div>
								<%--end discusInputText --%>
							</div>
							<%--评论列表开始 --%>
							<div class="discusListFream">
								<c:forEach items="${comments}" var="var">
									<%--循环 每一条评论列表哦 开始的--%>
									<div class="discusListEveryF">
										<div class="discusListEveryImgF">
											<img alt=""
												src="images/usersphotos/usersPhotos_00001.png" />
											<div class="discusListEveryName">${var.commentName}</div>
										</div>
										<div class="discusListEvContent">${ var.commentConent}</div>
									</div>
									<%--循环列表完了 end discusListEveryF --%>
								</c:forEach>
							</div>
							<%--end discusListFream --%>
							<div class="page" align="center" style="margin-top: 20px;">
								<c:if test="${pageCount != 0 }">
									<!-- <input type="button" value="" name="pageCount"> -->
									<input type="button" name="${pageCount}" value="首页"
										id="firstpage">
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
				<%--end boxLeft --%>
				<%--右边图片详细信息 --%>
				<div class="boxRight">
					<div class="playRightNav">
						<div class="RNavUpF">
							<div class="RNavUpFPhoF">
								<img src="images/usersphotos/usersPhotos_00001.png" />

								<c:if test="${images.getUsers().getUserName()==null}">
									<div>
										<span>作者：</span><span><font style="color: #B86262;"><b>成都大学重点工作室</b>
										</font></span>
									</div>
								</c:if>

								<c:if test="${images.getUsers().getUserName()!=null}">
									<div>
										<span>作者：</span><span><font style="color: #B86262;"><b>${images.getUsers().getUserName()}</b>
										</font></span>
									</div>
								</c:if>

							</div>

							<c:if test="${images.getResolution()!=null}">
								<div
									style="width: 100%; height: 14px; float: left; margin-top: 8px;">图片大小:&nbsp;${images.getResolution()}
									&nbsp;像素</div>
							</c:if>
							<div
								style="width: 100%; height: 14px; float: left; margin-top: 8px;">
								上传时间:&nbsp;
								<c:out value="${images.getCaptureTime()}"></c:out>
							</div>
						</div>
						<div class="RNavMiddle">
							<div>相片标签：</div>
							<div style="width: 200px; float: right; margin-bottom: 9px;">${images.getImageType()}</div>
						</div>
						<div class="RNavDown">
							<c:if test="${images.getContent()!=null}">
								<div>描述：</div>
								<div style="text-indent: 24px; text-align: justify;">
									${images.getContent()}</div>
							</c:if>
						</div>

					</div>
					<%--end playRightNav --%>
				</div>
				<%--box Right右边图片详细信息 完了 --%>
			</div>
			<%--end palyBox --%>
		</div>
		<!-- end playFream  图片展示地方完毕--%> -->

	</div>
	<%--end fream --%>

	<!-- 底部 -->
	<a name="gobottom">&nbsp;</a>
</body>
</html>
