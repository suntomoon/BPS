package com.bps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bps.abstarct.AbstractEntity;

@Entity
@Table(name="PAYMENTMETHOD")
public class PaymentMethodEntity extends AbstractEntity {
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="NUMBER")
    private String number;
   
    @Column(name="CARDHOLDER")
    private String cardholder;
    
    @Column(name="VALIDDATE")
    private String validdate;
    
    public String getNumber() {
        return number;
    }
   
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getCardholder() {
        return cardholder;
    }
   
    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }
    
    public String getValiddate() {
        return validdate;
    }
   
    public void setValiddate(String validdate) {
        this.validdate = validdate;
    }
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
