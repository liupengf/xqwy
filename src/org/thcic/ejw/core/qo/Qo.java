package org.thcic.ejw.core.qo;

/**
 * 查询对象标识接口
 * 
 * @author 04
 * 
 */
public interface Qo {

	SortInfo getSortInfo();

	SqlInfo getSqlInfo();

	int getFirstResult();

	int getMaxResults();

	// Map<String, QueryInfo> getMapping();
}
