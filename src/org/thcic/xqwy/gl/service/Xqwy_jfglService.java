package org.thcic.xqwy.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;






import org.thcic.xqwy.gl.dao.Xqwy_jfglDao;
import org.thcic.xqwy.gl.vo.Xqwy_jfgl;
import org.thcic.xqwy.gl.dto.Xqwy_jfglDto;


/**
 * 说明：处理对xqwy_jfgl的业务操作
 *
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_jfglService  extends BaseService<Xqwy_jfgl,Xqwy_jfgl>  {




//数据访问层对象
  @Autowired
  private Xqwy_jfglDao xqwy_jfglDao;

	
	
	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_jfglDto.class;
	}
  
  
	@Override
	public BaseDao<Xqwy_jfgl> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_jfglDao;
	}



	@Override
	public BaseDao<Xqwy_jfgl> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_jfglDao;
	}
}
