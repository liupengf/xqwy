package org.thcic.xqwy.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;






import org.thcic.xqwy.gl.dao.Xqwy_zhtcwDao;
import org.thcic.xqwy.gl.vo.Xqwy_zhtcw;
import org.thcic.xqwy.gl.dto.Xqwy_zhtcwDto;


/**
 * 说明：处理对xqwy_zhtcw的业务操作
 *
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_zhtcwService  extends BaseService<Xqwy_zhtcw,Xqwy_zhtcw>  {




//数据访问层对象
  @Autowired
  private Xqwy_zhtcwDao xqwy_zhtcwDao;

	
	
	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhtcwDto.class;
	}
  
  
	@Override
	public BaseDao<Xqwy_zhtcw> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_zhtcwDao;
	}



	@Override
	public BaseDao<Xqwy_zhtcw> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_zhtcwDao;
	}
}
