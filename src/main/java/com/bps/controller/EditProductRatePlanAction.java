package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.ProductRatePlanEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditProductRatePlanAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditProductRatePlanAction.class);
	//List of products; Setter and Getter are below
	private List<AbstractEntity> productrateplans;
	//Product object to be added; Setter and Getter are below
	private ProductRatePlanEntity productrateplan;
	
	//Productrateplan manager injected by spring context; This is cool !!
	private AbstractManager productrateplanManager;

	//This method return list of productrateplan in database
	public String listProductrateplans() {
		logger.info("listProductrateplans method called");
		productrateplans = productrateplanManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a productrateplan object is added
	public String addProductrateplan() {
		logger.info("addProductrateplan method called");
		productrateplanManager.addEntity(productrateplan);
		return SUCCESS;
	}

	//Deletes a productrateplan by it's id passed in path parameter
	public String deleteProductrateplan() {
		logger.info("deleteProductrateplan method called");
		productrateplanManager.deleteEntity(productrateplan.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		productrateplan = null;
	}
	
	/**
	 *Setters & getters 
	 */
	public List<AbstractEntity> getProductrateplans() {
		return productrateplans;
	}

	public void setProductrateplans(List<AbstractEntity> productrateplans) {
		this.productrateplans = productrateplans;
	}

	public ProductRatePlanEntity getProductrateplan() {
		return productrateplan;
	}

	public void setProductrateplan(ProductRatePlanEntity productrateplan) {
		this.productrateplan = productrateplan;
	}

	public AbstractManager getProductrateplanManager() {
		return productrateplanManager;
	}

	public void setProductrateplanManager(AbstractManager productrateplanManager) {
		this.productrateplanManager = productrateplanManager;
	}

}
