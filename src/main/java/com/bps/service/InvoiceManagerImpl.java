package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class InvoiceManagerImpl extends ManagerBase { 
	 public void setInvoiceDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
