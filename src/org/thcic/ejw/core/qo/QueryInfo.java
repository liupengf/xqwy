package org.thcic.ejw.core.qo;

import org.thcic.ejw.core.qo.annotation.OperatorType;

public class QueryInfo {

	private OperatorType operator;
	private Object value;
	private String sortOrder;

	public OperatorType getOperator() {
		return operator;
	}

	public Object getValue() {
		return value;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setRestriction(OperatorType operator, Object value) {
		this.operator = operator;
		this.value = value;
	}

}
