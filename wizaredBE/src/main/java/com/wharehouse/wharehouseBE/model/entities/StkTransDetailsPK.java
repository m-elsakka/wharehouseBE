/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class StkTransDetailsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date productiondate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "category_code")
    @JsonIgnore
    private String categoryCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_NO")
    @JsonIgnore
    private long transNo;

    public StkTransDetailsPK() {
    }

    public StkTransDetailsPK(Date productiondate, String categoryCode, long transNo) {
        this.productiondate = productiondate;
        this.categoryCode = categoryCode;
        this.transNo = transNo;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productiondate != null ? productiondate.hashCode() : 0);
        hash += (categoryCode != null ? categoryCode.hashCode() : 0);
        hash += (int) transNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkTransDetailsPK)) {
            return false;
        }
        StkTransDetailsPK other = (StkTransDetailsPK) object;
        if ((this.productiondate == null && other.productiondate != null) || (this.productiondate != null && !this.productiondate.equals(other.productiondate))) {
            return false;
        }
        if ((this.categoryCode == null && other.categoryCode != null) || (this.categoryCode != null && !this.categoryCode.equals(other.categoryCode))) {
            return false;
        }
        if (this.transNo != other.transNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.StkTransDetailsPK[ productiondate=" + productiondate + ", itemno=" + categoryCode + ", transNo=" + transNo + " ]";
    }
    
}
