package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="PAYMENT")
public class PaymentEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="INVOICEID")
    private String invoiceid;
   
    @Column(name="PAYMENTID")
    private String paymentid;
    
    @Column(name="PAYMENTMETHODID")
    private String paymentmethodid;
    
    @Column(name="PAYMENTDATE")
    private String paymentdate;
    
    @Column(name="AMOUNT")
    private String amount;
    
    public String getInvoiceid() {
        return invoiceid;
    }
   
    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }
    
    public String getPaymentid() {
        return invoiceid;
    }
   
    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }
    
    public String getPaymentmethodid() {
        return paymentmethodid;
    }
   
    public void setPaymentmethodid(String paymentmethodid) {
        this.paymentmethodid = paymentmethodid;
    }
    
    public String getPaymentdate() {
        return paymentdate;
    }
   
    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }
    
    public String getAmount() {
        return amount;
    }
   
    public void setAmount(String amount) {
        this.amount = amount;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
