package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.ProductRatePlanEntity;

public class ProductRatePlanDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((ProductRatePlanEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from ProductRatePlanEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		ProductRatePlanEntity entity = (ProductRatePlanEntity) sessionFactory.getCurrentSession()
				.load(ProductRatePlanEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
