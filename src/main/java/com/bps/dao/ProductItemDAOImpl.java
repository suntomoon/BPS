package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.ProductItemEntity;

public class ProductItemDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductItemEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		ProductItemEntity entity = (ProductItemEntity) sessionFactory.getCurrentSession()
				.load(ProductItemEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public ProductItemEntity getEntityById(int entityId) {
		ProductItemEntity entity = (ProductItemEntity) sessionFactory.getCurrentSession()
				.load(ProductItemEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
