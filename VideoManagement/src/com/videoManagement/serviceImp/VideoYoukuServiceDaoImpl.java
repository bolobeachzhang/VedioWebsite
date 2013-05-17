package com.videoManagement.serviceImp;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videoManagement.basicDao.BasicServiceImp;

import com.videoManagement.bean.FlashVedio;

import com.videoManagement.serviceDao.VideoYoukuServiceDao;

@Service("VideoYoukuServiceDaoImpl")
@Transactional
@Repository
public class VideoYoukuServiceDaoImpl extends BasicServiceImp implements
		VideoYoukuServiceDao {

	@Override
	public List<FlashVedio> getAll(Class clazz) {
		List<FlashVedio> list = this.loadAll(clazz);
		return list;
	}

	@Override
	public FlashVedio getinfo(int id) {
		FlashVedio resources = (FlashVedio) getHibernateTemplate().get(
				FlashVedio.class, id);
		return resources;
	}

	@Override
	public int insertFlashVedio(FlashVedio entity) {
		int num = this.save(entity);
		return num;
	}

}
