package org.thcic.ejw.core.qo.impl;

import org.thcic.ejw.core.qo.SortInfo;
import org.thcic.ejw.core.qo.annotation.QoClass;
import org.thcic.ejw.util.collection.ArrayUtil;

public class SimpleQoImpl extends AbstractQoImpl {

	public String[] sortCols;
	public String[] sortDirs;
	public int firstResult;
	public int maxResults;

	public String[] getSortCols() {
		return sortCols;
	}

	public void setSortCols(String[] sortCols) {
		this.sortCols = sortCols;
	}

	public String[] getSortDirs() {
		return sortDirs;
	}

	public void setSortDirs(String[] sortDirs) {
		this.sortDirs = sortDirs;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	@Override
	public SortInfo getSortInfo() {
		if (sortInfo.isEmpty())
			populateSortInfo();
		return sortInfo;
	}

	private void populateSortInfo() {
		boolean isEmpty = ArrayUtil.isEmpty(sortCols);
		if (isEmpty) {
			Class<?> cls = getClass();
			if (cls.isAnnotationPresent(QoClass.class)) {
				QoClass qoClass = cls.getAnnotation(QoClass.class);
				sortCols = qoClass.defaultSortCols();
				sortDirs = qoClass.defaultSortDirs();
				isEmpty = false;
			}
		}
		if (!isEmpty) {
			for (int i = 0, len = sortCols.length; i < len; i++) {
				sortInfo.put(sortCols[i], sortDirs[i]);
			}
		}
	}

}
