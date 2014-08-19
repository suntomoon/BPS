package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.ProductEntity;

public class ProductDAOImpl extends RWDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductEntity").list();
	}
	
	@Override
	public void deleteEntity(int entityId) {
		ProductEntity entity = (ProductEntity) sessionFactory.getCurrentSession()
				.load(ProductEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public ProductEntity getEntityById(int entityId) {
		ProductEntity entity = (ProductEntity) sessionFactory.getCurrentSession()
				.load(ProductEntity.class, entityId);
		return entity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}
