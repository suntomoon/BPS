package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.InvoiceEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditInvoiceAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditInvoiceAction.class);
	//List of invoices; Setter and Getter are below
	private List<AbstractEntity> invoices;
	private List<AbstractEntity> invoiceitems;
	//Invoice object to be added; Setter and Getter are below
	private InvoiceEntity invoice;
	
	//Invoice manager injected by spring context; This is cool !!
	private AbstractManager invoiceManager;
	private AbstractManager invoiceitemManager;

	//This method return list of invoices in database
	public String listInvoices() {
		logger.info("listInvoices method called");
		invoices = invoiceManager.getAllEntity();
		return SUCCESS;
	}

	public String listInvoiceitems() {
		logger.info("listInvoiceitems method called");
		
		invoiceitems = invoiceitemManager.getAllEntity(String.valueOf(invoice.getId()));
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		invoice = null;
	}

	public void setInvoiceManager(AbstractManager invoiceManager) {
		this.invoiceManager = invoiceManager;
	}

	public List<AbstractEntity> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<AbstractEntity> invoices) {
		this.invoices = invoices;
	}
	
	public void setInvoiceitemManager(AbstractManager invoiceitemManager) {
		this.invoiceitemManager = invoiceitemManager;
	}

	public List<AbstractEntity> getInvoiceitems() {
		return invoiceitems;
	}

	public void setInvoiceitems(List<AbstractEntity> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public InvoiceEntity getinvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}
}
