package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.OrderEntity;

public class OrderDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		OrderEntity entity = (OrderEntity) sessionFactory.getCurrentSession()
				.load(OrderEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public OrderEntity getEntityById(int entityId) {
		OrderEntity entity = (OrderEntity) sessionFactory.getCurrentSession()
				.load(OrderEntity.class, entityId);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<AbstractEntity> getAllEntity(String customerId) {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderEntity where CUSTOMERID=" + customerId).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
