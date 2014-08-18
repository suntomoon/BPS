package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="ORDERTABLE")
public class OrderEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="CUSTOMERID")
    private String customerid;
   
    @Column(name="ORDERSTARTDATE")
    private String orderstartdate;
    
    @Column(name="ORDERENDDATE")
    private String orderenddate;
    
    public String getCustomerid() {
        return customerid;
    }
   
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
    
    public String getOrderstartdate() {
        return orderstartdate;
    }
   
    public void setOrderstartdate(String orderstartdate) {
        this.orderstartdate = orderstartdate;
    }
    
    public String getOrderenddate() {
        return orderstartdate;
    }
   
    public void setOrderenddate(String orderenddate) {
        this.orderenddate = orderenddate;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
