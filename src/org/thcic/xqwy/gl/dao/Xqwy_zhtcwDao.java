package org.thcic.xqwy.gl.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.gl.vo.Xqwy_zhtcw;

/**
 * xqwy_zhtcw对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Repository
public class Xqwy_zhtcwDao extends HibernateTemplateDao<Xqwy_zhtcw> {
	@Override
	public Class<Xqwy_zhtcw> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhtcw.class;
	}

	
}
