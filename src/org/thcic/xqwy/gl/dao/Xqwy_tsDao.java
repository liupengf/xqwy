package org.thcic.xqwy.gl.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.gl.vo.Xqwy_ts;

/**
 * xqwy_ts对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Repository
public class Xqwy_tsDao extends HibernateTemplateDao<Xqwy_ts> {
	@Override
	public Class<Xqwy_ts> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_ts.class;
	}

	
}
