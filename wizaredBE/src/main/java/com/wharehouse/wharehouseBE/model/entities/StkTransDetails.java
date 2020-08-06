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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rawan.Ahmed
 */
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "Q_PLT")
//    private BigDecimal qPlt;
    @Size(max = 8)
    @Column(name = "BRANCHNO")
    @JsonIgnore
    private String branchno;
    @Column(name = "ITEMPRICE")
    @JsonIgnore
    private BigDecimal itemprice;
    @Column(name = "ACC_Q_CRT")
    @JsonIgnore
    private Integer accQCrt;
//    @Column(name = "ACC_Q_PLT")
    //@JsonIgnore
//    private BigDecimal accQPlt;
//    @Size(max = 300)
//    @Column(name = "STORE_KEPPER_COMMENTS")
//    private String storeKepperComments;
    @JoinColumn(name = "TRANS_NO", referencedColumnName = "TRANS_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private StkTransHeader stkTransHeader;
    @JoinColumn(name = "ITEMNO", referencedColumnName = "ITEMNO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    //@JsonIgnore
    private Item itemno;
    
    @Transient
    @JsonIgnore
    private String itemNumber;

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

    public Integer getQCrt() {
        return qCrt;
    }

    public void setQCrt(Integer qCrt) {
        this.qCrt = qCrt;
    }

//    public BigDecimal getQPlt() {
//        return qPlt;
//    }
//
//    public void setQPlt(BigDecimal qPlt) {
//        this.qPlt = qPlt;
//    }

    public String getBranchno() {
        return branchno;
    }

    public void setBranchno(String branchno) {
        this.branchno = branchno;
    }

    public BigDecimal getItemprice() {
        return itemprice;
    }

    public void setItemprice(BigDecimal itemprice) {
        this.itemprice = itemprice;
    }

    public Integer getAccQCrt() {
        return accQCrt;
    }

    public void setAccQCrt(Integer accQCrt) {
        this.accQCrt = accQCrt;
    }

//    public BigDecimal getAccQPlt() {
//        return accQPlt;
//    }
//
//    public void setAccQPlt(BigDecimal accQPlt) {
//        this.accQPlt = accQPlt;
//    }

//    public String getStoreKepperComments() {
//        return storeKepperComments;
//    }
//
//    public void setStoreKepperComments(String storeKepperComments) {
//        this.storeKepperComments = storeKepperComments;
//    }

    public StkTransHeader getStkTransHeader() {
        return stkTransHeader;
    }

    public void setStkTransHeader(StkTransHeader stkTransHeader) {
        this.stkTransHeader = stkTransHeader;
    }

    public Item getItemno() {
        return itemno;
    }

    public void setItemno(Item itemno) {
        this.itemno = itemno;
    }

    public Integer getqCrt() {
        return qCrt;
    }

    public void setqCrt(Integer qCrt) {
        this.qCrt = qCrt;
    }

//    public BigDecimal getqPlt() {
//        return qPlt;
//    }
//
//    public void setqPlt(BigDecimal qPlt) {
//        this.qPlt = qPlt;
//    }

    public String getItemNumber() {
        if(itemno != null && itemno.getItemno() != null){
            itemNumber = itemno.getItemno();
        }else{
            itemNumber = stkTransDetailsPK.getItemno();
        }
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
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
