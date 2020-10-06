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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed.Gaber
 */
@Entity
@Table(name = "stk_details_categeory")
@XmlRootElement
@IdClass(StkTransCategoryPK.class)
public class StkTransCategory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected StkTransCategoryPK stkTransCategoryPK;
//    
    @Id
     @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date productiondate;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_code")
    private String categoryCode;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_NO")
    private Long transNo;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "barcode")
    private String barcode;

    @JsonIgnore
    @JoinColumn(name = "TRANS_NO", referencedColumnName = "TRANS_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StkTransHeader stkTransHeader;

    @JsonIgnore
    @JoinColumn(name = "category_code", referencedColumnName = "category_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;

    @Column(name = "weight")
    private Double weight;

    
    @Column(name = "sequence")
    private Double sequence;
    
     @Column(name = "item_name")
    private String itemName;
     
      @Column(name = "item_code")
    private String itemCode;
    
    
    @JsonIgnore
    @Transient
    private String addedManually;
    
    public StkTransCategory() {
    }



    public StkTransHeader getStkTransHeader() {
        return stkTransHeader;
    }

    public void setStkTransHeader(StkTransHeader stkTransHeader) {
        this.stkTransHeader = stkTransHeader;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

    public Long getTransNo() {
        return transNo;
    }

    public void setTransNo(Long transNo) {
        this.transNo = transNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSequence() {
        return sequence;
    }

    public void setSequence(Double sequence) {
        this.sequence = sequence;
    }

    public String getAddedManually() {
        return addedManually;
    }

    public void setAddedManually(String addedManually) {
        this.addedManually = addedManually;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.productiondate);
        hash = 89 * hash + Objects.hashCode(this.categoryCode);
        hash = 89 * hash + (int) (this.transNo ^ (this.transNo >>> 32));
        hash = 89 * hash + Objects.hashCode(this.barcode);
        hash = 89 * hash + Objects.hashCode(this.stkTransHeader);
        hash = 89 * hash + Objects.hashCode(this.category);
        hash = 89 * hash + Objects.hashCode(this.weight);
        hash = 89 * hash + Objects.hashCode(this.sequence);
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
        final StkTransCategory other = (StkTransCategory) obj;
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
        if (!Objects.equals(this.stkTransHeader, other.stkTransHeader)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.sequence, other.sequence)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StkTransCategory{" + "productiondate=" + productiondate + ", categoryCode=" + categoryCode + ", transNo=" + transNo + ", barcode=" + barcode + ", stkTransHeader=" + stkTransHeader + ", category=" + category + ", weight=" + weight + ", sequence=" + sequence + '}';
    }

    
    
}
