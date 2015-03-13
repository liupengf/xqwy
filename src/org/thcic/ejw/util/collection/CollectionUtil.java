
package org.thcic.ejw.util.collection;

import java.util.Collection;

/**
 * 集合容器操作工具类
 * 
 * 
 */
public class CollectionUtil {
	/*
	 * 私有构造方法
	 */
	private CollectionUtil() {

	}

	/**
	 * 判断集合是否为空
	 * 
	 * @param <T>
	 *            集合泛型类型
	 * @param coll
	 *            集合对象
	 * @return 空：true 非空：false
	 */
	public static <T> boolean isEmpty(Collection<T> coll) {
		if (coll == null || coll.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断index值是否超出指定集合对象的索引范围
	 * 
	 * @param <T>
	 *            集合泛型类型
	 * @param coll
	 *            集合对象
	 * @param index
	 *            索引值
	 * @return 超出:true 未超出:false
	 */
	public static <T> boolean isOutOfBound(Collection<T> coll, int index) {
		if (isEmpty(coll)) {
			return true;
		}
		if ((index >= coll.size()) || (index < 0)) {
			return true;
		} else {
			return false;
		}
	}
}
