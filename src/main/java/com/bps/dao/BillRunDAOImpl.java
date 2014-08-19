package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.BillRunEntity;

public class BillRunDAOImpl implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	@Override
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save((BillRunEntity)entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from BillRunEntity").list();
	}

	@Override
	public void deleteEntity(Integer entityId) {
		BillRunEntity entity = (BillRunEntity) sessionFactory.getCurrentSession()
				.load(BillRunEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	 }

}
