package org.thcic.xqwy.tccxx.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.tccxx.vo.Xqwy_tccxx;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class Xqwy_tccxxDao extends HibernateTemplateDao<Xqwy_tccxx> {
	@Override
	public Class<Xqwy_tccxx> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_tccxx.class;
	}

	
}
