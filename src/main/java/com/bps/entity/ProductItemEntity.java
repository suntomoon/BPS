package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="PRODUCTITEM")
public class ProductItemEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="PLANID")
    private Integer planid;
    
    @Column(name="PLANNAME")
    private String planname;
    
    @Column(name="ITEMNAME")
    private String itemname;

	@Column(name="CHARGEMODEL")
    private String itemchargemodel;
   
    @Column(name="CHARGETYPE")
    private String itemchargetype;
    
    @Column(name="AMOUNT")
    private String itemamount;

	@Column(name="PRODUCTITEMDESCRIPTION")
    private String itemdescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}
	
	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public String getItemamount() {
		return itemamount;
	}

	public void setItemamount(String itemamount) {
		this.itemamount = itemamount;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemchargemodel() {
		return itemchargemodel;
	}

	public void setItemchargemodel(String itemchargemodel) {
		this.itemchargemodel = itemchargemodel;
	}

	public String getItemchargetype() {
		return itemchargetype;
	}

	public void setItemchargetype(String itemchargetype) {
		this.itemchargetype = itemchargetype;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

    
}
