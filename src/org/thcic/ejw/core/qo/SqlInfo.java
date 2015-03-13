package org.thcic.ejw.core.qo;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.util.StringUtils;

public class SqlInfo {

	private String sql; // sql语句
	private Object[] sqlParamValues; // 参数值
	private Class<?>[] sqlParamTypes; // 参数类型
	private int paramCount; // 参数数目

	public String getSql() {
		return sql;
	}

	public SqlInfo setSql(String sql) {
		this.sql = sql;
		return this;
	}

	public Object[] getSqlParamValues() {
		return sqlParamValues;
	}

	public SqlInfo setSqlParamValues(Object... sqlParamValues) {
		this.sqlParamValues = sqlParamValues;
		return this;
	}

	public Class<?>[] getSqlParamTypes() {
		return sqlParamTypes;
	}

	public SqlInfo setSqlParamTypes(Class<?>... sqlParamTypes) {
		this.sqlParamTypes = sqlParamTypes;
		if (sqlParamTypes != null) {
			this.paramCount = sqlParamTypes.length;
		}
		return this;
	}

	/**
	 * 将SqlInfo转换成Criterion
	 * 
	 * @return
	 * @throws Exception
	 */
	public Criterion toCriterion() throws Exception {
		if (!StringUtils.hasText(sql)) {
			throw new Exception("Null sql.");
		}
		if (this.paramCount == 0) {
			return Restrictions.sqlRestriction(sql);
		}
		Type[] types = new Type[this.paramCount];
		for (int i = 0; i < this.paramCount; i++) {
			types[i] = convertClassToType(sqlParamTypes[i]);
		}
		return Restrictions.sqlRestriction(sql, sqlParamValues, types);
	}

	/**
	 * 将Class转换成相应的org.hibernate.type.Type
	 * 
	 * @param paramType
	 * @return
	 * @throws Exception
	 */
	private Type convertClassToType(Class<?> paramType) throws Exception {
		if (paramType == Integer.TYPE || paramType == Integer.class) {
			return new IntegerType();
		} else if (paramType == Double.TYPE || paramType == Double.class) {
			return new DoubleType();
		} else if (paramType == Date.class) {
			return new DateType();
		} else if (paramType == String.class) {
			return new StringType();
		} else {
			throw new Exception("Unsupported paramType: " + paramType);
		}
	}
}
