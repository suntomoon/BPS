package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.PaymentMethodEntity;

public class PaymentMethodDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	@Override
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((PaymentMethodEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from PaymentMethodEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		PaymentMethodEntity entity = (PaymentMethodEntity) sessionFactory.getCurrentSession()
				.load(PaymentMethodEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
