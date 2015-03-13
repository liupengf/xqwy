package org.thcic.ejw.components.datatable;

import org.springframework.util.StringUtils;
import org.thcic.ejw.core.qo.impl.AbstractQoImpl;

public class DataTableQo extends AbstractQoImpl {

	public String iDisplayStart;// 起始记录
	public String iDisplayLength;// 记录数

	public String sEcho;
	public String sSearch;

	public String getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(String iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public String getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(String iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	@Override
	public int getFirstResult() {
		return StringUtils.hasText(iDisplayStart) ? Integer
				.parseInt(iDisplayStart) : 0;
	}

	@Override
	public int getMaxResults() {
		return StringUtils.hasText(iDisplayLength) ? Integer
				.parseInt(iDisplayLength) : 0;
	}

}
