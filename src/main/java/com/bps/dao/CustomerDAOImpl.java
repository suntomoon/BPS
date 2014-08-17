package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.CustomerEntity;

public class CustomerDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	@Override
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((CustomerEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from CustomerEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		CustomerEntity customer = (CustomerEntity) sessionFactory.getCurrentSession()
				.load(CustomerEntity.class, entityId);
		if (null != customer) {
			this.sessionFactory.getCurrentSession().delete(customer);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
