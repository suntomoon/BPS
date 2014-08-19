package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.InvoiceEntity;

public class InvoiceDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from InvoiceEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		InvoiceEntity entity = (InvoiceEntity) sessionFactory.getCurrentSession()
				.load(InvoiceEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public InvoiceEntity getEntityById(int entityId) {
		InvoiceEntity entity = (InvoiceEntity) sessionFactory.getCurrentSession()
				.load(InvoiceEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
