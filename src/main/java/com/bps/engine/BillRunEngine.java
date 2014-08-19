package com.bps.engine;


import java.util.List;

import com.bps.abstarct.AbstractDAO;
import com.bps.abstarct.AbstractEntity;
import com.bps.entity.BillRunEntity;
import com.bps.entity.OrderEntity;
import com.bps.entity.OrderPlanEntity;

public class BillRunEngine {
	private static BillRunEngine instance = new BillRunEngine();
	private static AbstractDAO orderDAO;
	private static AbstractDAO orderplanDAO;
	private static AbstractDAO orderitemDAO;
	private static AbstractDAO invoiceDAO;
	private static AbstractDAO invoiceitemDAO;
	
	public static BillRunEngine getInstance() {
		return instance;
	}
	
	private BillRunEngine() {
		
	}
	
	public static String Run(BillRunEntity entity) {
		// get customer
		// get bill date
		int customerId = Integer.parseInt(entity.getCustomerid().trim());
		String billRunEndDate = entity.getBillrunenddate();
		
		// get order
		List<AbstractEntity> orders = orderDAO.getAllEntity();
		
		if(orders.size() > 0) {
			//Build Invoice
		}
		
		for(AbstractEntity order : orders) {
			List<AbstractEntity> orderplans = orderplanDAO.getAllEntity();
			
			for(AbstractEntity orderplan : orderplans) {
				List<AbstractEntity> orderitems = orderitemDAO.getAllEntity();
				for(AbstractEntity orderitem : orderitems) {
					//Build InvoiceItem
				}
			}
		}
		
		// set status as finished
		// return invoiceid
		
		return null;
	}

}
