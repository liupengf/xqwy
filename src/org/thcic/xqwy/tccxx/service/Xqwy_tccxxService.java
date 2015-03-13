package org.thcic.xqwy.tccxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.tccxx.dao.Xqwy_tccxxDao;
import org.thcic.xqwy.tccxx.dto.Xqwy_tccxxDto;
import org.thcic.xqwy.tccxx.vo.Xqwy_tccxx;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_tccxxService extends BaseService<Xqwy_tccxx, Xqwy_tccxx> {

	// 数据访问层对象
	@Autowired
	private Xqwy_tccxxDao xqwy_tccxxDao;

	@Override
	public BaseDao<Xqwy_tccxx> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_tccxxDao;
	}

	@Override
	public BaseDao<Xqwy_tccxx> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_tccxxDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_tccxxDto.class;
	}

}
