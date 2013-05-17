package com.videoManagement.serviceImp;

import org.springframework.stereotype.Service;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.serviceDao.FocusImageManagerServiceDao;

@Service("FocusImageManagerServiceImpl")
public class FocusImageManagerServiceImpl extends BasicServiceImp implements
		FocusImageManagerServiceDao {

}
