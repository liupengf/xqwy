package org.thcic.xqwy.sfxm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.sfxm.dao.Xqwy_sfxmDao;
import org.thcic.xqwy.sfxm.dto.Xqwy_sfxmDto;
import org.thcic.xqwy.sfxm.vo.Xqwy_sfxm;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class Xqwy_sfxmService extends BaseService<Xqwy_sfxm, Xqwy_sfxm> {

	// 数据访问层对象
	@Autowired
	private Xqwy_sfxmDao xqwy_sfxmDao;
public List<Xqwy_sfxm> getAll(){
	return xqwy_sfxmDao.getAll();
}
	@Override
	public BaseDao<Xqwy_sfxm> getTableDao() {
		// TODO Auto-generated method stub
		return xqwy_sfxmDao;
	}

	@Override
	public BaseDao<Xqwy_sfxm> getViewDao() {
		// TODO Auto-generated method stub
		return xqwy_sfxmDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return Xqwy_sfxmDto.class;
	}

}
