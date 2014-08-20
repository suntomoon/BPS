package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class OrderItemManagerImpl extends ManagerBase {
	public void setOrderitemDAO(AbstractDAO dao) {
		this.dao = dao;
	}
}
