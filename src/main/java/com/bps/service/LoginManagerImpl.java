package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class LoginManagerImpl extends ManagerBase {
	 public void setLoginDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
