package com.videoManagement.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.ReceptionVedioActionDao;
@Service("ReceptionVedioActionImpl")
@Repository
public class ReceptionVedioActionImpl extends BasicServiceImp implements
		ReceptionVedioActionDao {

	@Override
	public List<FlashVedio> getFlashVedios(String hql, int offset,
			int pageSize, Object[] values) {
		List<FlashVedio> flashVedios =this.findByPage2(hql, offset, pageSize, values);
		return flashVedios;
	}

	@Override
	public List getType(String hql, Object param) {
		List  list =this.query(hql, param);
		return list;
	}

	
}
