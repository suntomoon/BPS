package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.BillRunEntity;

public class BillRunDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from BillRunEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		BillRunEntity entity = (BillRunEntity) sessionFactory.getCurrentSession()
				.load(BillRunEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public BillRunEntity getEntityById(int entityId) {
		BillRunEntity entity = (BillRunEntity) sessionFactory.getCurrentSession()
				.load(BillRunEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
