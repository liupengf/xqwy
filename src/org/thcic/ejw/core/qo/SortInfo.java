package org.thcic.ejw.core.qo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

public class SortInfo {

	private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

	public SortInfo put(String sortColumnName) {
		map.put(sortColumnName, "asc");
		return this;
	}

	public SortInfo put(String sortColumnName, String sortOrder) {
		if (sortOrder == null || !sortOrder.equalsIgnoreCase("desc"))
			sortOrder = "asc";
		map.put(sortColumnName, sortOrder);
		return this;
	}

	public SortInfo put(String[] sortColumnNames) {
		for (String s : sortColumnNames) {
			map.put(s, "asc");
		}
		return this;
	}

	public SortInfo remove(String sortColumnName) {
		map.remove(sortColumnName);
		return this;
	}

	public void clear() {
		map.clear();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	/**
	 * 将SortInfo转换成OrderList
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Order> toOrderList() throws Exception {
		List<Order> orderList = new ArrayList<Order>();
		if (map.size() > 0) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				orderList.add(getOrder(entry.getKey(), entry.getValue()));
			}
		}
		return orderList;
	}

	private Order getOrder(String sortColumnName, String sortOrder) {
		if (sortOrder.equalsIgnoreCase("asc")) {
			return Order.asc(sortColumnName);
		} else {
			return Order.desc(sortColumnName);
		}
	}

}
