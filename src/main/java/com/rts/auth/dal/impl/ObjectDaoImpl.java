package com.rts.auth.dal.impl;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rts.auth.dal.AbstractDao;
import com.rts.auth.dal.ObjectDao;

@Transactional
@Repository("objectDao")
public class ObjectDaoImpl extends AbstractDao implements ObjectDao {

	public void saveObject(Object entity) throws Exception {
		persist(entity);
	}

	public void deleteObject(Object entity) {
		delete(entity);
	}

	public void updateObject(Object entity) {
		saveOrUpdate(entity);
	}

	@Override
	public <T> T getObjectById(Class<T> entity, Serializable id) {
		return (T) getSession().get(entity, id);
	}

	@SuppressWarnings("unchecked")
	public <T> T getObjectByParam(Class<T> entity, String param, Object paramValue) {
		Criteria criteria = getSession().createCriteria(entity).add(Restrictions.eq(param, paramValue));
		return (T) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <T> T listObject(Class<T> entity, String id) {
		Criteria criteria = getSession().createCriteria(entity).addOrder(Order.desc(id));
		return (T) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public <T> T listObjectByParam(Class<T> entity, String param, String orderBy, Object obj) {
		Criteria criteria = getSession().createCriteria(entity).add(Restrictions.eq(param, obj))
				.addOrder(Order.desc(orderBy));
		return (T) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T listObjectByParamAsc(Class<T> entity, String param, String orderBy, Object obj) {
		Criteria criteria = getSession().createCriteria(entity).add(Restrictions.eq(param, obj))
				.addOrder(Order.asc(orderBy));
		return (T) criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public Long listCount(Class entity) {
		Criteria crit = getSession().createCriteria(entity);
		crit.setProjection(Projections.rowCount());
		return Long.parseLong(crit.uniqueResult().toString());
	}

	@SuppressWarnings("rawtypes")
	public Long listObjectByParamCount(Class entity, String param, Object obj) {
		Criteria criteria = getSession().createCriteria(entity).add(Restrictions.eq(param, obj));
		criteria.setProjection(Projections.rowCount());
		return Long.parseLong(criteria.uniqueResult().toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObjectByMultipleParam(Class<T> entity, String param1,
			Object obj1, String param2, Object obj2) {
		Criteria criteria = getSession().createCriteria(entity)
				.add(Restrictions.eq(param1, obj1))
				.add(Restrictions.eq(param2, obj2));
		return (T) criteria.uniqueResult();
	}

	@Override
	public void deleteByParam(String table, String param, Long value) {
		try{
			SQLQuery query = getSession().createSQLQuery("DELETE FROM "+table
					+ " WHERE "+param+" =:obj");
			query.setLong("obj", value);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
