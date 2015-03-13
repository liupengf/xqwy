package org.thcic.ejw.core.dao.jdbcTemplate;

import java.util.List;

public class PageInfo {
	// 一页显示的记录数
	private int perPageNum;
	// 记录总数
	private int totalRows;
	// 总页数
	private int totalPages;
	// 当前页码
	private int currentPage;
	// 上一页
	private int prePage;
	// 下一页
	private int nextPage;
	// 起始行数
	private int startIndex;
	// 结束行数
	private int lastIndex;
	// 结果集存放List
	private List<Object> resultList;

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages() {
		if (totalRows % perPageNum == 0) {
			this.totalPages = totalRows / perPageNum;
		} else {
			this.totalPages = (totalRows / perPageNum) + 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		this.startIndex = (currentPage - 1) * perPageNum;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex() {
		// System.out.println("totalRows=" + totalRows);
		// System.out.println("numPerPage=" + numPerPage);// /////////
		if (totalRows < perPageNum) {
			this.lastIndex = totalRows;
		} else if ((totalRows % perPageNum == 0)
				|| (totalRows % perPageNum != 0 && currentPage < totalPages)) {
			this.lastIndex = currentPage * perPageNum;
		} else if (totalRows % perPageNum != 0 && currentPage == totalPages) {// 最后一页
			this.lastIndex = totalRows;
		}
	}

	public List<Object> getResultList() {
		return resultList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
}
