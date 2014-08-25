package com.bps.format;

import java.util.List;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFormatStrategy;
import com.bps.entity.InvoiceEntity;

public class TXTFormatStrategy implements AbstractFormatStrategy {

	public TXTFormatStrategy() {
	}

	@Override
	public String format(List<AbstractEntity> entities) {
		StringBuilder sb = new StringBuilder();
		
		for(AbstractEntity entity : entities) {
			InvoiceEntity inv = (InvoiceEntity)entity;
			
			sb.append(inv.getInvoiceid() + " ");
			sb.append(inv.getCustomerid() + " ");
			sb.append(inv.getCustomername() + " ");
			sb.append(inv.getInvoicedate() + " ");
			sb.append(inv.getAmount() + " ");
			sb.append(inv.getBalance());
			sb.append("\r\n");
		}
		
		return sb.toString();
	}

}
