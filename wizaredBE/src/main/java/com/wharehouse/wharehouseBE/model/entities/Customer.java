/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed.Gaber
 */
@Entity
@Table(name = "customers")
@XmlRootElement
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "customer_code")
    private String customerno;
    @Size(max = 50)
    @Column(name = "customer_namee")
    private String customernamee;

    
     @Size(max = 50)
    @Column(name = "customer_namea")
    private String customernamea;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCustomernamee() {
        return customernamee;
    }

    public void setCustomernamee(String customernamee) {
        this.customernamee = customernamee;
    }

    public String getCustomernamea() {
        return customernamea;
    }

    public void setCustomernamea(String customernamea) {
        this.customernamea = customernamea;
    }
    
   
     
     
     
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.customerno);
        hash = 73 * hash + Objects.hashCode(this.customernamee);
        hash = 73 * hash + Objects.hashCode(this.customernamea);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerno, other.customerno)) {
            return false;
        }
        if (!Objects.equals(this.customernamea, other.customernamea)) {
            return false;
        }
          if (!Objects.equals(this.customernamee, other.customernamee)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerno=" + customerno + ", customernamea=" + customernamea + '}';
    }
    
    
    
}
