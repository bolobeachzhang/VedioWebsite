package com.videoManagement.serviceDao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.videoManagement.basicDao.BasicDao;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.bean.Resources;
/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 抓取youku的serviceDao actoin
 * @Author 代兵
 * @Date  2013-3-27, 20:32  PM
 * @mailto 707189384@qq.com
 * 优酷抓取服务
 */
public interface VideoYoukuServiceDao extends BasicDao {
	/**
	 * 获得resource的对象
	 * @param <T>
	 * @return list对象 可以进行分页
	 */
    
    public  List<FlashVedio> getAll(Class clazz);
    /**
     *获取数据总条数 
     * 
     */
    public int insertFlashVedio(FlashVedio entity) ;
    /**
     * 得到对应的id的视频信息
     * 
     */
    public FlashVedio  getinfo(int id);
}

