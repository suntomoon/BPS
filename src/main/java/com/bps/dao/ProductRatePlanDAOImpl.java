package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.ProductRatePlanEntity;

public class ProductRatePlanDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductRatePlanEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		ProductRatePlanEntity entity = (ProductRatePlanEntity) sessionFactory.getCurrentSession()
				.load(ProductRatePlanEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public ProductRatePlanEntity getEntityById(int entityId) {
		ProductRatePlanEntity entity = (ProductRatePlanEntity) sessionFactory.getCurrentSession()
				.load(ProductRatePlanEntity.class, entityId);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<AbstractEntity> getAllEntity(String productid) {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductRatePlanEntity "
				+ "where PRODUCTID=" + productid).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
