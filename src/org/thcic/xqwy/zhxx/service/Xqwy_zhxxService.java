package org.thcic.xqwy.zhxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.zhxx.dao.Xqwy_zhxxDao;
import org.thcic.xqwy.zhxx.dto.Xqwy_zhxxDto;
import org.thcic.xqwy.zhxx.vo.Xqwy_zhxx;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_zhxxService extends BaseService<Xqwy_zhxx, Xqwy_zhxx> {

	// 数据访问层对象
	@Autowired
	private Xqwy_zhxxDao xqwy_zhxxDao;

	@Override
	public BaseDao<Xqwy_zhxx> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_zhxxDao;
	}

	@Override
	public BaseDao<Xqwy_zhxx> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_zhxxDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhxxDto.class;
	}

}
