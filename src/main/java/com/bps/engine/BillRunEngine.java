package com.bps.engine;


import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.dao.OrderDAOImpl;
import com.bps.dao.OrderItemDAOImpl;
import com.bps.dao.OrderPlanDAOImpl;
import com.bps.entity.BillRunEntity;
import com.bps.entity.InvoiceEntity;
import com.bps.entity.InvoiceItemEntity;
import com.bps.entity.OrderEntity;
import com.bps.entity.OrderItemEntity;
import com.bps.entity.OrderPlanEntity;
import com.bps.utils.Utils;

public class BillRunEngine {
	//private static BillRunEngine instance = new BillRunEngine();
	private OrderDAOImpl orderDAO;
	private OrderPlanDAOImpl orderplanDAO;
	private OrderItemDAOImpl orderitemDAO;
	private AbstractDAO invoiceDAO;
	private AbstractDAO invoiceitemDAO;
	
//	public static BillRunEngine getInstance() {
//		return instance;
//	}
//	
//	private BillRunEngine() {
//		
//	}
	
	@Transactional
	public String Run(BillRunEntity entity) {
		// set status as running
		// get customer
		// get bill date
		String billRunEndDate = entity.getBillrunenddate();
		Date currentBillRunDate = Utils.getDate(billRunEndDate);
		
		// get order
		List<AbstractEntity> orders = orderDAO.getAllEntity(entity.getCustomerid().trim());
		
		String invoiceId = "inv-000";
		
		if(orders.size() > 0) {
			//Build Invoice
			InvoiceEntity invoice = new InvoiceEntity();
			invoiceDAO.addEntity(invoice);
			int invId = invoice.getId();
			Double totalAmount = 0.0;
			
			for(AbstractEntity order : orders) {
				OrderEntity oe = (OrderEntity)order;
				List<AbstractEntity> orderplans = orderplanDAO.getAllEntity(oe.getId().toString());
				
				for(AbstractEntity orderplan : orderplans) {
					List<AbstractEntity> orderitems = orderitemDAO.getAllEntity(((OrderPlanEntity)orderplan).getId().toString());
					
					for(AbstractEntity orderitem : orderitems) {
						//Build InvoiceItem
						InvoiceItemEntity invItem = new InvoiceItemEntity();
						OrderItemEntity oie = (OrderItemEntity) orderitem;
						
						invItem.setInvoiceitemname(oie.getOrderitemname());
						invItem.setInvoiceid(invId);
						
						if(oie.getChargetype().equalsIgnoreCase("onetime")) {
							if(oie.getBillrundate().trim().isEmpty() || Utils.getDate(oie.getBillrundate()).before(currentBillRunDate)) {
								// build invItem
								invItem.setAmount(oie.getAmount());
								
								// calculate total amount
								totalAmount += Double.valueOf(oie.getAmount());
							}
						} else if(oie.getChargetype().equalsIgnoreCase("recurring")) {
							int days = 0;
							if(oie.getBillrundate().trim().isEmpty()) {
								days = Utils.getDays(currentBillRunDate, Utils.getDate(oe.getOrderstartdate()));
								Double temp = (Double.valueOf(oie.getAmount())*days);
								
								invItem.setAmount(temp.toString());
								
								totalAmount += temp;
							} else {
								days = Utils.getDays(currentBillRunDate, Utils.getDate(oie.getBillrundate()));
								Double temp = (Double.valueOf(oie.getAmount())*days);
								
								invItem.setAmount(temp.toString());
								
								totalAmount += temp;
							}
							
							// build invItem
							invItem.setAmount(oie.getAmount());
							
							// calculate total amount
							totalAmount += Double.valueOf(oie.getAmount());
						}
						
						invoiceitemDAO.addEntity(invItem);
						
						// update orderItem
						oie.setBillrundate(billRunEndDate);
						orderitemDAO.updateEntity(oie);
					}
				}
			}
			
			invoice.setInvoicedate(Utils.getString(new Date()));
			invoice.setAmount(totalAmount.toString());
			invoice.setInvoiceid("inv-0001");
			invoiceDAO.addEntity(invoice);
		}
		
		
		
		// set status as completed
		// return invoiceid
		
		return invoiceId;
	}
	
	public void setOrderDAO(OrderDAOImpl dao) {
		this.orderDAO = dao;
	}
	
	public void setOrderplanDAO(OrderPlanDAOImpl dao) {
		this.orderplanDAO = dao;
	}
	
	public void setOrderitemDAO(OrderItemDAOImpl dao) {
		this.orderitemDAO = dao;
	}
	
	public void setInvoiceDAO(AbstractDAO dao) {
		this.invoiceDAO = dao;
	}
	
	public void setInvoiceitemDAO(AbstractDAO dao) {
		this.invoiceitemDAO = dao;
	}
}
