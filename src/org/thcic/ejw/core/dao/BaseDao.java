package org.thcic.ejw.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.qo.Qo;

@Repository
public interface BaseDao<T> {

	public T getById(Serializable id);

	public T getByUniqueKey(String columnName, Object value);

	public T getByMap(Map<String, Object> nameValuePairs);

	public List<T> getAll();

	public List<T> getListByColumn(String columnName, Object value);

	public List<T> getListByQo(Qo qo) throws Exception;

	public List<T> getPageListByQo(Qo qo) throws Exception;

	public int getRowCountByQo(Qo qo) throws Exception;

	public Serializable save(T t);

	public void update(T t);

	public void delete(T t);

	public void batchDelete(Serializable... ids) throws Exception;
	public void batchUpdate(String columnnage,String value,Serializable... ids) throws Exception;

	public Class<T> getEntityClass();
	

}
