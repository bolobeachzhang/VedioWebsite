package com.videoManagement.serviceDao;

import java.util.List;

import com.videoManagement.basicDao.BasicDao;
import com.videoManagement.bean.FlashVedio;
/**
 * 加载页面的显示的视频
 * @author Administrator
 *
 */
public interface ReceptionVedioActionDao extends BasicDao {
  /**
   * 得到一个list对象存放各种类型的视频（包括12条）
   */
	public List<FlashVedio> getFlashVedios(final String hql, final int offset,
			final int pageSize, final Object[] values);
	public  List getType(final String hql,Object param);
	
}
