package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.LoginEntity;

public class LoginDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from LoginEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		LoginEntity entity = (LoginEntity) sessionFactory.getCurrentSession()
				.load(LoginEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public LoginEntity getEntityById(int entityId) {
		LoginEntity entity = (LoginEntity) sessionFactory.getCurrentSession()
				.load(LoginEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
