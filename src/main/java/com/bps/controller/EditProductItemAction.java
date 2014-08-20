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
	private List<AbstractEntity> products;
	private List<AbstractEntity> productrateplans;
	//Product object to be added; Setter and Getter are below
	private ProductItemEntity productitem;
	
	//Productrateplan manager injected by spring context; This is cool !!
	private AbstractManager productitemManager;
	private AbstractManager productManager;
	private AbstractManager productrateplanManager;

	//This method return list of productrateplan in database
	public String listProductitems() {
		logger.info("listProductitems method called");
		productitems = productitemManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a productrateplan object is added
	public String addProductitem() {
		logger.info("addProductitem method called");
		productitemManager.addEntity(productitem);
		return SUCCESS;
	}

	//Deletes a productrateplan by it's id passed in path parameter
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
	public void setProductitemManager(AbstractManager productitemManager) {
		this.productitemManager = productitemManager;
	}

	public List<AbstractEntity> getProductitems() {
		return productitems;
	}

	public void setProductitems(List<AbstractEntity> productitems) {
		this.productitems = productitems;
	}

	public List<AbstractEntity> getProducts() {
		return products;
	}

	public void setProducts(List<AbstractEntity> products) {
		this.products = products;
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

	public AbstractManager getProductManager() {
		return productManager;
	}

	public void setProductManager(AbstractManager productManager) {
		this.productManager = productManager;
	}

	public AbstractManager getProductrateplanManager() {
		return productrateplanManager;
	}

	public void setProductrateplanManager(AbstractManager productrateplanManager) {
		this.productrateplanManager = productrateplanManager;
	}

	public AbstractManager getProductitemManager() {
		return productitemManager;
	}
}
