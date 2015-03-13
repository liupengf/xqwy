package org.thcic.ejw.core.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.qo.Qo;
import org.thcic.ejw.core.ro.PageList;
import org.thcic.ejw.util.BeanUtil;

@Service
@Transactional
public abstract class BaseService<T, V> {

	/**
	 * 获取分页列表
	 * 
	 * @param qo
	 * @param dtoClass
	 * @return PageList
	 * @throws Exception
	 */
	public PageList queryPageList(Qo qo, Class<? extends Dto> dtoClass)
			throws Exception {
		int total = getViewDao().getRowCountByQo(qo);
		List<V> resultsList = getViewDao().getPageListByQo(qo);
		List<?> resultsDtoList = BeanUtil.listBeanCopy(resultsList, dtoClass);
		return new PageList(total, qo.getFirstResult(), qo.getMaxResults(),
				resultsDtoList);
	}

	public PageList queryPageList(Qo qo) throws Exception {
		return queryPageList(qo, getDtoClass());
	}

	/**
	 * 获得符合查询条件的列表
	 * 
	 * @param qo
	 * @param dtoClass
	 * @return List
	 * @throws Exception
	 */
	public List<? extends Dto> queryList(Qo qo, Class<? extends Dto> dtoClass)
			throws Exception {
		return BeanUtil.listBeanCopy(getViewDao().getListByQo(qo), dtoClass);
	}

	public List<? extends Dto> queryList(Qo qo) throws Exception {
		return queryList(qo, getDtoClass());
	}

	/**
	 * 获得符合查询条件的列表
	 * 
	 * @param columnName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public List<? extends Dto> queryList(String columnName, Object value)
			throws Exception {
		return BeanUtil.listBeanCopy(
				getViewDao().getListByColumn(columnName, value), getDtoClass());
	}

	public List<? extends Dto> queryList(String columnName, Object value,
			Class<? extends Dto> dtoClass) throws Exception {
		return BeanUtil.listBeanCopy(
				getViewDao().getListByColumn(columnName, value), dtoClass);
	}

	/**
	 * 获得详细信息
	 * 
	 * @param id
	 * @return Dto
	 * @throws Exception
	 */
	public Dto queryById(Serializable id) throws Exception {
		return queryById(id, getDtoClass());
	}

	public Dto queryById(Serializable id, Class<? extends Dto> dtoClass)
			throws Exception {
		Dto dto = null;
		V v = getViewDao().getById(id);
		if (v != null) {
			dto = dtoClass.newInstance();
			BeanUtils.copyProperties(v, dto);
		}
		return dto;
	}

	/**
	 * 根据唯一键查询详细信息
	 * 
	 * @param columnName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public Dto queryByUniqueKey(String columnName, Object value)
			throws Exception {
		return queryByUniqueKey(columnName, value, getDtoClass());
	}

	public Dto queryByUniqueKey(String columnName, Object value,
			Class<? extends Dto> dtoClass) throws Exception {
		Dto dto = null;
		V v = getViewDao().getByUniqueKey(columnName, value);
		if (v != null) {
			dto = dtoClass.newInstance();
			BeanUtils.copyProperties(v, dto);
		}
		return dto;
	}

	/**
	 * 添加一条记录
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void add(Dto dto) throws Exception {
		T t = getTableDao().getEntityClass().newInstance();
		BeanUtils.copyProperties(dto, t);
		getTableDao().save(t);
	}
	public void addEntity(T t) throws Exception {
		getTableDao().save(t);
	}

	/**
	 * 修改一条记录
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void edit(Dto dto) throws Exception {
		T t = getTableDao().getById(dto.getId());
		BeanUtils.copyProperties(dto, t);
		getTableDao().update(t);
	}
	public void editEntity(T t) throws Exception {		
		getTableDao().update(t);
	}
	/**
	 * 删除一条或多条记录
	 * 
	 * @param seqArray
	 * @throws Exception
	 */
	public void del(int... seqArray) throws Exception {
		getTableDao().batchDelete(
				(Serializable[]) ArrayUtils.toObject(seqArray));
	}

	/**
	 * 删除一条或多条记录
	 * 
	 * @param seqArray
	 * @throws Exception
	 */
	public void del(String... seqArray) throws Exception {
		getTableDao().batchDelete((Serializable[]) seqArray);
	}
	
	/**
	 * 删除一条或多条记录
	 * 
	 * @param seqArray
	 * @throws Exception
	 */
	public void batchUpdate(String columnname,String value,String... seqArray) throws Exception {
		getTableDao().batchUpdate(columnname, value, (Serializable[])seqArray);
	}
	/**
	 * 删除一条或多条记录
	 * 
	 * @param seqArray
	 * @throws Exception
	 */
	public void batchUpdate(String columnname,String value,int... seqArray) throws Exception {
		getTableDao().batchUpdate(columnname, value, (Serializable[])ArrayUtils.toObject(seqArray));
	}

	public abstract BaseDao<T> getTableDao();

	public abstract BaseDao<V> getViewDao();

	public abstract Class<? extends Dto> getDtoClass();

}
