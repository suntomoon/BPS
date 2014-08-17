package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="ORDERPLAN")
public class OrderItemEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="ORDERID")
    private String orderid;
   
    @Column(name="ORDERPLANName")
    private String orderplanname;
    
    public String getOrderid() {
        return orderid;
    }
   
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    
    public String getOrderplanname() {
        return orderplanname;
    }
   
    public void setOrderplanname(String orderplanname) {
        this.orderplanname = orderplanname;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
