package com.bps.engine;


import java.util.Date;
import java.util.List;

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
	private static BillRunEngine instance = new BillRunEngine();
	private static OrderDAOImpl orderDAO;
	private static OrderPlanDAOImpl orderplanDAO;
	private static OrderItemDAOImpl orderitemDAO;
	private static AbstractDAO invoiceDAO;
	private static AbstractDAO invoiceitemDAO;
	
	public static BillRunEngine getInstance() {
		return instance;
	}
	
	private BillRunEngine() {
		
	}
	
	public static String Run(BillRunEntity entity) {
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
				List<AbstractEntity> orderplans = orderplanDAO.getAllEntity(((OrderEntity)order).getId().toString());
				
				for(AbstractEntity orderplan : orderplans) {
					List<AbstractEntity> orderitems = orderitemDAO.getAllEntity(((OrderPlanEntity)orderplan).getId().toString());
					
					for(AbstractEntity orderitem : orderitems) {
						//Build InvoiceItem
						InvoiceItemEntity invItem = new InvoiceItemEntity();
						OrderItemEntity oie = (OrderItemEntity) orderitem;
						if(oie.getChargetype().equalsIgnoreCase("onetime")) {
							if(oie.getBillrundate().trim().isEmpty() || Utils.getDate(oie.getBillrundate()).before(currentBillRunDate)) {
								invItem.setInvoiceitemname(oie.getOrderitemname());
								invItem.setAmount(oie.getAmount());
								
							}
						} else if(oie.getChargetype().equalsIgnoreCase("recurring")) {
							
						}
					}
				}
			}
			
		}
		
		
		
		// set status as completed
		// return invoiceid
		
		return invoiceId;
	}

}
