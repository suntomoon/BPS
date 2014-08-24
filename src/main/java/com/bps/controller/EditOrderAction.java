package com.bps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFactory;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.ConcreteFactory;
import com.bps.entity.OrderEntity;
import com.bps.entity.OrderItemEntity;
import com.bps.entity.OrderPlanEntity;
import com.bps.entity.ProductEntity;
import com.bps.entity.ProductItemEntity;
import com.bps.entity.ProductRatePlanEntity;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditOrderAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditOrderAction.class);
	//List of orders; Setter and Getter are below
	private List<AbstractEntity> customers;
	private List<AbstractEntity> orders;
	private List<AbstractEntity> orderplans;
	private List<AbstractEntity> orderitems;
	private List<AbstractEntity> products;
	private List<AbstractEntity> productrateplans;
	//Order object to be added; Setter and Getter are below
	private OrderEntity order;
	private ProductEntity product;
	private ProductRatePlanEntity productrateplan;
	private String productId;
	
	//Order manager injected by spring context; This is cool !!
	private AbstractManager customerManager;
	private AbstractManager orderManager;
	private AbstractManager orderplanManager;
	private AbstractManager orderitemManager;
	private AbstractManager productManager;
	private AbstractManager productrateplanManager;
	private AbstractManager productitemManager;

	//This method return list of orders in database
	public String listOrders() {
		logger.info("listOrders method called");
		customers = customerManager.getAllEntity();
		orders = orderManager.getAllEntity();
		orderplans = orderplanManager.getAllEntity();
		orderitems = orderitemManager.getAllEntity();
		products = productManager.getAllEntity();
		productrateplans = productrateplanManager.getAllEntity(((ProductEntity)products.get(0)).getId().toString());
		return SUCCESS;
	}
	
	public String getRatePlans() {
		productrateplans = productrateplanManager.getAllEntity(productId);
		
		Gson gson = new Gson();
		
		HttpServletResponse response = ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
        
        String json = gson.toJson(productrateplans);
	    try {
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return SUCCESS;
	}

	//This method will be called when a order object is added
	public String addOrder() throws Exception {
		logger.info("addOrder method called");
		logger.info("product=" + product.getId());
		logger.info("productrateplan" + productrateplan.getId());
		orderManager.addEntity(order);
		
		productrateplan = (ProductRatePlanEntity)productrateplanManager.getEntityById(productrateplan.getId());
		// insert order plan
		OrderPlanEntity orderplan = productrateplan.clone();
		orderplan.setOrderid(order.getId().toString());
		orderplanManager.addEntity(orderplan);
		
		// insert order item
		List<AbstractEntity> productitems = productitemManager.getAllEntity(productrateplan.getId().toString());
		
		for(AbstractEntity productitem : productitems) {
			ProductItemEntity pi = (ProductItemEntity) productitem;
			OrderItemEntity oie = pi.clone();
			oie.setOrderplanid(orderplan.getId().toString());
			orderitemManager.addEntity(oie);
		}
		
		return SUCCESS;
	}

	//Deletes a order by it's id passed in path parameter
	public String deleteOrder() {
		logger.info("deleteOrder method called");
		orderManager.deleteEntity(order.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		order = null;
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

	// order
	public void setOrderManager(AbstractManager orderManager) {
		this.orderManager = orderManager;
	}

	public List<AbstractEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<AbstractEntity> orders) {
		this.orders = orders;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
	// order plan
	public void setOrderplanManager(AbstractManager orderplanManager) {
		this.orderplanManager = orderplanManager;
	}

	public List<AbstractEntity> getOrderplans() {
		return orderplans;
	}

	public void setOrderplans(List<AbstractEntity> orderplans) {
		this.orderplans = orderplans;
	}

	// order item
	public void setOrderitemManager(AbstractManager orderitemManager) {
		this.orderitemManager = orderitemManager;
	}

	public List<AbstractEntity> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<AbstractEntity> orderitems) {
		this.orderitems = orderitems;
	}
	
	// product
	public void setProductManager(AbstractManager productManager) {
		this.productManager = productManager;
	}

	public List<AbstractEntity> getProducts() {
		return products;
	}

	public void setProducts(List<AbstractEntity> products) {
		this.products = products;
	}
	
	// product rate plan
	public void setProductrateplanManager(AbstractManager productrateplanManager) {
		this.productrateplanManager = productrateplanManager;
	}

	public List<AbstractEntity> getProductrateplans() {
		return productrateplans;
	}

	public void setProductrateplans(List<AbstractEntity> productrateplans) {
		this.productrateplans = productrateplans;
	}
	
	// product item manager
	public void setProductitemManager(AbstractManager productitemManager) {
		this.productitemManager = productitemManager;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	public ProductEntity getProduct() {
		return product;
	}
	
	public void setProductrateplan(ProductRatePlanEntity productrateplan) {
		this.productrateplan = productrateplan;
	}
	
	public ProductRatePlanEntity getProductrateplan() {
		return productrateplan;
	}
}
