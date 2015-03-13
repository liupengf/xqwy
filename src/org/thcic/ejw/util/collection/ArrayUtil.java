package org.thcic.ejw.util.collection;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

/**
 * 数组操作工具类
 * 
 */
public class ArrayUtil {
	/**
	 * 空对象数组定义
	 */
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	/**
	 * 空int型数组定义
	 */
	public static final int[] EMPTY_INTEGER_ARRAY = new int[0];
	/**
	 * 空byte型数组定义
	 */
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
	/**
	 * 空short型数组定义
	 */
	public static final short[] EMPTY_SHORT_ARRAY = new short[0];
	/**
	 * 空long型数组定义
	 */
	public static final long[] EMPTY_LONG_ARRAY = new long[0];
	/**
	 * 空boolean型数组定义
	 */
	public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
	/**
	 * 空float型数组定义
	 */
	public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
	/**
	 * 空double型数组定义
	 */
	public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
	/**
	 * 空char型数组定义
	 */
	public static final char[] EMPTY_CHAR_ARRAY = new char[0];
	/**
	 * 空字符串数组定义
	 */
	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	/*
	 * 私有构造方法
	 */
	private ArrayUtil() {

	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(Object[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(int[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(short[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(byte[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(long[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(double[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(float[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数据为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(char[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组是是否为空或无长度
	 * 
	 * @param array
	 *            待校验数组
	 * @return 数组为空或无长度返回true，否则返回false
	 */
	public static boolean isEmpty(boolean[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(Object[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(int[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(short[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(byte[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(long[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(double[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(float[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(char[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 校验数组访问索引是否越界
	 * 
	 * @param arr
	 *            待校验数组
	 * @param index
	 *            数组访问索引
	 * @return 数组为空、无长度、索引值小于零或大于等于数组长度返回true， 否则返回false
	 */
	public static boolean isOutOfBound(boolean[] arr, int index) {
		if (isEmpty(arr)) {
			return true;
		}
		return (index >= arr.length || index < 0);
	}

	/**
	 * 求2个int数组的差集
	 * 
	 * @param intArray1
	 * @param intArray2
	 * @return
	 */
	public static int[] subtract(int[] intArray1, int[] intArray2) {
		int[] longArray = intArray1;
		int[] shortArray = intArray2;
		if (intArray1.length < intArray2.length) {
			longArray = intArray2;
			shortArray = intArray1;
		}
		Arrays.sort(longArray);
		Arrays.sort(shortArray);
		ArrayList<Integer> list = new ArrayList<Integer>(
				Arrays.asList(ArrayUtils.toObject(longArray)));
		for (int i = 0, k = 0, count = 0; i < shortArray.length; i++) {
			for (int j = k; j < longArray.length; j++) {
				if (shortArray[i] == longArray[j]) {
					list.remove(j - count);
					count++;
					k = j + 1;
					break;
				}
			}
		}
		return ArrayUtils.toPrimitive(list.toArray(new Integer[list.size()]));
	}

}
