package org.thcic.xqwy.fxzl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.fxzl.dao.Xqwy_fxzlDao;
import org.thcic.xqwy.fxzl.dto.Xqwy_fxzlDto;
import org.thcic.xqwy.fxzl.vo.Xqwy_fxzl;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_fxzlService extends BaseService<Xqwy_fxzl, Xqwy_fxzl> {

	// 数据访问层对象
	@Autowired
	private Xqwy_fxzlDao xqwy_fxzlDao;

	@Override
	public BaseDao<Xqwy_fxzl> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_fxzlDao;
	}

	@Override
	public BaseDao<Xqwy_fxzl> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_fxzlDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_fxzlDto.class;
	}

}
