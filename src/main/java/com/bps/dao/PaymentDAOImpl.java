package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.PaymentEntity;

public class PaymentDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	@Override
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((PaymentEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from PaymentEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		PaymentEntity entity = (PaymentEntity) sessionFactory.getCurrentSession()
				.load(PaymentEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
