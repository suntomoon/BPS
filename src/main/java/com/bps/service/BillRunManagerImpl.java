package com.bps.service;

import org.springframework.transaction.annotation.Transactional;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.engine.BillRunEngine;
import com.bps.entity.BillRunEntity;

public class BillRunManagerImpl extends ManagerBase {
	@Override
	@Transactional
	public void addEntity(AbstractEntity entity) {
		dao.addEntity(entity);
		BillRunEngine.getInstance().Run((BillRunEntity)entity);
	}
	
	 public void setBillrunDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
