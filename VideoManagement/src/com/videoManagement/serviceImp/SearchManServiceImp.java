package com.videoManagement.serviceImp;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.serviceDao.SearchManServiceDao;

/**   
 * @ClassName:SearchManServiceImp
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2012-7-27 下午8:58:44 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
@Service(value="searchManServiceImp")
public class SearchManServiceImp extends BasicServiceImp implements SearchManServiceDao {

}
