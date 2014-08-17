package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.CustomerEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditCustomerAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditCustomerAction.class);
	//List of customers; Setter and Getter are below
	private List<AbstractEntity> customers;
	//Customer object to be added; Setter and Getter are below
	private CustomerEntity customer;
	
	//Customer manager injected by spring context; This is cool !!
	private AbstractManager customerManager;

	//This method return list of customers in database
	public String listCustomers() {
		logger.info("listCustomers method called");
		customers = customerManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a customer object is added
	public String addCustomer() {
		logger.info("addCustomer method called");
		customerManager.addEntity(customer);
		return SUCCESS;
	}

	//Deletes a customer by it's id passed in path parameter
	public String deleteCustomer() {
		logger.info("deleteCustomer method called");
		customerManager.deleteEntity(customer.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		customer = null;
	}

	public void setCustomerManager(AbstractManager customerManager) {
		this.customerManager = customerManager;
	}

	public List<AbstractEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(List<AbstractEntity> customers) {
		this.customers = customers;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
}
