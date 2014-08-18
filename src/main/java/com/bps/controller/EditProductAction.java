package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.ProductEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditProductAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditProductAction.class);
	//List of products; Setter and Getter are below
	private List<AbstractEntity> products;
	//Product object to be added; Setter and Getter are below
	private ProductEntity product;
	
	//Product manager injected by spring context; This is cool !!
	private AbstractManager productManager;

	//This method return list of products in database
	public String listProducts() {
		logger.info("listProducts method called");
		products = productManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a product object is added
	public String addProduct() {
		logger.info("addProduct method called");
		productManager.addEntity(product);
		return SUCCESS;
	}

	//Deletes a product by it's id passed in path parameter
	public String deleteProduct() {
		logger.info("deleteProduct method called");
		productManager.deleteEntity(product.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		product = null;
	}

	public void setProductManager(AbstractManager productManager) {
		this.productManager = productManager;
	}

	public List<AbstractEntity> getProducts() {
		return products;
	}

	public void setProducts(List<AbstractEntity> products) {
		this.products = products;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
}
