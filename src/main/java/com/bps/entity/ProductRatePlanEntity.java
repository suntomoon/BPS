package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="PRODUCTRATEPLAN")
public class ProductRatePlanEntity extends AbstractEntity implements Cloneable {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="PRODUCTID")
    private Integer productid;
    
    @Column(name="PRODUCTNAME")
    private String productname;

	@Column(name="PLANNAME")
    private String productrateplanname;
   
    @Column(name="PLANDESCRIPTION")
    private String productrateplandescription;
    
    public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer id) {
        this.productid = id;
    }
    
    public String getProductrateplanname() {
        return productrateplanname;
    }
   
    public void setProductrateplanname(String name) {
        this.productrateplanname = name;
    }
	public String getProductrateplandescription() {
		return productrateplandescription;
	}
	public void setProductrateplandescription(String productrateplandescription) {
		this.productrateplandescription = productrateplandescription;
	}
    
	public OrderPlanEntity clone () throws CloneNotSupportedException {
		OrderPlanEntity orderplan = (OrderPlanEntity)new ConcreteFactory().createEntity("OrderPlan");
		orderplan.setOrderplanname(this.getProductrateplanname());
		return orderplan;
	}
}
