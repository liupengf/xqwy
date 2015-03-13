package org.thcic.ejw.core.qo.annotation;

public enum OperatorType {

	EQ("="), LIKE("LIKE"), GT(">"), LT("<"), IN("IN"), NOT("NOT"), ALL("ALL"), ANY(
			"ANY"), NOTIN("NOT IN");

	private final String string;

	private OperatorType(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
