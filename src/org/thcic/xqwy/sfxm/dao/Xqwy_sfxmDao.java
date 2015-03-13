package org.thcic.xqwy.sfxm.dao;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.hibernate.HibernateTemplateDao;
import org.thcic.xqwy.sfxm.vo.Xqwy_sfxm;

/**
 * 教务办公发文表对象的数据访问类
 * 
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Repository
public class Xqwy_sfxmDao extends HibernateTemplateDao<Xqwy_sfxm> {
	@Override
	public Class<Xqwy_sfxm> getEntityClass() {
		// TODO Auto-generated method stub
		return Xqwy_sfxm.class;
	}

	
}
