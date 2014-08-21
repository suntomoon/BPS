package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="INVOICE")
public class InvoiceEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="INVOICEID")
    private String invoiceid;
   
    @Column(name="INVOICEDATE")
    private String invoicedate;
    
    @Column(name="AMOUNT")
    private String amount;
    
    @Column(name="BALANCE")
    private String balance;
    
    public String getInvoiceid() {
        return invoiceid;
    }
   
    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }
    
    public String getInvoicedate() {
        return invoicedate;
    }
   
    public void setInvoicedate(String invoicedate) {
        this.invoicedate = invoicedate;
    }
    
    public String getAmount() {
        return amount;
    }
   
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getBalance() {
        return amount;
    }
   
    public void setBalance(String balance) {
        this.balance = balance;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
