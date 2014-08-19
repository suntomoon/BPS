package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="BillRun")
public class BillRunEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="CUSTOMERID")
    private String customerid;
   
    @Column(name="BILLRUNENDDATE")
    private String billrunenddate;
    
    public String getCustomerid() {
        return customerid;
    }
   
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
    
    public String getBillrunenddate() {
        return billrunenddate;
    }
   
    public void setBillrunenddate(String billrunenddate) {
        this.billrunenddate = billrunenddate;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
