/**   
 * @Title: BasicDao.java 
 * @Package com.videoManagement.basicDao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-19 下午7:29:52 
 * @version V1.0   成都大学信息科学与技术学院
 */
package com.videoManagement.basicDao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: BasicDao
 * @Description: TODO(基础的dao层)
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-19 下午7:29:52
 * 
 */
public interface BasicDao {

	/**
	 * 保存一个实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return int 返回操作完成的个数
	 * */
	// 配置注解在运行时可以使用
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Object entity);

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(执行一个一个更新语句)
	 * @param @param hql hql语句
	 * @param @param id 更新一个id值为id的
	 * @return void 返回类型
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(final String hql,final Object[] params);

	/**
	 * 更新一个实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return Void
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object entity);

	/**
	 * 删除一个实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return void
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Object entity);

	/**
	 * 删除所有的对象
	 * 
	 * @param clazz
	 *            传入一个bean的实体对象
	 * @return void
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAll(Class clazz);

	/**
	 * 查询所有的对象
	 * 
	 * @param clazz
	 *            一个对象的class
	 * @return List
	 * */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List loadAll(Class clazz);

	/**
	 * 查询 返回一个list
	 * 
	 * @param hql
	 *            一个hql语句
	 * @return list
	 * */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List query(String hql);

	/**
	 * 
	* @Title: deleteByHql 
	* @Description: TODO(删除一个传入的hql语句) 
	* @param @param hql hql语句
	* @param @param params    hql语句的参数 
	* @return void    返回类型 
	*
	 */
	public void deleteByHql(final String hql,final Object[] params);
	
	/**
	 * 查询带一个参数
	 * 
	 * @param hql
	 *            一个hql语句
	 * @param param
	 *            一定Object类型的参数
	 * @return list
	 * */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List query(String hql, Object param);

	/**
	 * 
	 * @param String
	 *            hql 一个hql语句
	 * @param Object
	 *            [] params 一个object对象的数组
	 * @param @return 设定文件
	 * @return List 返回类型
	 * 
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List query(String hql, Object[] params);

	/**
	 * 分页查询
	 * 
	 * @param hql
	 *            条件查询语句
	 * @param offset
	 *            跳过记录数
	 * @param obtain
	 *            查询记录数
	 * @param params
	 *            查询参数列表
	 * @return list
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List pageQuery(String hql, int offset, int obtain, Object[] params);

	/**
	 * 获取条件查询结果的记录数 这个作用比单独用于分页更通用，比如还可以用于登录验证
	 * 
	 * @param hql
	 *            查询条件
	 * @param params
	 *            查询参数列表
	 * @return 结果集的记录数
	 */
	public int affectNumber(String hql, Object[] params);

	/**
	 * 分页查询
	 * 
	 * @param hql
	 * @param offset
	 *            表示从哪里开始取
	 * @param pageSize
	 *            表示取多少条数据
	 * @param values
	 *            表示有多少个参数
	 * @return list
	 * */
	public List findByPage2(final String hql, final int offset,
			final int pageSize, final Object[] values);

	/**
	 * 分页查询
	 * 
	 * @return list
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @param value
	 *            表示一个参数
	 * 
	 * */
	public List findByPage1(final String hql, final int offset,
			final int pageSize, final Object value);

	/**
	 * 分页查询
	 * 
	 * @param hql
	 * @param offset
	 * @param pagesize
	 * @return list
	 * */
	public List findByPage(final String hql, final int offset,
			final int pageSize);

	/**
	 * 得到总页数
	 * 
	 * @param <T>
	 * @param criterions
	 *            数组
	 * @return int
	 * */

	public <T> int findCountByCriteria(final Class<T> clazz,
			final Criterion... criterions);

	/**
	 * 很强大的分页查询
	 * 
	 * @param <T>
	 * @param clazz
	 *            一个bean的class
	 * @param propertyName
	 *            属性名(升序还是降序的属性名)
	 * @param isAsc
	 *            升序
	 * @param firstResule
	 *            从哪里开始取
	 * @param maxResult
	 *            最大的结果是
	 * @param criterions
	 *            参数数组
	 * @return List<T>
	 * 
	 * */
	public <T> List<T> findByCriteria(final Class<T> clazz,
			final String propertyName, final boolean isAsc,
			final int firstResule, final int maxResult,
			final Criterion... criterions);

	/**
	 * @Title: findById
	 * @Description: TODO(通过id查询对象)
	 * @param @param clazz
	 * @param @param id
	 * @param @return 设定文件
	 * @return Object 返回类型
	 * 
	 */
	public Object findById(final Class clazz, final Serializable id);
}
