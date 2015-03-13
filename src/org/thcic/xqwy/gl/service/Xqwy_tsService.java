package org.thcic.xqwy.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;






import org.thcic.xqwy.gl.dao.Xqwy_tsDao;
import org.thcic.xqwy.gl.vo.Xqwy_ts;
import org.thcic.xqwy.gl.dto.Xqwy_tsDto;


/**
 * 说明：处理对xqwy_ts的业务操作
 *
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_tsService  extends BaseService<Xqwy_ts,Xqwy_ts>  {




//数据访问层对象
  @Autowired
  private Xqwy_tsDao xqwy_tsDao;

	
	
	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_tsDto.class;
	}
  
  
	@Override
	public BaseDao<Xqwy_ts> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_tsDao;
	}



	@Override
	public BaseDao<Xqwy_ts> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_tsDao;
	}
}
