package com.bps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;

public class ProductRatePlanManagerImpl implements AbstractManager {
	 protected AbstractDAO dao;
	 
	 @Transactional
	 public void addEntity(AbstractEntity entity) {
		 dao.addEntity(entity);
	 }
	 
	 @Transactional
	 public List<AbstractEntity> getAllEntity() {
		 return dao.getAllEntity();
	 }
	 
	 @Transactional
	 public void deleteEntity(Integer entityId) {
		 dao.deleteEntity(entityId);
	 }
	 
	 public void setProductrateplanDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
