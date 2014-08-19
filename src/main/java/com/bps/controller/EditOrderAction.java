package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.OrderEntity;
import com.bps.entity.OrderPlanEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditOrderAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditOrderAction.class);
	//List of orders; Setter and Getter are below
	private List<AbstractEntity> orders;
	private List<AbstractEntity> orderplans;
	private List<AbstractEntity> orderitems;
	//Order object to be added; Setter and Getter are below
	private OrderEntity order;
	
	//Order manager injected by spring context; This is cool !!
	private AbstractManager orderManager;
	private AbstractManager orderplanManager;
	private AbstractManager orderitemManager;

	//This method return list of orders in database
	public String listOrders() {
		logger.info("listOrders method called");
		orders = orderManager.getAllEntity();
		orderplans = orderplanManager.getAllEntity();
		orderitems = orderitemManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a order object is added
	public String addOrder() {
		logger.info("addOrder method called");
		orderManager.addEntity(order);
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
		
}
