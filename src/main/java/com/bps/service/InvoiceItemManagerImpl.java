package com.bps.service;

import com.bps.dao.InvoiceItemDAOImpl;

public class InvoiceItemManagerImpl extends ManagerBase {
	 public void setInvoiceitemDAO(InvoiceItemDAOImpl dao) {
			this.dao = dao;
	 }
}
