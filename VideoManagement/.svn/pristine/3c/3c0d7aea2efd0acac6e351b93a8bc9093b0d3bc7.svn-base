<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/behind_css/behind.css">
<link type="text/css" rel="stylesheet" href="css/base_css/bootstrap.css">
<script type="text/javascript" src="js/base_Js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/base_Js/bootstrap-collapse.js"></script>
<script type="text/javascript" src="js/base_Js/bootstrap-transition.js"></script>
<!-- <script type="text/javascript" src="../../js/behind/LabIntroduceMain.js"></script> -->
<title>后台管理</title>
<script type="text/javascript">

$(function(){
    var log = function(s){
        window.console && console.log(s);
    	};
    $(".accordion-body").on("show", function(){
        log("show");
    }).on("shown", function(){
        log("shown");
    }).on("hide", function(){
        log("hide");
    }).on("hidden", function(){
        log("hidden");
    });
	/**
	 * 左侧导航的事件处理
	 * 
	 */
/* 重构框架start */
 		
 		$newResourceMain = "newResourceMain";
 		$uploadResourceMain = "uploadResourceMain";
		$existResourceMain = "existResourceMain";
		$oldResourceMain = "oldResourceMain";
		
	/* end */

	$pageID = $("#right_content");//得到载入页面的ID
	/**下面定义不同的子页面链接searchManagement**/
	$menuURIOne = "searchManagement";
	$menuURLOne11="searchManagement";
	$menuURLOne12 = "pictureSeatchAction";
	$menuURITwo11 = "vedio";
	$menuURITwo12 = "imagesTest";
	$menuURITwo13 = "AudioVedio";
	$menuURITwo14 = "audioImage";
	$menuURITwo21 = "AdminUploadResource";
	$menuURITwo22 = "UserUploadResource"; 
	$menuURITwo31 = "uploadImages";
	$menuURITwo32 = "uploadVedio";
	$menuURITwo34 = "manageUserUploadeImages";
	$menuURITwo35 = "manageUserUploadeFlash";
	$menuURITwo36 = "addFlashmsg";
	$menuURITwo33 = "comment?offset=0&pageNow=1";
	$menuURITwo4  = "oldRes";
	$menuURIThree = "liuyanManagment";
	$menuURIFour  = "user_vip?offset=0&pageNow=1&type=1";
	$menuURIFour1 ="user_vip?offset=0&pageNow=1&type=1";
	$menuURIFour2 ="register?offset=0&pageNow=1&type=0";
	$menuURIFive1 ="focusImage";
	/*默认加载页面 */
	//$pageID.css("src",$menuURIOne);
	//$pageID.load($menuURIOne);
	/*一级菜单点击默认页面  first*/
	$(".first").each(function(index){
		$(this).click(function(){
			if(index==0){
				  $pageID.attr("src",$menuURIOne);
			}
			if(index==1){
				$pageID.attr("src",$newResourceMain);
			}
			if(index==2){
				$pageID.attr("src",$menuURIThree);
			}
			if(index==3){
				$pageID.attr("src",$menuURIFour1);
			}
			if(index==4){
				$pageID.attr("src",$menuURIFive1);
			}
		});
			
	}); 
	/**资源管理中的点击事件**/
	/*二级菜单的点击事件 sourceSecondMenu*/
	$(".sourceSecondMenu").each(function(index){
		$(this).click(function(){
			
			if(index==0){
				$pageID.attr("src",$menuURIOne);
			}
			if(index==1){
				$pageID.attr("src",$menuURITwo21);
			}
		});
	});
	
	/*搜索管理*/
$("#collapseOne a").each(function(index){
		$(this).click(function(){
			if(index == 0){
				
				$pageID.attr("src",$menuURLOne11);
			}
			if(index == 1){
				$pageID.attr("src",$menuURLOne12);
			}
		});
	});
		/*重构后的最新资源管理  */
		$("#collapseTwo a").each(function(index){
		
		$(this).click(function(){
			if(index == 0){
				$pageID.attr("src",$newResourceMain);
			}
			if(index == 1){
				$pageID.attr("src",$uploadResourceMain);
			}	
			if(index ==2){
				$pageID.attr("src",$existResourceMain);
			}
			if(index ==3){
				$pageID.attr("src",$oldResourceMain);
			}
		});
	});
	/* 重构后的最新资源管理end */
	/*用户管理 $menuURIFour1*/
	$("#collapseUserManger a").each(function(index){
		
		$(this).click(function(){
			if(index == 0){
				$pageID.attr("src",$menuURIFour1);
			}
			if(index == 1){
				$pageID.attr("src",$menuURIFour2);
			}
		});
	});
});


</script>
</head>
<body>
	<div id="head">
		<div id="top_title">
			<span class="title_left">后台管理</span> <span class="title_right">管理员<label
				style="display: inline; color: #ff9600">XXX</label>欢迎登陆 | <a
				href="#">登出</a></span>
		</div>
	</div>
	<div id="content" class="row">
		<div class="span3" style="width: 200px;">
<!---------------------------------- part-left ------------------------------->
<!----------搜索策略管理  -->
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle Btn first" id="searchManagement" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> 制定搜索策略 
						<span class="caret" style="margin-top: 8px;"></span>
						</a>
					</div>
					
					<div id="collapseOne" class="accordion-body collapse" style="height: 0px;">
							<div class="accordion-inner"><a href="#">视频抓取</a></div>
							<div class="accordion-inner"><a href="#">图片抓取</a></div>
					</div>
				</div>
<!----------资源管理  -->
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle Btn first" id="sourceManage" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo"> 资源管理
							<span class="caret" style="margin-top: 8px;"></span></a><!--bootstrap.css中的caret增加了一个向右浮动的属性 -->
					</div>
					<div id="collapseTwo" class="accordion-body collapse" style="height: 0px;">
						<div class="accordion-inner"><a href=#>抓取资源管理</a></div>
						<div class="accordion-inner"><a href=#>上传资源管理</a></div>
						<div class="accordion-inner"><a href=#>已有资源管理</a></div>
						<div class="accordion-inner"><a href=#>失效资源管理</a></div>
					</div>
				</div>
<!----------留言管理  -->
				<div class="accordion-group"> 
					<div class="accordion-heading" id="collapseThree1">
						<a class="accordion-toggle Btn first" data-toggle="collapse" data-parent="#accordion2" href="#"> 留言管理 </a>
					</div>
				</div>
<!-----------用户管理  -->
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle Btn first" data-toggle="collapse" data-parent="#accordion2" href="#collapseUserManger"> 用户管理 
							<span class="caret" style="margin-top: 8px;"></span>
						</a>
					</div>
					<div id="collapseUserManger" class="accordion-body collapse" style="height: 0px;">
							<div class="accordion-inner"><a href="#">会员管理</a></div>
							<div class="accordion-inner"><a href="#">注册人员管理</a></div>
					</div>
				</div>
				<!-- 焦点图管理 -->
				<div class="accordion-group"> 
					<div class="accordion-heading" >
						<a class="accordion-toggle Btn first" data-toggle="collapse" data-parent="#accordion2" href="#">焦点图管理</a>
					</div>
				</div>
			</div>
			<!------------------------------END  --------------------------------->
		</div>
<!---------------------------------- part-right ------------------#bae1ff------------->
			<div class="span9 part-right" style="background-color:#fff;">
			<iframe class="ifreamClass" style="border: none;scrolling:no;width: 780px; background-color: #fff" id="right_content" src="searchManagement"></iframe>	
			</div>  
		
		
	</div>
</body>
</html>