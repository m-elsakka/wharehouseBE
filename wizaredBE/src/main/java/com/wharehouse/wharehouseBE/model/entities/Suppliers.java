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


@Entity
@Table(name = "suppliers")
@XmlRootElement
public class Suppliers extends BaseEntity implements Serializable{
    
     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "supplier_code")
    private String supplier_code;
    @Size(max = 50)
    @Column(name = "supplier_name")
    private String supplier_name;

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.supplier_code);
        hash = 89 * hash + Objects.hashCode(this.supplier_name);
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
        final Suppliers other = (Suppliers) obj;
        if (!Objects.equals(this.supplier_code, other.supplier_code)) {
            return false;
        }
        if (!Objects.equals(this.supplier_name, other.supplier_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "supplier_code=" + supplier_code + ", supplier_name=" + supplier_name + '}';
    }

  
    
    
    
    
}
