package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class ProductItemManagerImpl extends ManagerBase { 
	 public void setProductitemDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
