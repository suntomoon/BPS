package com.bps.service;

import com.bps.abstarct.AbstractDAO;

public class PaymentMethodManagerImpl extends ManagerBase {
	 public void setPaymentMethodDAO(AbstractDAO dao) {
			this.dao = dao;
	 }
}
