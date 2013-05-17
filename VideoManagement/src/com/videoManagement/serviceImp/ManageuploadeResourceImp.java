package com.videoManagement.serviceImp;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.FlashVedio;
import com.videoManagement.serviceDao.ManageuploadeResource;

@Repository
public class ManageuploadeResourceImp extends BasicServiceImp  implements ManageuploadeResource {

	@Override
	public void delUploadResource(final Object obj ,final String path) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session )
					throws HibernateException, SQLException {
				File file = new File(path);
				if(file.isFile()){
					file.delete();
				}
		
				session.delete(obj);
				
				return null;
			}
		});
		
	}

}
