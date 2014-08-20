package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="ORDERITEM")
public class OrderItemEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="ORDERPLANID")
    private String orderplanid;
    
    @Column(name="ORDERITEMNAME")
    private String orderitemname;
   
    @Column(name="CHARGETYPE")
    private String chargetype;
    
    @Column(name="CHARGEMODE")
    private String chargemode;
    
    @Column(name="AMOUNT")
    private String amount;
    
    @Column(name="BILLRUNDATE")
    private String billrundate;
    
    public String getOrderplanid() {
        return orderplanid;
    }
   
    public void setOrderplanid(String orderplanid) {
        this.orderplanid = orderplanid;
    }
    
    public String getOrderitemname() {
        return orderitemname;
    }
   
    public void setOrderitemname(String orderitemname) {
        this.orderitemname = orderitemname;
    }
    
    public String getChargemode() {
        return chargemode;
    }
   
    public void setChargemode(String chargemode) {
        this.chargemode = chargemode;
    }
    
    public String getChargetype() {
        return chargetype;
    }
   
    public void setChargetype(String chargetype) {
        this.chargetype = chargetype;
    }
    
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getBillrundate() {
        return billrundate;
    }
    public void setBillrundate(String billrundate) {
        this.billrundate = billrundate;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
