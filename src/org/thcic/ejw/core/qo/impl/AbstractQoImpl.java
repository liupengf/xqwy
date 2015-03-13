package org.thcic.ejw.core.qo.impl;

import org.thcic.ejw.core.qo.Qo;
import org.thcic.ejw.core.qo.SortInfo;
import org.thcic.ejw.core.qo.SqlInfo;

public abstract class AbstractQoImpl implements Qo {

	protected SortInfo sortInfo = new SortInfo(); // 排序信息
	protected SqlInfo sqlInfo = new SqlInfo(); // sql查询信息

	// protected HashMap<String, QueryInfo> mapping = new HashMap<String,
	// QueryInfo>();

	public SortInfo getSortInfo() {
		return sortInfo;
	}

	public void setSortInfo(SortInfo sortInfo) {
		this.sortInfo = sortInfo;
	}

	public SqlInfo getSqlInfo() {
		return sqlInfo;
	}

	public void setSqlInfo(SqlInfo sqlInfo) {
		this.sqlInfo = sqlInfo;
	}

	// public HashMap<String, QueryInfo> getMapping() {
	// return mapping;
	// }
	//
	// public void setMapping(HashMap<String, QueryInfo> mapping) {
	// this.mapping = mapping;
	// }

}
