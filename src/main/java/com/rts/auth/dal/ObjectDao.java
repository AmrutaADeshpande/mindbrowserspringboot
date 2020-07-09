package com.rts.auth.dal;

import java.io.Serializable;

public interface ObjectDao {

	public void saveObject(Object entity) throws Exception;

	public void deleteObject(Object entity);

	public void updateObject(Object entity);

	public <T> T getObjectByParam(Class<T> entity, String param, Object obj);

	public <T> T getObjectById(Class<T> entity, Serializable id);

	public <T> T listObject(Class<T> entity, String id);

	public <T> T listObjectByParam(Class<T> entity, String param, String orderBy, Object obj);
	
	public <T> T listObjectByParamAsc(Class<T> entity, String param, String orderBy, Object obj);

	public Long listCount(@SuppressWarnings("rawtypes") Class entity);

	public Long listObjectByParamCount(@SuppressWarnings("rawtypes") Class entity, String param, Object obj);
	
	public <T> T getObjectByMultipleParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2);
	
	public void deleteByParam(String table, String param, Long value);
}
