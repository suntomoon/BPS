package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.PaymentMethodEntity;

public class PaymentMethodDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from PaymentMethodEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		PaymentMethodEntity entity = (PaymentMethodEntity) sessionFactory.getCurrentSession()
				.load(PaymentMethodEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public PaymentMethodEntity getEntityById(int entityId) {
		PaymentMethodEntity entity = (PaymentMethodEntity) sessionFactory.getCurrentSession()
				.load(PaymentMethodEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
