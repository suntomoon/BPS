package com.bps.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFormat;
import com.bps.abstarct.AbstractFormatStrategy;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.InvoiceEntity;
import com.bps.format.ConcreteFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditInvoiceAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditInvoiceAction.class);
	//List of invoices; Setter and Getter are below
	private List<AbstractEntity> invoices;
	private List<AbstractEntity> invoiceitems;
	//Invoice object to be added; Setter and Getter are below
	private InvoiceEntity invoice;
	private String formattype;
	
	//Invoice manager injected by spring context; This is cool !!
	private AbstractManager invoiceManager;
	private AbstractManager invoiceitemManager;
	private AbstractFormat formatter;

	//This method return list of invoices in database
	public String listInvoices() {
		logger.info("listInvoices method called");
		invoices = invoiceManager.getAllEntity();
		return SUCCESS;
	}

	public String listInvoiceitems() {
		logger.info("listInvoiceitems method called");
		
		invoiceitems = invoiceitemManager.getAllEntity(String.valueOf(invoice.getId()));
		return SUCCESS;
	}
	
	public String downloadInvoice() {
		invoices = invoiceManager.getAllEntity();
		String filename="";
		String[] formatmapping = {"TXT","CSV","PDF"};
		HttpServletResponse response = ServletActionContext.getResponse();  
		response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        
	    try {
	    	int index = Integer.parseInt(formattype) - 1;
	    	
	    	filename = "Invoice." + formatmapping[index].toLowerCase();
	    	
	    	formatter.setFormatStrategy((AbstractFormatStrategy)Class.forName("com.bps.format." + 
	    			formatmapping[index] + "FormatStrategy").newInstance());
	    	
	    	response.setHeader("Content-Disposition", "attachment;filename=" + filename);
	    	
			PrintWriter pw = response.getWriter();
			pw.print(formatter.format(invoices));
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		invoice = null;
		formatter = new ConcreteFormat();
	}

	public void setInvoiceManager(AbstractManager invoiceManager) {
		this.invoiceManager = invoiceManager;
	}

	public List<AbstractEntity> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<AbstractEntity> invoices) {
		this.invoices = invoices;
	}
	
	public void setInvoiceitemManager(AbstractManager invoiceitemManager) {
		this.invoiceitemManager = invoiceitemManager;
	}

	public List<AbstractEntity> getInvoiceitems() {
		return invoiceitems;
	}

	public void setInvoiceitems(List<AbstractEntity> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public InvoiceEntity getinvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}
	
	public String getFormattype() {
		return formattype;
	}
	
	public void setFormattype(String formattype) {
		this.formattype = formattype;
	}
}
