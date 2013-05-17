package com.videoManagement.serviceImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Users;
import com.videoManagement.serviceDao.UserServiceDao;
@Service("UserServiceDaoImpl")
@Transactional
@Repository
public class UserServiceDaoImpl extends BasicServiceImp implements UserServiceDao{

	@Override
	public List<Users> getAll(String hql, int offset, int obtain,
			Object[] params) {
		List<Users> list = this.pageQuery(hql, offset, obtain, params);
		return list;
	}
	@Override
	public int deleteSelected(String hql, int[] ids) {
		 int delete_ok = 0;
			List<Users> list = new ArrayList<Users>();
			 //用过Id获得所有Id的实体
			for (int i = 0; i < ids.length; i++) {
				Users users = (Users) getHibernateTemplate().load(Users.class,(Serializable) ids[i]);
				list.add(users);
			}
			//循环遍历删除该对象
			for (Users user : list) {
				this.delete(user);
				delete_ok++;
			}   
			return delete_ok;
	}

	@Override
	public Users getinfo(int id) {
		Users user = (Users) getHibernateTemplate().get(Users.class, id);
		return user;
	}
	@Override
	public int getTotalCount(String hql, Object[] params) {
		int num = this.affectNumber(hql, params);
		return num;
	}
	@Override
	public void modifyAuthority(String hql, Object[] params) {	
		this.update(hql, params);
	}
	
   
}
