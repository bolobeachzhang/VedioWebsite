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
});