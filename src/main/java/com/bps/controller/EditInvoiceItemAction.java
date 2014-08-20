package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.entity.InvoiceItemEntity;
import com.bps.service.InvoiceItemManagerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditInvoiceItemAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditInvoiceItemAction.class);
	//List of invoiceitems; Setter and Getter are below
	private List<AbstractEntity> invoiceitems;
	//Invoiceitem object to be added; Setter and Getter are below
	private InvoiceItemEntity invoiceitem;
	private int invoiceId;
	
	//Invoiceitem manager injected by spring context; This is cool !!
	private InvoiceItemManagerImpl invoiceitemManager;

	//This method return list of invoiceitems in database
	public String listInvoiceitems() {
		logger.info("listInvoiceitems method called");
		invoiceitems = invoiceitemManager.getAllEntity(String.valueOf(invoiceId));
		return SUCCESS;
	}

	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		invoiceitem = null;
	}

	public void setInvoiceitemManager(InvoiceItemManagerImpl invoiceitemManager) {
		this.invoiceitemManager = invoiceitemManager;
	}

	public List<AbstractEntity> getInvoiceitems() {
		return invoiceitems;
	}

	public void setInvoiceitems(List<AbstractEntity> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public InvoiceItemEntity getinvoiceitem() {
		return invoiceitem;
	}

	public void setInvoiceitem(InvoiceItemEntity invoiceitem) {
		this.invoiceitem = invoiceitem;
	}
}
