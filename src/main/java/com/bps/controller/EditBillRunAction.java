package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.BillRunEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditBillRunAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditBillRunAction.class);
	//List of billruns; Setter and Getter are below
	private List<AbstractEntity> customers;
	private List<AbstractEntity> billruns;
	//BillRun object to be added; Setter and Getter are below
	private BillRunEntity billrun;
	
	//BillRun manager injected by spring context; This is cool !!
	private AbstractManager customerManager;
	private AbstractManager billrunManager;

	//This method return list of billruns in database
	public String listBillruns() {
		logger.info("listBillRuns method called");
		billruns = billrunManager.getAllEntity();
		customers = customerManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a billrun object is added
	public String addBillrun() {
		logger.info("addBillRun method called");
		billrunManager.addEntity(billrun);
		return SUCCESS;
	}

	//Deletes a billrun by it's id passed in path parameter
	public String deleteBillrun() {
		logger.info("deleteBillRun method called");
		billrunManager.deleteEntity(billrun.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		billrun = null;
	}

	// customer
	public void setCustomerManager(AbstractManager customerManager) {
		this.customerManager = customerManager;
	}

	public List<AbstractEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(List<AbstractEntity> customers) {
		this.customers = customers;
	}
	
	// bill run
	public void setBillrunManager(AbstractManager billrunManager) {
		this.billrunManager = billrunManager;
	}

	public List<AbstractEntity> getBillruns() {
		return billruns;
	}

	public void setBillruns(List<AbstractEntity> billruns) {
		this.billruns = billruns;
	}

	public BillRunEntity getBillrun() {
		return billrun;
	}

	public void setBillrun(BillRunEntity billrun) {
		this.billrun = billrun;
	}
}
