VedioWebsite
===================================
  VedioWebsite是南昌大学的视频和图片网站，可以从本地上传图片或者视频(10G),也可以随时从互联网进行抓取视频或者图片，进行一个实时的更新。<br />
  
关于本项目所采用的技术
 -----------------------------------
  1. MVC:传统的MVC模式来进行开发（struts+hibernate+spring）<br />
  2. Database:sqlserver 2008 <br />
  3. IDE :eclipse <br/>
  4. test:junit(4.0) <br/>
  5. 采用google reach api
  6. 采用httpclient技术抓取

目录结构
 -----------------------------------

    com.videoManagement.action -- 表示属于action层用来作为控制器
    com.videoManagement.basicDao --表示基本的数据操作dao层和实现类层，其他dao层或者dao层的实现层继承它即可完成，从而达到高度的封装。
    com.videoManagement.bean -- javabean层，就是一个javaBean，主要功能是用来存储数据
    com.videoManagement.serviceDao -- service接口层,用来声明service层的方法主体
    com.videoManagement.serviceImp -- service实现类层，用来实现service里面主体的方法
    com.videoManagement.util -- util层，是常用的一些工具类，比如说加密，以及验证码and more 
    com.videoManagement.videoHtml --是用来抓取网站html页面资料
    com.videoManagement.getYouku --抓取优酷或者土豆视频
    com.videoManagemen.picture -- 抓取图片
    com.videoManagement.longThread --使用线程进行定时的抓取
    下面就是一些基本的配置，源码里面有详细的介绍，在这里我就不啰嗦了。

### 链接
1.[点击这里你可以链接到www.google.com](http://www.google.com)<br />
2.[点击这里你可以链接到我的博客](http://bolobeach.blogspot.com/)<br />
3.[点击这里下载源码(liunx,windows)](http://bolobeachzhang.github.io/studioWebsite/)<br/>
4.如果有宝贵的意见请给我发邮件(bolobeach@gmail.com)<br/>

###主界面展示
![github](https://raw.github.com/bolobeachzhang/VedioWebsite/master/images/main.jpg "主界面")

###视频界面展示
![github](https://raw.github.com/bolobeachzhang/VedioWebsite/master/images/vedion.jpg "视频界面")
