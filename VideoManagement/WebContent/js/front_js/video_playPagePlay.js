$(document).ready(function(){
	//对相关视频栏的事件 playRightNavListF
	$playRightNavListEveryF = $("#playRightNavListF .playRightNavListEveryF");
	$playRightNavListEveryF.each(function(index){
		$(this).hover(function(){
			$(this).addClass("navHoverOp");
		},function(){
			$playRightNavListEveryF.removeClass("navHoverOp");
		});
		$(this).click(function(){//navHoverOp
			$playRightNavListEveryF.removeClass("playRightNavListEveryFOption");
			$(this).addClass("playRightNavListEveryFOption");
		});
	});
	
	//对评论列表的显示和隐藏的事件
	$discussCommentsOkID = $("#discussCommentsOk");//点击评论的ID 
	$discusFreamID = $("#discusFream");
	$discussCommentsOkOnImgURl = 'url(../../images/front_img/video_playPageCommentsOn.png))';//点击评论的图片的url
	$discussCommentsOkDownImgURl = 'url(../../images/front_img/video_playPageCommentsDown.png)';
	$discusFreamID.hide();
	$discussCommentsOkID.hover(function(){
		$(this).css('background',$discussCommentsOkDownImgURl);
	},function(){
		$(this).css('background',$discussCommentsOkOnImgURl);
	});
	$discussCommentsOkID.click(function(){
		$(this).css('background',$discussCommentsOkDownImgURl);
		$discusFreamID.show();
	});
});



/**
 * 加载播放器
 */
$(document).ready(function(){
    var id = $("#id_href").val();
    $.ajax({
        url : "getVedioPlayer",
        data : "id=" + id,
        success : function(data) {
        	/*alert(id);*/
        	var str ="flashResources";
        	var t=data.indexOf(str);
        	/*alert(t);*/
        	//找到了
        	if(t !=-1){
            $('<embed id="videopalyer" src="jsp/front_JSP/video_jsp/player.swf" allowfullscreen="true" flashvars='+data+' width="660" height="530"/>').appendTo("#playWindow");
        	}else{
        	//alert("ascas");
        	var url='<embed src='+data+' type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" wmode="opaque" width="660" height="530" flashvars="playerId=76071766572662785&amp;apiDomain=api.video.smgbb.cn&amp;omsid=&amp;xmlid=vxml/2013-04-02/2684012">';
        	$(url).appendTo("#playWindow");
        	}
        	
        }
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
    	 alert(pageNow);
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
		alert(pageNow);
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

