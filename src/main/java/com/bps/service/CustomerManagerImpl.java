package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class CustomerManagerImpl extends ManagerBase {
	 public void setCustomerDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
