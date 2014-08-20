package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class BillRunManagerImpl extends ManagerBase { 
	 public void setBillrunDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
