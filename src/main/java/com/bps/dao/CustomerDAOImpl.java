package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.CustomerEntity;

public class CustomerDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from CustomerEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		CustomerEntity entity = (CustomerEntity) sessionFactory.getCurrentSession()
				.load(CustomerEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public CustomerEntity getEntityById(int entityId) {
		CustomerEntity entity = (CustomerEntity) sessionFactory.getCurrentSession()
				.load(CustomerEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
