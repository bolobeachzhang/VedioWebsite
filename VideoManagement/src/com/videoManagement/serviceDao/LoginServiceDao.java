/**   
* @Title: LoginServiceDao.java 
* @Package com.videoManagement.serviceDao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-20 下午4:39:12 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.serviceDao;

import com.videoManagement.basicDao.BasicDao;

/** 
 * 这个继承BasicDao里面所有的信息。同时可以自己添加一些基本的方法，进行特殊的处理
 * @ClassName: LoginServiceDao 
 * @Description: TODO(这是一个loginServiceDao) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-20 下午4:39:12 
 *  
 */
public interface LoginServiceDao extends BasicDao {
	public boolean checkUsers(String userName,String password);
}
