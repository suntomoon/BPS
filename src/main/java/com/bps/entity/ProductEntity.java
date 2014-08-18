package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="PRODUCT")
public class ProductEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="NAME")
    private String productName;
   
    @Column(name="DESCRIPTION")
    private String productDescription;
    
    
    public String getProductName() {
        return productName;
    }
   
    public void setProductName(String name) {
        this.productName = name;
    }
    
    public String getProductDescription() {
        return productDescription;
    }
   
    public void setProductDescription(String name) {
        this.productDescription = name;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
