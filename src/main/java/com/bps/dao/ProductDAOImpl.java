package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.OrderEntity;
import com.bps.entity.ProductEntity;

public class ProductDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((ProductEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		ProductEntity entity = (ProductEntity) sessionFactory.getCurrentSession()
				.load(ProductEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
