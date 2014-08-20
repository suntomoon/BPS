package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.OrderItemEntity;

public class OrderItemDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderItemEntity").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity(String orderPlanId) {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderItemEntity where ORDERPLANID=" + orderPlanId).list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		OrderItemEntity entity = (OrderItemEntity) sessionFactory.getCurrentSession()
				.load(OrderItemEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public OrderItemEntity getEntityById(int entityId) {
		OrderItemEntity entity = (OrderItemEntity) sessionFactory.getCurrentSession()
				.load(OrderItemEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
