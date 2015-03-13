package org.thcic.ejw.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

public class BeanUtil {

	/**
	 * 由给定List的元素通过beancopy获得新的List
	 * 
	 * @param original
	 * @param targetType
	 * @return
	 * @throws Exception
	 */
	public static <T, V> List<T> listBeanCopy(List<V> original,
			Class<? extends T> targetType) throws Exception {
		int size = original.size();
		List<T> target = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			T t = targetType.newInstance();
			BeanUtils.copyProperties(original.get(i), t);
			target.add(t);
		}
		return target;
	}

	/**
	 * 获得entity的主键字段名
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static String getIdName(Class<?> clazz) throws Exception {
		if (clazz.getAnnotation(Entity.class) == null) {
			throw new Exception(clazz.getName() + " is not an Entity class.");
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class)) {
				return field.getName();
			}
		}
		throw new Exception("No Id Annotation found on declared fields.");
	}

}
