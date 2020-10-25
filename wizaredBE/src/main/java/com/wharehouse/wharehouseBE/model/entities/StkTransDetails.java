/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "STK_TRANS_DETAILS")
@XmlRootElement
public class StkTransDetails extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @EmbeddedId
    protected StkTransDetailsPK stkTransDetailsPK;
    @Column(name = "Q_CRT")
    private Integer qCrt;
    @Size(max = 8)
    @Column(name = "BRANCHNO")
    @JsonIgnore
    private String branchno;

    @JoinColumn(name = "TRANS_NO", referencedColumnName = "TRANS_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private StkTransHeader stkTransHeader;
    @JoinColumn(name = "category_code", referencedColumnName = "category_code", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;

    @Column(name = "weight")
    private Double catWeight;

    @Transient
    private String categoryCode;

    @Transient
    private String categoryNamee;

    @Transient
    private String categoryNamea;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "PRODUCTIONDATE",
                referencedColumnName = "PRODUCTIONDATE")
        ,
      @JoinColumn(name = "category_code", referencedColumnName = "category_code")
        ,
       @JoinColumn(name = "TRANS_NO", referencedColumnName = "TRANS_NO")
    })
    private List<StkTransCategory> stkTransCategoryList;

    public StkTransDetails() {
    }

    public StkTransDetails(StkTransDetailsPK stkTransDetailsPK) {
        this.stkTransDetailsPK = stkTransDetailsPK;
    }

    public StkTransDetails(Date productiondate, String itemno, long transNo) {
        this.stkTransDetailsPK = new StkTransDetailsPK(productiondate, itemno, transNo);
    }

    public StkTransDetailsPK getStkTransDetailsPK() {
        return stkTransDetailsPK;
    }

    public void setStkTransDetailsPK(StkTransDetailsPK stkTransDetailsPK) {
        this.stkTransDetailsPK = stkTransDetailsPK;
    }

    public Integer getqCrt() {
        return qCrt;
    }

    public void setqCrt(Integer qCrt) {
        this.qCrt = qCrt;
    }

    public String getBranchno() {
        return branchno;
    }

    public void setBranchno(String branchno) {
        this.branchno = branchno;
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

    public List<StkTransCategory> getStkTransCategoryList() {
        return stkTransCategoryList;
    }

    public void setStkTransCategoryList(List<StkTransCategory> stkTransCategoryList) {
        this.stkTransCategoryList = stkTransCategoryList;
    }

    public Double getCatWeight() {
        return catWeight;
    }

    public void setCatWeight(Double catWeight) {
        this.catWeight = catWeight;
    }

    public void setCategoryCode(String categoryNumber) {
        this.categoryCode = categoryNumber;
    }

    public String getCategoryCode() {
        if (category != null && category.getCategoryCode() != null) {
            categoryCode = category.getCategoryCode();
        } else if(stkTransDetailsPK!=null){
            categoryCode = stkTransDetailsPK.getCategoryCode();
        }
        return categoryCode;
    }

    public String getCategoryNamee() {
        if (category != null && category.getCategoryNamee() != null) {
            categoryNamee = category.getCategoryNamee();
        }
        return categoryNamee;
    }

    public void setCategoryNamee(String categoryNamee) {
        this.categoryNamee = categoryNamee;
    }

    public String getCategoryNamea() {
        if (category != null && category.getCategoryNamea() != null) {
            categoryNamea = category.getCategoryNamea();
        }
        return categoryNamea;
    }

    public void setCategoryNamea(String categoryNamea) {
        this.categoryNamea = categoryNamea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stkTransDetailsPK != null ? stkTransDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkTransDetails)) {
            return false;
        }
        StkTransDetails other = (StkTransDetails) object;
        if ((this.stkTransDetailsPK == null && other.stkTransDetailsPK != null) || (this.stkTransDetailsPK != null && !this.stkTransDetailsPK.equals(other.stkTransDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.StkTransDetails[ stkTransDetailsPK=" + stkTransDetailsPK + " ]";
    }

}
