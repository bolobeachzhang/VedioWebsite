package com.videoManagement.serviceImp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.VideoPlayerServiceDao;
@Service("VideoPlayerServiceImpl")
@Repository
public class VideoPlayerServiceImpl extends BasicServiceImp implements
		VideoPlayerServiceDao {

	@Override
	public FlashVedio getFlash(int id) {
		FlashVedio flashVedio =(FlashVedio) this.getHibernateTemplate().get(FlashVedio.class, id);
		return flashVedio;
	}

	@Override
	public List<Comment> getComment(final String hql, final int offset,final int pageSize,final Object value) {
		List<Comment> list = this.findByPage1(hql, offset, pageSize, value);	
		return list;
	}

	@Override
	public int getAllComment(final String hql, Object[] values) {
		int  num = this.affectNumber(hql, values);
		return num;
	}
	
	
	

}
