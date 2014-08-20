package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class OrderManagerImpl extends ManagerBase {
	 public void setOrderDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
