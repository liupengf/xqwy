package org.thcic.xqwy.user.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.user.vo.Users;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class UsersDao extends HibernateTemplateDao<Users> {
	@Override
	public Class<Users> getEntityClass() {
		// TODO Auto-generated method stub
		return Users.class;
	}

	
}
