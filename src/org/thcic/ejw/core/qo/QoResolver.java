package org.thcic.ejw.core.qo;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoField;

/**
 * qo解析类，将qo包含的查询条件信息添加到criteria
 * 
 * @author 04
 * 
 */
public class QoResolver {

	/**
	 * 将qo包含的查询条件信息添加到criteria
	 * 
	 * @param criteria
	 * @param qo
	 * @throws Exception
	 */
	public static void resolveCriterion(Criteria criteria, Qo qo)
			throws Exception {
		Class<? extends Qo> clazz = qo.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(QoField.class)) {
				field.setAccessible(true);
				Object value = field.get(qo);
				if (isValidValue(field.getType(), value)) {
					QoField annotation = field.getAnnotation(QoField.class);
					OperatorType ot = annotation.operator();
					String fieldName = annotation.fieldName();
					if (fieldName.length() == 0)
						fieldName = field.getName();
					criteria.add(getCriterion(fieldName, value, ot));
				}
			}
		}
		if (qo.getSqlInfo() != null
				&& StringUtils.hasText(qo.getSqlInfo().getSql())) {
			criteria.add(qo.getSqlInfo().toCriterion());
		}
	}

	/**
	 * 判断给定的value对于给定的字段类型是否是有效值
	 * 
	 * @param field
	 * @param value
	 * @return
	 */
	private static boolean isValidValue(Class<?> cls, Object value) {
		if (value == null) {
			return false;
		} else if (cls == Integer.TYPE || cls == Integer.class) {
			if (((Integer) value).intValue() == 0)
				return false;
		} else if (cls == Double.TYPE || cls == Double.class) {
			if (((Double) value).doubleValue() == 0)
				return false;
		} else if (cls == String.class && !StringUtils.hasText((String) value)) {
			return false;
		}
		return true;
	}

	/**
	 * 获得属性对应的查询条件
	 * 
	 * @param ot
	 *            属性对应的操作符
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private static Criterion getCriterion(String propertyName, Object value,
			OperatorType ot) throws Exception {
		if (ot == OperatorType.EQ) {
			return Restrictions.eq(propertyName, value);
		} else if (ot == OperatorType.NOT) {
			return Restrictions.not(Restrictions.eq(propertyName, value));
		} else if (ot == OperatorType.LIKE) {
			return Restrictions.like(propertyName, value.toString(),
					MatchMode.ANYWHERE);
		} else if (ot == OperatorType.IN) {
			if (value instanceof int[]) {
				if (((int[]) value).length == 0) {
					return Restrictions.sqlRestriction("1 != 1");
				}
				return Restrictions.in(propertyName,
						ArrayUtils.toObject((int[]) value));
			} else if (value instanceof double[]) {
				if (((double[]) value).length == 0) {
					return Restrictions.sqlRestriction("1 != 1");
				}
				return Restrictions.in(propertyName,
						ArrayUtils.toObject((double[]) value));
			} else if (value instanceof Object[]) {
				if (((Object[]) value).length == 0) {
					return Restrictions.sqlRestriction("1 != 1");
				}
				return Restrictions.in(propertyName, (Object[]) value);
			} else if (value instanceof Collection) {
				if (((Collection) value).size() == 0) {
					return Restrictions.sqlRestriction("1 != 1");
				}
				return Restrictions.in(propertyName, (Collection) value);
			} else {
				throw new Exception("Wrong value type: " + value.getClass()
						+ "for Operator IN");
			}
		} else if (ot == OperatorType.NOTIN) {
			return Restrictions.not(getCriterion(propertyName, value,
					OperatorType.IN));
		}else if (ot == OperatorType.LT) {
			return Restrictions.lt(propertyName, value);
		}else if (ot == OperatorType.GT) {
			return Restrictions.gt(propertyName, value);
		} else {
			throw new Exception("Unsupported OperatorType.");
		}
	}

	/**
	 * 将qo包含的查询排序信息添加到criteria
	 * 
	 * @param criteria
	 * @param qo
	 * @throws Exception
	 */
	public static void resolveOrder(Criteria criteria, Qo qo) throws Exception {
		if (qo.getSortInfo() != null) {
			List<Order> orderList = qo.getSortInfo().toOrderList();
			for (Order order : orderList) {
				criteria.addOrder(order);
			}
		}
	}

	/**
	 * 将qo包含的查询分页信息添加到criteria
	 * 
	 * @param criteria
	 * @param qo
	 */
	public static void resolvePagination(Criteria criteria, Qo qo) {
		criteria.setFirstResult(qo.getFirstResult());
		criteria.setMaxResults(qo.getMaxResults());
	}
}
