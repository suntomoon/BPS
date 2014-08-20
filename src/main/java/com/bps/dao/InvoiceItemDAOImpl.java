package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.InvoiceItemEntity;

public class InvoiceItemDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from InvoiceItemEntity").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity(String invoiceId) {
		return this.sessionFactory.getCurrentSession().createQuery("from InvoiceItemEntity where INVOICEID=" + invoiceId).list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		InvoiceItemEntity entity = (InvoiceItemEntity) sessionFactory.getCurrentSession()
				.load(InvoiceItemEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public InvoiceItemEntity getEntityById(int entityId) {
		InvoiceItemEntity entity = (InvoiceItemEntity) sessionFactory.getCurrentSession()
				.load(InvoiceItemEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
