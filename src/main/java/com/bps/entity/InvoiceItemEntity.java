package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="INVOICEITEM")
public class InvoiceItemEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="INVOICEITEMNAME")
    private String invoiceitemname;
   
    @Column(name="INVOICEID")
    private int invoiceid;
    
    @Column(name="AMOUNT")
    private String amount;
    
    public String getInvoiceitemname() {
        return invoiceitemname;
    }
   
    public void setInvoiceitemname(String invoiceitemname) {
        this.invoiceitemname = invoiceitemname;
    }
     
    public String getAmount() {
        return amount;
    }
   
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public int getInvoiceid() {
        return invoiceid;
    }
   
    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
