package org.thcic.ejw.components.datatable;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.thcic.ejw.core.qo.SortInfo;
import org.thcic.ejw.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataTableUtil {

	/**
	 * 将DataTable传值json中的信息转换成Map
	 * 
	 * @param aoData
	 * @return Map
	 */
	public static Map<String, String> fromAoDataToMap(String aoData) {
		Map<String, String> map = new HashMap<String, String>();
		JSONArray jsonArray = JSONArray.fromObject(aoData);
		JSONObject obj = null;
		for (int i = 0; i < jsonArray.size(); i++) {
			obj = (JSONObject) jsonArray.get(i);
			Object value = obj.get("value");
			if (value instanceof JSONArray) {
				JSONArray json = (JSONArray) value;
				StringBuffer sb = new StringBuffer();
				int size = json.size();
				if (size > 0) {
					sb.append(json.get(0).toString());
					for (int j = 1; j < size; j++) {
						sb.append(",").append(json.get(j).toString());
					}
				}
				value = sb;
			}
			map.put(obj.get("name").toString(), value.toString());
		}
		return map;
	}

	/**
	 * 将存储信息的Map转换成给定类型的DataTableQo对象
	 * 
	 * @param map
	 * @param clazz
	 * @return DataTableQo
	 * @throws Exception
	 */
	public static DataTableQo parseDataTableQo(Map<String, String> map,
			Class<? extends DataTableQo> clazz) throws Exception {
		DataTableQo qo = clazz.newInstance();
		// DataTable信息
		qo.setsEcho(map.get("sEcho"));
		qo.setsSearch(map.get("sSearch"));
		qo.setiDisplayLength(map.get("iDisplayLength"));
		qo.setiDisplayStart(map.get("iDisplayStart"));
		// 排序信息
		String iSortingCols = map.get("iSortingCols");
		if (iSortingCols != null && !iSortingCols.equals("0")) {
			int len = Integer.parseInt(iSortingCols);
			SortInfo sortInfo = qo.getSortInfo();
			for (int i = 0; i < len; i++) {
				String sortColumnIndex = map.get("iSortCol_" + i);
				String columnName = map.get("mDataProp_" + sortColumnIndex);
				if (null != columnName && !columnName.equals("function")) {
					sortInfo.put(columnName, map.get("sSortDir_" + i));
				}
			}
		}
		setQoFields(map, qo);
		return qo;
	}

	private static void setQoFields(Map<String, String> map, DataTableQo qo)
			throws Exception {
		Field[] fields = qo.getClass().getDeclaredFields();
		for (Field field : fields) {
			String value = map.get(field.getName());
			if (StringUtils.hasText(value)) {
				Class<?> fieldType = field.getType();
				field.setAccessible(true);
				if (fieldType == String.class) {
					field.set(qo, value);
				} else if (fieldType == Integer.TYPE) {
					field.set(qo, Integer.parseInt(value));
				} else if (fieldType == Double.TYPE) {
					field.set(qo, Double.parseDouble(value));
				} else if (fieldType == Date.class) {
					if (field.isAnnotationPresent(DateTimeFormat.class)) {
						String pattern = field.getAnnotation(
								DateTimeFormat.class).pattern();
						field.set(qo, DateUtil.parse(value, pattern));
					} else {
						field.set(qo, DateUtil.parseDate(value));
					}
				} else if (fieldType == String[].class) {
					if (StringUtils.hasText(value)) {
						field.set(qo, value.split(","));
					}
				} else if (fieldType == int[].class) {
					if (StringUtils.hasText(value)) {
						String[] strArray = value.split(",");
						int[] intArray = new int[strArray.length];
						for (int i = 0; i < intArray.length; i++) {
							intArray[i] = Integer.parseInt(strArray[i]);
						}
						field.set(qo, intArray);
					}
				}
			}
		}
	}

	/**
	 * 将DataTable传值json中的信息转换成给定类型的DataTableQo对象
	 * 
	 * @param aoData
	 * @param clazz
	 * @return DataTableQo
	 */
	public static DataTableQo parseDataTableQo(String aoData,
			Class<? extends DataTableQo> clazz) throws Exception {
		return parseDataTableQo(fromAoDataToMap(aoData), clazz);
	}


}
