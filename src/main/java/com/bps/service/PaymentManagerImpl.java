package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class PaymentManagerImpl extends ManagerBase {
	 public void setPaymentDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
