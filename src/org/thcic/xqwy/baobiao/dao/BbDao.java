package org.thcic.xqwy.baobiao.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.baobiao.vo.Bb;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class BbDao extends HibernateTemplateDao<Bb> {
	@Override
	public Class<Bb> getEntityClass() {
		// TODO Auto-generated method stub
		return Bb.class;
	}

	
}
