package com.videoManagement.serviceDao;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.videoManagement.basicDao.BasicDao;
import com.videoManagement.bean.Comment;
import com.videoManagement.bean.FlashVedio;
/**
 * @Copyright (C), 2013-2030, 成都大学10503省重点工作室.
 * @FileName Behind_jspAction.java
 * @version 1.0
 * @Description: 播放视频的serviceDao actoin
 * @Author 代兵
 * @Date  2013-3-27, 20:32  PM
 * @mailto 707189384@qq.com
 * 播放视频服务
 */
public interface VideoPlayerServiceDao extends BasicDao {
   /**
    * 更具id获取当前对象
    */
	public FlashVedio  getFlash(int id);
	/**
	 * 取十条评论
	 * @param hql（hql语句）
	 * @param offset（取的开始位置）
	 * @param pageSize（去多少条）
	 * @param values（hql参数）
	 * @return
	 */
	public List<Comment> getComment(final String hql, final int offset,final int pageSize,final Object values);
	/**
	 * 对应所有的评论  然后取得条数
	 * @param hql
	 * @param values
	 * @return
	 */
	public int getAllComment(final String hql,Object[] values);
}
