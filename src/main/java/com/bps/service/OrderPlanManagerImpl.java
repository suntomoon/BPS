package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class OrderPlanManagerImpl extends ManagerBase {
	 public void setOrderplanDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
