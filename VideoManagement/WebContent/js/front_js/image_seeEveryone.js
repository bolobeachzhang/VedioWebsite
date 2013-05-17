$(document).ready(function(){
    var timeOut;              //定义防止用户无意间的操作
    $imgNode = $("#img");        //小三角的ID
    $navID = $("#nav");      //导航的Id
    /*---------------*/
    $navSpanListID =  $("#navSpanList"); //得到浮动列表
    /*---------------*/
    $imgWidth = $imgNode.width(); //图片的宽度
    $imgHeight = $imgNode.height();   //图片的高度
    $browserWidth = $(window).width();  //  浏览器的窗口的宽度
    $navTop = 90;     //导航距顶部的高度
    $imgHideHeight =  95; //小三角隐藏的高度
    $scrollLeft = $(window).scrollLeft();  //
    var center = $scrollLeft + ($browserWidth - $imgWidth) / 2;   //图片的中心
    $(".focusFream").css("width",$browserWidth);
    //调用加载小三角的
    loadTopImg();
    //给导航设置初始位置 
    $navID.css({position:"fixed",top:$navTop});
    /*------给浮动列表设置初始位置---------*/
    $navSpanListID.css({position:"fixed",top:$navTop+30});
    /*---------------*/
     //让整体在打开的时候我们就让他伸缩在上面
     $(window).scroll(function(){
         $scrollTop = $(window).scrollTop();
         //如果滚动了 $navTop 后让导航定着
         if($scrollTop > $navTop){
            $navID.css("position","fixed").css({backgroundColor:"blue",top:0});
            $navSpanListID.css({position:"fixed",top:30});
         } else{
            if($scrollTop <= 30){
            	//loadTopImg();
            }
            $navID.css({position:"fixed"}).animate({opacity:1,top:$navTop},10);
            $navSpanListID.css({position:"fixed"}).animate({opacity:1,top:$navTop+30},10);
         }
     });
    //鼠标移向和离开小箭头的事件
    $imgNode.hover(function(){
        timeOut =  setTimeout(function(){
            $imgNode.animate({opacity: 1,top: 0,left:center});
        },200);
    },function(){
        $imgNode.animate({opacity: 1,top: -$imgHideHeight,left:center},500);
        clearTimeout(timeOut);
    });
    //加载小三角的方法
    function loadTopImg(){
        $imgNode.css("position","fixed").css({top:-$imgHideHeight,left:center}).animate({opacity:1,top:0,left:center},1000).animate({opacity:1,top:-$imgHideHeight,left:center},1000);
    }
    //内容（allContentFream）相对所有分类的距离的样式 
    //$allNavWidth = $("#allNav").width();
    //$("#allContentFream").css("left","242 + $browserWidth*0.7");
    //点击所有分类显示和隐藏浮动菜单
    $("#allNav").click(function(){
    	$("#navSpanList").toggle(600);
    });
    /**
     * ----浮动菜单事件-----*/
    $("#navSpanList li").each(function(index){
         $(this).click(function(){
             $("#navSpanList li").removeClass("navSpanListClickOp") ;
             $(this).addClass("navSpanListClickOp");
         });
    });
/***
 * 最新热图中鼠标移向图片后产生的效果
 * */
    //得到最新热图框架的id
    $mostPopularListFID = $("#mostPopularListF");
    $("#mostPopularListF .mostPopularListListF").each(function(index){
    	$(this).hover(function(){
    		$(this).css("background-color","#FF9A0A");
    		$(this).children(".mostPopularS").css("opacity","0.8");
    	},function(){
    		$(this).css("background-color","#fff");
    		$(this).children(".mostPopularS").css("opacity","0.5");
    	});
    	
    });
});




/**
 * 提交评论
 */
$(document).ready(function(){
	$('#submit').click(function(){
	//得到评论的内容
	var textarea = $('#commentId').val();
	if(textarea == ""){
		alert("亲，给点评价吧 出来混 不容易！！！");
	}else{
	//alert(textarea);
	 var id = $("#id_href").val();
	 //alert(id);
	//用ajax提交到后台
	 $.ajax({
	        url : "insertComment",
	        type: "POST",
	        data : "CommentText=" +textarea+"&id="+id,
	        beforeSend:function(XMLHttpRequest){
	              $("#comment_loading").show();
	              $("#commentId").hide();
	         },
	        success : function(data) {
	        	//alert(data);
	        	if(data > 0){
	        		//表示评论成功
	        		//alert("亲，你评论成功！！");
	        		//c插入节点
	        		$("#comment_loading").slideUp();
	        		$("#commentId").val('亲，给点评价吧 出来混 不容易！！！');
	        		$("#commentId").show();
	        		var text='<div class="discusListEveryF"><div class="discusListEveryImgF"><img alt="" src="images/usersphotos/usersPhotos_00001.png"/><div class="discusListEveryName">就斤斤计较</div></div><div class="discusListEvContent">'+textarea+'</div></div>';
	        		$('.discusListFream').append(text);
	        	}else{
	        		alert("亲，评论失败！！");
	        	}
	        	
	        }
	    });
	}
	}) ;

});




//首页
$(document).ready(function(){
	//资源的id
	var id = $("#id_href").val();
	//offset
	var offset=$('#lastOne').attr('name');
	//pageNow
	var pageNow=$('#pageNow').attr('name');
    $('#firstpage').click(function(){
    	alert(pageNow);
    	 $.ajax({
    		url : "pageDo",
    		cache: true,
 	        type: "POST",
 	        data : "id=" +id+"&offset="+offset+"&pageNow="+pageNow,
 	        success : function(data) {        	
 	        	//alert('竟来了！！');
 	        	$('.discusListFream').empty();	
 	        	$('.page').empty();	
	        	//alert(data);
	        	$(data).appendTo('.discusListFream');
	        }
    	});
    });
});

//尾页
$(document).ready(function(){
	//资源的id
	var id = $("#id_href").val();
	//尾页
	var pageCount = $('#firstpage').attr('name');
	//offset
	var offset=$('#lastOne').attr('name');
	//pageNow
	var pageNow=$('#pageNow').attr('name');

    $('#lastOne').click(function(){
    	 //alert(pageNow);
    	 $.ajax({
    		url : "pageDo",
    		cache: true,
 	        type: "POST",
 	        data : "id=" +id+"&offset="+(10*(pageCount-1))+"&pageNow="+pageCount,
 	        success : function(data) {        	
 	        	$('.discusListFream').empty();	
 	        	$('.page').empty();	
	        	$(data).appendTo('.discusListFream');
	        }
    	});
    });
});



//下一页
$(document).ready(function(){
	var id = $("#id_href").val();	
	var offset=$('#lastOne').attr('name');
	offset=parseInt(offset);
	var pageNow=$('#pageNow').attr('name');
	pageNow=parseInt(pageNow);
	pageNow=pageNow+1;
	$('#nextPage').click(function(){
		//alert(pageNow);
		$.ajax({
			url : "pageDo",
			cache: true,
			type: "POST",
			data : "id=" +id+"&offset="+(offset+10)+"&pageNow="+pageNow,
			success : function(data) {        	
				$('.discusListFream').empty();	
				$('.page').empty();	
				$(data).appendTo('.discusListFream');
			}
		});
	});
});


//增加喜欢resource的次数  病虫后台返回数据
$(document).ready(function(){
	//取得当前资源的Id
	var id = $("#id_href").val();
	$('#likeNum').click(function(){	
		//alert("ascvas");
		$.ajax({
			url : "addLikeNum",
			cache: true,
			type: "POST",
			data : "id=" +id,
			success : function(data) {
				$('#likepeople').empty();
				$('#likepeople').append('<font style="color: red;" >'+data+'</font>&nbsp;人喜欢');
			}
		});
	});
});