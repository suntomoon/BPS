package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class ProductManagerImpl extends ManagerBase {
	 public void setProductDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
