package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.ProductItemEntity;

public class ProductItemDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((ProductItemEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductItemEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		ProductItemEntity entity = (ProductItemEntity) sessionFactory.getCurrentSession()
				.load(ProductItemEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
