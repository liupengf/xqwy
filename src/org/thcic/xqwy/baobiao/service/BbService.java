package org.thcic.xqwy.baobiao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.baobiao.dao.BbDao;
import org.thcic.xqwy.baobiao.dto.BbDto;
import org.thcic.xqwy.baobiao.vo.Bb;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class BbService extends BaseService<Bb, Bb> {

	// 数据访问层对象
	@Autowired
	private BbDao bbDao;
 public List<Bb> getAllBb(){
	 return bbDao.getAll();
 }
	@Override
	public BaseDao<Bb> getTableDao() {
		// TODO Auto-generated method stub
		return bbDao;
	}

	@Override
	public BaseDao<Bb> getViewDao() {
		// TODO Auto-generated method stub
		return bbDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return BbDto.class;
	}

}
