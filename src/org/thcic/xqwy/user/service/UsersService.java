package org.thcic.xqwy.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.user.dao.UsersDao;
import org.thcic.xqwy.user.dto.UsersDto;
import org.thcic.xqwy.user.vo.Users;

/**
 * 说明：
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Service
@Transactional
public class UsersService extends BaseService<Users, Users> {

	// 数据访问层对象
	@Autowired
	private UsersDao usersDao;
public Users getUser(String username){
	return usersDao.getById(username);
}

	@Override
	public BaseDao<Users> getTableDao() {
		// TODO Auto-generated method stub
		return usersDao;
	}

	@Override
	public BaseDao<Users> getViewDao() {
		// TODO Auto-generated method stub
		return usersDao;
	}

	@Override
	public Class<? extends Dto> getDtoClass() {
		// TODO Auto-generated method stub
		return UsersDto.class;
	}

}
