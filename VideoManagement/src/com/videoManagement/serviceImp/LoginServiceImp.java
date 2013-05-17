/**   
* @Title: LoginServiceImp.java 
* @Package com.videoManagement.serviceImp 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-20 下午4:41:06 
* @version V1.0   成都大学信息科学与技术学院
*/
package com.videoManagement.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.serviceDao.LoginServiceDao;

/** 
 * @ClassName: LoginServiceImp 
 * @Description: TODO(用来处理登录的时候的页面) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-20 下午4:41:06 
 *  
 */
@Service("loginServiceImp")
@Transactional
public class LoginServiceImp extends BasicServiceImp implements LoginServiceDao {
	public boolean checkUsers(String userName,String password){
		String hql = "from Users where userName=? and passWord=?";
		System.out.println(hql);
		Object[] params = new Object[]{userName,password};
		int i = this.affectNumber(hql, params);
		if(i!=1){
			return false;
		}else {
			return true;
		}
		
	}
}
