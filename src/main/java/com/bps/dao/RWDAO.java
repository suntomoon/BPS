package com.bps.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;

public class RWDAO implements AbstractDAO {
	protected SessionFactory sessionFactory;
	
	@Override
	public void addEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void deleteEntity(int entityId) {
		AbstractEntity entity = (AbstractEntity) sessionFactory.getCurrentSession()
				.load(AbstractEntity.class, entityId);
		if (null != entity) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public void updateEntity(AbstractEntity entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);;
	}

	@Override
	public AbstractEntity getEntityById(int entityId) {
		AbstractEntity entity = (AbstractEntity) sessionFactory.getCurrentSession()
				.load(AbstractEntity.class, entityId);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> getAllEntity() {
		return this.sessionFactory.getCurrentSession().createQuery("from AbstractEntity").list();
	}
}
