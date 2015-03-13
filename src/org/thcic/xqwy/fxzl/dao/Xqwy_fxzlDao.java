package org.thcic.xqwy.fxzl.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.fxzl.vo.Xqwy_fxzl;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class Xqwy_fxzlDao extends HibernateTemplateDao<Xqwy_fxzl> {
	@Override
	public Class<Xqwy_fxzl> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_fxzl.class;
	}

	
}
