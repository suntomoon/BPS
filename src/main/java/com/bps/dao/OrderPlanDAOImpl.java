package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.OrderPlanEntity;

public class OrderPlanDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderPlanEntity").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<AbstractEntity> getAllEntity(String orderId) {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderPlanEntity where ORDERID=" + orderId).list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		OrderPlanEntity entity = (OrderPlanEntity) sessionFactory.getCurrentSession()
				.load(OrderPlanEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public OrderPlanEntity getEntityById(int entityId) {
		OrderPlanEntity entity = (OrderPlanEntity) sessionFactory.getCurrentSession()
				.load(OrderPlanEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
