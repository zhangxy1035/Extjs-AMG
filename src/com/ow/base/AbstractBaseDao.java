package com.ow.base;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.ow.dao.Idao;
import com.ow.util.GetEntityClassUtil;
import com.ow.util.Pager;




public abstract class AbstractBaseDao<T, PK extends Serializable> implements
		BaseDao<T, PK> {
	@Resource
	private Idao<T, PK> iDao;

	private Class<T> entityClass = GetEntityClassUtil
			.getEntityClass(getClass());

	public void save(T entity) {
		iDao.save(entity);
	}

	public void delete(PK... pks) {
		iDao.delete(entityClass, pks);
	}

	public void merge(T entity) {
        iDao.merge(entity);
	}

	public T findById(PK pk) {
		return iDao.findById(entityClass, pk);
	}

	public List<T> findAll(String xql) {
		return iDao.findAll(xql);
	}

	public Pager<T> findByPage(int pageNo, int pageSize, String xql) {
		return iDao.findByPage(pageNo, pageSize, xql);
	}

	public Pager<T> findByPage(int pageNo, int pageSize, Object key, String xql) {
		return iDao.findByPage(pageNo, pageSize, key, xql);
	}

	public Pager<T> findByPage(int pageNo, int pageSize, Object[] keys,
			String xql) {
		return iDao.findByPage(pageNo, pageSize, keys, xql);
	}
	
	public List<T> findAllByKeys(String xql, Object[] keys) {
		return iDao.findAllByKeys(entityClass, xql, keys);
	}
	
	public T findByKeys(String xql, Object[] keys) {
		return iDao.findByKeys(entityClass, xql, keys);
	}
	
	

}
