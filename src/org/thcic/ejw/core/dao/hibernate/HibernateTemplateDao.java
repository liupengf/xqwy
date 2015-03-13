package org.thcic.ejw.core.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.thcic.ejw.core.dao.BaseDao;
import org.thcic.ejw.core.qo.Qo;
import org.thcic.ejw.core.qo.QoResolver;
import org.thcic.ejw.util.BeanUtil;

@SuppressWarnings("unchecked")
@Repository
public abstract class HibernateTemplateDao<T> implements BaseDao<T> {

	protected static final Log log = LogFactory
			.getLog(HibernateTemplateDao.class);

	public abstract Class<T> getEntityClass();

	protected SessionFactory sessionFactory;

	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session openNewSession() {
		return sessionFactory.openSession();
	}

	/* ===========================查询单条记录start=========================== */

	/**
	 * 根据主键查询（get）
	 * 
	 */
	@Override
	public T getById(Serializable id) {
		return (T) getSession().get(getEntityClass(), id);
	}

	/**
	 * 根据唯一键查询
	 * 
	 */
	@Override
	public T getByUniqueKey(String columnName, Object value) {
		return (T) getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq(columnName, value)).uniqueResult();
	}

	/**
	 * 根据map提供的约束条件查询唯一记录
	 * 
	 */
	@Override
	public T getByMap(Map<String, Object> nameValuePairs) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		for (Map.Entry<String, Object> entry : nameValuePairs.entrySet()) {
			criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return (T) criteria.uniqueResult();
	}

	/* ===========================查询单条记录end=========================== */

	/* ===========================查询列表start=========================== */

	/**
	 * 查询所有记录
	 * 
	 */
	@Override
	public List<T> getAll() {
		return (List<T>) getSession().createCriteria(getEntityClass()).list();
	}

	/**
	 * 根据某一列查询
	 * 
	 */
	@Override
	public List<T> getListByColumn(String columnName, Object value) {
		return (List<T>) getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq(columnName, value)).list();
	}

	/**
	 * 根据Qo对象查询符合查询条件的所有数据
	 * 
	 * @param qo
	 * @return
	 * @throws Exception
	 */

	public List<T> getListByQo(Qo qo) throws Exception {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		QoResolver.resolveCriterion(criteria, qo);
		QoResolver.resolveOrder(criteria, qo);
		return criteria.list();
	}

	/**
	 * 根据Qo对象查询分页数据信息
	 * 
	 * @param qo
	 * @return
	 * @throws Exception
	 */
	public List<T> getPageListByQo(Qo qo) throws Exception {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		QoResolver.resolveCriterion(criteria, qo);
		QoResolver.resolveOrder(criteria, qo);
		QoResolver.resolvePagination(criteria, qo);
		return criteria.list();
	}

	/**
	 * 根据Qo对象查询记录数
	 * 
	 * @param qo
	 * @return
	 * @throws Exception
	 */
	public int getRowCountByQo(Qo qo) throws Exception {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		QoResolver.resolveCriterion(criteria, qo);
		return ((Long) criteria.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
	}

	/* ===========================查询列表end=========================== */

	/* ===========================写操作start=========================== */

	public Serializable save(T t) {
		return getSession().save(t);
	}

	public void update(T t) {
		this.getSession().update(t);
	}

	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	}

	public void delete(T t) {
		this.getSession().delete(t);
	}

	/**
	 * 批量删除（只支持单主键）
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void batchDelete(Serializable... ids) throws Exception {
		if (ids.length > 0) {
			Class<?> entityClass = getEntityClass();
			String hql = "delete from " + entityClass.getSimpleName()
					+ " where " + BeanUtil.getIdName(entityClass)
					+ " in (:ids)";
			executeByHql(hql, "ids", ids);
		}
	}
	public void batchDeleteHql(String columnname,String columnvalue) throws Exception {
		Class<?> entityClass = getEntityClass();
		String hql = "delete from  "+entityClass.getSimpleName()+"  where "+ columnname +"=:xnxq";
		executeByHql(hql, "xnxq",columnvalue);
	}
	
	/**
	 * 批量更新
	 * @param ids
	 * @throws Exception
	 */
	public void batchUpdate(String columnname,String value,Serializable... ids) throws Exception {
		if (ids.length > 0) {
			Class<?> entityClass = getEntityClass();
			String hql = "update " + entityClass.getSimpleName()
					+ "  set "+columnname+"='"+value + "' where "+BeanUtil.getIdName(entityClass)
					+ " in (:ids)";
			executeByHql(hql, "ids", ids);
		}
	}

	/**
	 * 通过hql方式执行删除或者修改操作
	 * 
	 * @param hql
	 * @param name
	 * @param value
	 */
	public void executeByHql(String hql, String name, Object value) {
		Query query = getSession().createQuery(hql);
		if (value.getClass().isArray()) {
			query.setParameterList(name, (Object[]) value);
		} else if (value instanceof Collection) {
			query.setParameterList(name, (Collection<?>) value);
		} else {
			query.setParameter(name, value);
		}
		query.executeUpdate();
	}

	/**
	 * 通过hql方式执行删除或者修改操作
	 * 
	 * @param hql
	 * @param paramMap
	 */
	public void executeByHql(String hql, Map<String, Object> paramMap) {
		Query query = getSession().createQuery(hql);
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value.getClass().isArray()) {
				query.setParameterList(key, (Object[]) value);
			} else if (value instanceof Collection) {
				query.setParameterList(key, (Collection<?>) value);
			} else {
				query.setParameter(key, value);
			}
		}
		query.executeUpdate();
	}

	/* ===========================写操作end=========================== */
	

}
