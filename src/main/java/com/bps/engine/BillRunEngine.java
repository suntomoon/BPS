package com.bps.engine;


import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFactory;
import com.bps.dao.InvoiceDAOImpl;
import com.bps.dao.InvoiceItemDAOImpl;
import com.bps.dao.OrderDAOImpl;
import com.bps.dao.OrderItemDAOImpl;
import com.bps.dao.OrderPlanDAOImpl;
import com.bps.entity.BillRunEntity;
import com.bps.entity.ConcreteFactory;
import com.bps.entity.InvoiceEntity;
import com.bps.entity.InvoiceItemEntity;
import com.bps.entity.OrderEntity;
import com.bps.entity.OrderItemEntity;
import com.bps.entity.OrderPlanEntity;
import com.bps.utils.SpringContextUtil;
import com.bps.utils.Utils;

public class BillRunEngine {
	private static BillRunEngine instance = new BillRunEngine();
	private OrderDAOImpl orderDAO = (OrderDAOImpl) SpringContextUtil.getBean("orderDAO");
	private OrderPlanDAOImpl orderplanDAO = (OrderPlanDAOImpl) SpringContextUtil.getBean("orderplanDAO");
	private OrderItemDAOImpl orderitemDAO = (OrderItemDAOImpl) SpringContextUtil.getBean("orderitemDAO");
	private InvoiceDAOImpl invoiceDAO = (InvoiceDAOImpl) SpringContextUtil.getBean("invoiceDAO");
	private InvoiceItemDAOImpl invoiceitemDAO = (InvoiceItemDAOImpl) SpringContextUtil.getBean("invoiceitemDAO");
	private AbstractFactory factory = new ConcreteFactory();
	
	public static BillRunEngine getInstance() {
		return instance;
	}
	
	private BillRunEngine() {
		
	}
	
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
			buildInvoice(entity, billRunEndDate, currentBillRunDate, orders);
		}
		
		// set status as completed
		// return invoiceid
		
		return invoiceId;
	}

	private void buildInvoice(BillRunEntity entity, String billRunEndDate, Date currentBillRunDate, List<AbstractEntity> orders) {
		InvoiceEntity invoice = (InvoiceEntity)factory.createEntity("Invoice");
		invoiceDAO.addEntity(invoice);
		int invId = invoice.getId();
		Double totalAmount = 0.0;
		
		for(AbstractEntity order : orders) {
			OrderEntity oe = (OrderEntity)order;
			List<AbstractEntity> orderplans = orderplanDAO.getAllEntity(oe.getId().toString());
			
			for(AbstractEntity orderplan : orderplans) {
				List<AbstractEntity> orderitems = orderitemDAO.getAllEntity(((OrderPlanEntity)orderplan).getId().toString());
				
				totalAmount = buildInvoiceItems(billRunEndDate, currentBillRunDate, invId, totalAmount, oe, orderitems);
			}
		}
		
		invoice.setCustomerid(Integer.parseInt(entity.getCustomerid().trim()));
		invoice.setCustomername(entity.getCustomername());
		invoice.setInvoicedate(Utils.getString(new Date()));
		invoice.setAmount(totalAmount.toString());
		invoice.setBalance(totalAmount.toString());
		invoice.setInvoiceid("inv-000" + invId);
		invoiceDAO.addEntity(invoice);
	}

	private Double buildInvoiceItems(String billRunEndDate,
			Date currentBillRunDate, int invId, Double totalAmount,
			OrderEntity oe, List<AbstractEntity> orderitems) {
		for(AbstractEntity orderitem : orderitems) {
			//Build InvoiceItem
			InvoiceItemEntity invItem = (InvoiceItemEntity)factory.createEntity("InvoiceItem");
			OrderItemEntity oie = (OrderItemEntity) orderitem;
			
			invItem.setInvoiceitemname(oie.getOrderitemname());
			invItem.setInvoiceid(invId);
			
			if(oie.getChargetype().equalsIgnoreCase("onetime")) {
				if(oie.getBillrundate() == null || oie.getBillrundate().trim().isEmpty()) {
					// build invItem
					invItem.setAmount(oie.getAmount());
					invItem.setStartdate(billRunEndDate);
					invItem.setEnddate(billRunEndDate);
					
					// calculate total amount
					totalAmount += Double.valueOf(oie.getAmount());
				} else {
					continue;
				}
			} else if(oie.getChargetype().equalsIgnoreCase("recurring")) {
				totalAmount = recurringCalculator(billRunEndDate, currentBillRunDate, totalAmount, oe, invItem, oie);
			}
			
			invItem.setInvoicename("inv-000" + invId);
			invoiceitemDAO.addEntity(invItem);
			
			// update orderItem
			oie.setBillrundate(billRunEndDate);
			orderitemDAO.updateEntity(oie);
		}
		return totalAmount;
	}

	private Double recurringCalculator(String billRunEndDate,
			Date currentBillRunDate, Double totalAmount, OrderEntity oe,
			InvoiceItemEntity invItem, OrderItemEntity oie) {
		int days = 0;
		if(oie.getBillrundate() == null || oie.getBillrundate().trim().isEmpty()) {
			days = Utils.getDays(currentBillRunDate, Utils.getDate(oe.getOrderstartdate()));
			Double temp = (Double.valueOf(oie.getAmount())*days);
			
			invItem.setAmount(temp.toString());
			invItem.setStartdate(Utils.getString(oe.getOrderstartdate(), 1));
			invItem.setEnddate(billRunEndDate);
			
			totalAmount += temp;
		} else {
			days = Utils.getDays(currentBillRunDate, Utils.getDate(oie.getBillrundate()));
			Double temp = (Double.valueOf(oie.getAmount())*days);
			
			invItem.setAmount(temp.toString());
			invItem.setStartdate(Utils.getString(oie.getBillrundate(), 1));
			invItem.setEnddate(billRunEndDate);
			
			totalAmount += temp;
		}
		return totalAmount;
	}
}
