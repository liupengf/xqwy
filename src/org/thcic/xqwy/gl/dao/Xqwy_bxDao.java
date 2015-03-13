package org.thcic.xqwy.gl.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.gl.vo.Xqwy_bx;

/**
 * xqwy_bx对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Repository
public class Xqwy_bxDao extends HibernateTemplateDao<Xqwy_bx> {
	@Override
	public Class<Xqwy_bx> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_bx.class;
	}

	
}
