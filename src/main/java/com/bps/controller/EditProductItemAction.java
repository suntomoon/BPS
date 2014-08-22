package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.ProductItemEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditProductItemAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditProductItemAction.class);
	//List of products; Setter and Getter are below
	private List<AbstractEntity> productitems;
	private List<AbstractEntity> productrateplans;
	//Product object to be added; Setter and Getter are below
	private ProductItemEntity productitem;
	
	//productitemManager manager injected by spring context; This is cool !!
	private AbstractManager productitemManager;
	private AbstractManager productrateplanManager;

	//This method return list of productitemManager in database
	public String listProductitems() {
		logger.info("listProductitems method called");
		productitems = productitemManager.getAllEntity();
		productrateplans = productrateplanManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a productitemManager object is added
	public String addProductitem() {
		logger.info("addProductitem method called");
		productitemManager.addEntity(productitem);
		return SUCCESS;
	}

	//Deletes a productitemManager by it's id passed in path parameter
	public String deleteProductitem() {
		logger.info("deleteProductitem method called");
		productitemManager.deleteEntity(productitem.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		productitem = null;
	}

	/**
	 *Setters & getters 
	 */
	public List<AbstractEntity> getProductitems() {
		return productitems;
	}

	public void setProductitems(List<AbstractEntity> productitems) {
		this.productitems = productitems;
	}

	public List<AbstractEntity> getProductrateplans() {
		return productrateplans;
	}

	public void setProductrateplans(List<AbstractEntity> productrateplans) {
		this.productrateplans = productrateplans;
	}

	public ProductItemEntity getProductitem() {
		return productitem;
	}

	public void setProductitem(ProductItemEntity productitem) {
		this.productitem = productitem;
	}

	public AbstractManager getProductitemManager() {
		return productitemManager;
	}

	public void setProductitemManager(AbstractManager productitemManager) {
		this.productitemManager = productitemManager;
	}

	public AbstractManager getProductrateplanManager() {
		return productrateplanManager;
	}

	public void setProductrateplanManager(AbstractManager productrateplanManager) {
		this.productrateplanManager = productrateplanManager;
	}



	
}
