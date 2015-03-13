package org.thcic.xqwy.zhxx.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.zhxx.vo.Xqwy_zhxx;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class Xqwy_zhxxDao extends HibernateTemplateDao<Xqwy_zhxx> {
	@Override
	public Class<Xqwy_zhxx> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhxx.class;
	}

	
}
