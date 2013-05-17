package com.videoManagement.serviceImp;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.Resources;
import com.videoManagement.serviceDao.CommitManService;
@Service("CommitDaoServiceImpl")
@Transactional
@Repository
public class CommitDaoServiceImpl extends BasicServiceImp implements
		CommitManService {
    
    /**
     * 删除单个或者多个comment对象
     */
	@Override
	public int deleteSelected(String hql, int[] params) {
	    int delete_ok = 0;
		List<Comment> list = new ArrayList<Comment>();
		 //用过Id获得所有Id的实体
		for (int i = 0; i < params.length; i++) {
			Comment comment = (Comment) getHibernateTemplate().load(Comment.class,(Serializable) params[i]);
			list.add(comment);
		}
		//循环遍历删除该对象
		for (Comment comment : list) {
			this.delete(comment);
			delete_ok++;
		}   
		return delete_ok;
	}
	/*
	 * 查看评论对应的资源和评论的详细信息
	 * (non-Javadoc)
	 * @see com.videoManagement.serviceDao.CommitManService#getinfo(java.lang.String, int)
	 */
	@Override
	public Comment getinfo(int id) {
		Comment comment = (Comment) getHibernateTemplate().get(Comment.class, id);
		return comment;
		
	}
	
	/**| 
     * 查看所有的评论并进行分页
     */
	@Override
	public List<Object> getAll(Class clazz, String propertyName,
			boolean isAsc, int firstResule, int maxResult,
			Criterion... criterions) {
		List<Object> list = this.findByCriteria(clazz, propertyName, isAsc, firstResule, maxResult, criterions);
		return list;
	}
	/*
	* <p>Title: getTotalCount</p> 
	* <p>Description: </p> 
	* @param clazz
	* @return 
	* @see com.videoManagement.serviceDao.CommitManService#getTotalCount(java.lang.Class) 
	*/
	@Override
	public int getTotalCount(Class clazz) {
		int totalCount = this.findCountByCriteria(Comment.class, null);
		return totalCount;
	}
	@Override
	public int insertComment(Comment comment) {
		int num = this.save(comment);
		return num;
	}
	@Override
	public Resources getResources(int id) {
		return (Resources) this.getHibernateTemplate().get(Resources.class, id);
	}

	
    

}
