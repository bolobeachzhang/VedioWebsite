package com.videoManagement.serviceDao;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.videoManagement.bean.*;
import com.videoManagement.basicDao.BasicDao;
/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 评论的serviceDao actoin
 * @Author 代兵
 * @Date  2013-3-27, 20:32  PM
 * @mailto 707189384@qq.com
 * 评论服务
 */

public interface CommitManService extends BasicDao {
	/**
	 * 获得commmt的对象
	 * @param <T>
	 * @return list对象 可以进行分页
	 */
    
    public  List<Object> getAll(final Class class1,
			final String propertyName, final boolean isAsc,
			final int firstResule, final int maxResult,
			final Criterion... criterions);
    /**
     * 删除单个或者多个comment对象
     */
    public int deleteSelected(final String hql,int[] ids);
    /**  查看评论对应的资源和评论的详细信息
	 * (non-Javadoc)
	 * @see com.videoManagement.serviceDao.CommitManService#getinfo(java.lang.String, int)
	 */
    public Comment  getinfo(int id);
    /**
     *获取数据总条数 
     * 
     */
    public int getTotalCount(Class clazz);
   /**
    * 插入评论
    */
    public int insertComment(Comment comment);
    /**
     * 得到更具idresource
     */
    public  Resources getResources(int id);
}
