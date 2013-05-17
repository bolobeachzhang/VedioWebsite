/**   
 * @Title: BasicServiceImp.java 
 * @Package com.videoManagement.basicDao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-19 下午8:04:06 
 * @version V1.0   成都大学信息科学与技术学院
 */
package com.videoManagement.basicDao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: BasicServiceImp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-19 下午8:04:06
 * 
 */
@Repository
public class BasicServiceImp extends HibernateDaoSupport implements BasicDao {
	private static Log log = LogFactory.getLog(BasicServiceImp.class);

	public int save(Object entity) {
		int i = 0;
		try {
			i = (Integer) getHibernateTemplate().save(entity);
			log.info("保存" + entity.getClass().getName() + "成功");
		} catch (Exception e) {
			log.info("保存" + entity.getClass().getName() + "失败");
			e.printStackTrace();
		}
		return i;
	}

	public void update(Object entity) {
		try {
			this.getHibernateTemplate().update(entity);
			log.info("更新" + entity.getClass().getName() + "成功");
		} catch (Exception e) {
			log.info("更新" + entity.getClass().getName() + "失败");
			e.printStackTrace();
		}
	}

	public void delete(Object entity) {
		try {
			this.getHibernateTemplate().delete(entity);
			log.info("删除" + entity + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAll(Class clazz) {
		try {
			List list = loadAll(clazz);
			this.getHibernateTemplate().deleteAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List loadAll(Class clazz) {
		List list = null;
		try {
			list = this.getHibernateTemplate().loadAll(clazz);
			log.info("加载" + clazz.getName() + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List query(String hql) {
		List list = null;
		try {
			list = this.getHibernateTemplate().find(hql);
			log.info("执行" + hql + "语句成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List query(String hql, Object param) {
		List list = null;
		try {
			list = this.getHibernateTemplate().find(hql, param);
			log.info("执行" + hql + "带参" + param + "语句成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List query(String hql, Object[] params) {
		List list = null;
		try {
			list = this.getHibernateTemplate().find(hql, params);
			log.info("执行" + hql + "带参" + params + "语句成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List pageQuery(final String hql, final int offset, final int obtain,
			final Object[] params) {
		List result = (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (params != null) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						List list = query.setFirstResult(offset)
								.setMaxResults(obtain).list();
						return list;
					}
				});
		return result;
	}

	public int affectNumber(final String hql, final Object[] params) {
		int affectNumber = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (params != null) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.list().size();
					}
				});
		return affectNumber;
	}

	public List findByPage2(final String hql, final int offset,
			final int pageSize, final Object[] values) {
		List list = (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
					}
				});
		return list;
	}

	public List findByPage1(final String hql, final int offset,
			final int pageSize, final Object value) {
		List list = (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (value != null) {
							query.setParameter(0, value);
						}
						return query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
					}
				});
		return list;
	}

	public List findByPage(final String hql, final int offset,
			final int pageSize) {
		List list = (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
					}
				});
		return list;
	}

	public <T> int findCountByCriteria(final Class<T> clazz,
			final Criterion... criterions) {
		int totleCounts = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(clazz);
						if (criterions != null) {
							for (Criterion criterion : criterions) {
								criteria.add(criterion);
							}
						}
						return criteria.list().size();
					}
				});
		return totleCounts;
	}

	public <T> List<T> findByCriteria(final Class<T> clazz,
			final String propertyName, final boolean isAsc,
			final int firstResule, final int maxResult,
			final Criterion... criterions) {
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(clazz);
						if (criterions != null) {
							for (Criterion criterion : criterions) {
								criteria.add(criterion);
							}
						}
						if (null != propertyName) {
							// 如果为真的话那么我们就执行升序
							if (isAsc) {
								criteria.addOrder(Order.asc(propertyName));
							} else {
								criteria.addOrder(Order.desc(propertyName));
							}
						}
						// 用于分页
						if (maxResult != 0) {
							criteria.setFirstResult(firstResule);
							criteria.setMaxResults(maxResult);
						}
						final List<T> list = criteria.list();
						return list;
					}
				});
		return list;
	}

	public Object findById(final Class clazz, final Serializable id) {
		return getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Object object = session.get(clazz, id);
						log.info("查询参数1为" + clazz.getName() + "参数2为" + id
								+ "成功");
						return object;
					}
				});
	}
	public void update(final String hql,final Object[] params) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				if(params.length !=0){
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.executeUpdate();
			}
		});
	}
	public void deleteByHql(final String hql, final Object[] params) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				if (params!= null) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i,params[i]);
					}
				}
				return query.executeUpdate();
			}
		});
	}
}
