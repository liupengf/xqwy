package org.thcic.ejw.core.ro;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageList {

	private int total;
	private int start;
	private int size;
	private List resultsList;

	public PageList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageList(int total, int start, int size, List resultsList) {
		super();
		this.total = total;
		this.start = start;
		this.size = size;
		this.resultsList = resultsList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List getResultsList() {
		return resultsList;
	}

	public void setResultsList(List resultsList) {
		this.resultsList = resultsList;
	}

}
