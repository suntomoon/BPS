package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class LoginManagerImpl extends ManagerBase {
	 public void setProductDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
