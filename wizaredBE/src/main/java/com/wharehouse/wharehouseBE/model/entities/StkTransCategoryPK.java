/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ahmed.Gaber
 */
public class StkTransCategoryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date productiondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_code")
    //@JsonIgnore
    private String categoryCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_NO")
    //@JsonIgnore
    private long transNo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "barcode")
    //@JsonIgnore
    private String barcode;
    

    public Date getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(Date productiondate) {
        this.productiondate = productiondate;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public long getTransNo() {
        return transNo;
    }

    public void setTransNo(long transNo) {
        this.transNo = transNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public StkTransCategoryPK() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.productiondate);
        hash = 97 * hash + Objects.hashCode(this.categoryCode);
        hash = 97 * hash + (int) (this.transNo ^ (this.transNo >>> 32));
        hash = 97 * hash + Objects.hashCode(this.barcode);
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
        final StkTransCategoryPK other = (StkTransCategoryPK) obj;
        if (this.transNo != other.transNo) {
            return false;
        }
        if (!Objects.equals(this.categoryCode, other.categoryCode)) {
            return false;
        }
        if (!Objects.equals(this.barcode, other.barcode)) {
            return false;
        }
        if (!Objects.equals(this.productiondate, other.productiondate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StkTransCategoryPK{" + "productiondate=" + productiondate + ", categoryCode=" + categoryCode + ", transNo=" + transNo + ", barcode=" + barcode + '}';
    }
    
    
    
    
    
}
