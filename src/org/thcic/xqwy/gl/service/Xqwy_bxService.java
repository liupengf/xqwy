package org.thcic.xqwy.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;


import org.thcic.xqwy.gl.dao.Xqwy_bxDao;
import org.thcic.xqwy.gl.vo.Xqwy_bx;
import org.thcic.xqwy.gl.dto.Xqwy_bxDto;


/**
 * 说明：处理对xqwy_bx的业务操作
 *
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_bxService  extends BaseService<Xqwy_bx,Xqwy_bx>  {




//数据访问层对象
  @Autowired
  private Xqwy_bxDao xqwy_bxDao;

	
	
	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_bxDto.class;
	}
  
  
	@Override
	public BaseDao<Xqwy_bx> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_bxDao;
	}



	@Override
	public BaseDao<Xqwy_bx> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_bxDao;
	}
}
