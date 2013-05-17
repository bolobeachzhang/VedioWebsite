package com.videoManagement.serviceDao;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.videoManagement.basicDao.BasicDao;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.Users;
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

public interface UserServiceDao extends BasicDao {
	/**
	 * 获得commmt的对象
	 * @param <T>
	 * @return list对象 可以进行分页
	 */
    
    public  List<Users> getAll(final String hql, final int offset, final int obtain,final Object[] params);
    /**
     * 删除单个或者多个users对象
     */
    public int deleteSelected(final String hql,int[] ids);
    /**  查看user对应的资源和评论的详细信息
	 * (non-Javadoc)
	 * @see com.videoManagement.serviceDao.CommitManService#getinfo(java.lang.String, int)
	 */
    public Users  getinfo(int id);
    /**
     *获取users数据总条数和
     * 
     */
    public int getTotalCount( final String hql,Object[] params);
    /**
     * 修改users的权限
     */
    public void modifyAuthority(final String hql,Object[] params);
}

