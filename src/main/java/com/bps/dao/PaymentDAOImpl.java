package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.PaymentEntity;

public class PaymentDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from PaymentEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		PaymentEntity entity = (PaymentEntity) sessionFactory.getCurrentSession()
				.load(PaymentEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public PaymentEntity getEntityById(int entityId) {
		PaymentEntity entity = (PaymentEntity) sessionFactory.getCurrentSession()
				.load(PaymentEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
