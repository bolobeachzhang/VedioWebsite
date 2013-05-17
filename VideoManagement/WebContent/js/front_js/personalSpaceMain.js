$(function() {
	 $pageID = $("#right_content");//得到载入页面的ID
	//全部请求
	$menuOne = "personaldata";
	$menuOne1 = "personaldata";
	$menuOne2 = "photoSet";
	$menuOne3 = "passwordSet";
	$menuTwo = "openVIP";
	$menuThree = "leaveMessageBox";
	//一级菜单处理
	$(".main > a").each(function(index){
		$(this).click(function(){
			//找到主菜单项对应的子菜单项
			var ulNode = $(this).next("ul");
			ulNode.slideToggle();
			//changeIcon($(this));
			switch(index){
			case 0: $pageID.attr("src",$menuOne);break;
			case 1: $pageID.attr("src",$menuTwo);break;
			case 2: $pageID.attr("src",$menuThree);break;
		}
		});
	});
	//二级菜单处理
	$mainUlLi = $(".main ul li");
	$mainUlLi.each(function(index){
		$(this).click(function(){
			$mainUlLi.css("background-color","#383838");
			switch(index){
				case 0: $pageID.attr("src",$menuOne1);break;
				case 1: $pageID.attr("src",$menuOne2);break;
				case 2: $pageID.attr("src",$menuOne3);break;
			}
		});
	});
	$("#cont1_3 .main").each(function(index){
		$(this).click(function(){
			$("#cont1_3 .main").css("background-color","#383838");
			$(this).css("background-color","#FFB100");
		});
	});
});
