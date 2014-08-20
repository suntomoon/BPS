package com.bps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;

public class ManagerBase implements AbstractManager {
	protected AbstractDAO dao;

	@Override
	@Transactional
	public void addEntity(AbstractEntity entity) {
		dao.addEntity(entity);
	}

	@Override
	@Transactional
	public void deleteEntity(int entityId) {
		dao.deleteEntity(entityId);
	}

	@Override
	@Transactional
	public void updateEntity(AbstractEntity entity) {
		dao.updateEntity(entity);
	}

	@Override
	@Transactional
	public AbstractEntity getEntityById(int entityId) {
		return dao.getEntityById(entityId);
	}

	@Override
	@Transactional
	public List<AbstractEntity> getAllEntity() {
		return dao.getAllEntity();
	}

	@Override
	@Transactional
	public List<AbstractEntity> getAllEntity(String entityId) {
		return dao.getAllEntity(entityId);
	}
}
