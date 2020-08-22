/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rawan.Ahmed
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
public class Item extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ITEMNO")
    private String itemno;
    @Size(max = 50)
    @Column(name = "ITEMNAMEE")
    private String itemnamee;
    @Size(max = 50)
    @Column(name = "ITEMNAMEA")
    private String itemnamea;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "NETWEIGHT")
//    @JsonIgnore
    private BigDecimal netweight;
    @Column(name = "TOTALWEIGHT")
    @JsonIgnore
    private BigDecimal totalweight;
    @Size(max = 2)
    @Column(name = "ITEMTYPE")
     @JsonIgnore
    private String itemtype;
 

    @Size(max = 100)
    @Column(name = "CRT_BARCODE")
    private String crtBarcode;

    
     @JoinColumn(name = "cat_no", referencedColumnName = "category_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;
     
    
      @Column(name = "cat_no")
    // @JsonIgnore
    private String categoryno;

    public Item() {
    }

    public Item(String itemno) {
        this.itemno = itemno;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemnamee() {
        return itemnamee;
    }

    public void setItemnamee(String itemnamee) {
        this.itemnamee = itemnamee;
    }

    public String getItemnamea() {
        return itemnamea;
    }

    public void setItemnamea(String itemnamea) {
        this.itemnamea = itemnamea;
    }

 

    public BigDecimal getNetweight() {
        return netweight;
    }

    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }

    public BigDecimal getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(BigDecimal totalweight) {
        this.totalweight = totalweight;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }



    public String getCrtBarcode() {
        return crtBarcode;
    }

    public void setCrtBarcode(String crtBarcode) {
        this.crtBarcode = crtBarcode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(String categoryno) {
        this.categoryno = categoryno;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemno != null ? itemno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemno == null && other.itemno != null) || (this.itemno != null && !this.itemno.equals(other.itemno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.Item[ itemno=" + itemno + " ]";
    }

}
