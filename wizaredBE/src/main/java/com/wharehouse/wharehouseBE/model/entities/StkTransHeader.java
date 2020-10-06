/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wharehouse.wharehouseBE.utils.serializer.JsonDateTimeDeserializer;
import com.wharehouse.wharehouseBE.utils.serializer.JsonDateTimeSerializer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "STK_TRANS_HEADER")
@XmlRootElement
public class StkTransHeader extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_NO")
    private Long transNo;
    @Column(name = "TRANS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date transDate;
    @Size(max = 20)
    @Column(name = "TRANS_REF")
    private String transRef;
    @Column(name = "POST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date postDate;
    @Size(max = 2)
    @Column(name = "STATUS")
    private String status;

    @Size(max = 2)
    @Column(name = "op_type")
    private String opType;

    @Size(max = 100)
    @Column(name = "description")
    private String description;

//    @Size(max = 3)
//    @Column(name = "account_type")
//    private String accountType;
    @JsonIgnore
    @JoinColumn(name = "ACCOUNT_C", referencedColumnName = "cabinet_code", insertable = true, updatable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private StkCabinet accountC;
    @JsonIgnore
    @JoinColumn(name = "ACCOUNT_D", referencedColumnName = "cabinet_code", insertable = true, updatable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private StkCabinet accountD;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(orphanRemoval = true, mappedBy = "stkTransHeader", fetch = FetchType.LAZY)
    private List<StkTransDetails> stkTransDetailsList;
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JsonIgnore
//    @OneToMany(orphanRemoval = true, mappedBy = "stkTransHeader", fetch = FetchType.LAZY)
//    private List<StkTransLoss> stkTransLossList;
    @JsonIgnore
    @JoinColumn(name = "BRANCHNO", referencedColumnName = "BRANCHNO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Branch branchno;

    public StkTransHeader() {
    }

    public StkTransHeader(Long transNo) {
        this.transNo = transNo;
    }

    public Long getTransNo() {
        return transNo;
    }

    public void setTransNo(Long transNo) {
        this.transNo = transNo;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getTransRef() {
        return transRef;
    }

    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StkCabinet getAccountC() {
        return accountC;
    }

    public void setAccountC(StkCabinet accountC) {
        this.accountC = accountC;
    }

    public StkCabinet getAccountD() {
        return accountD;
    }

    public void setAccountD(StkCabinet accountD) {
        this.accountD = accountD;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @XmlTransient
    public List<StkTransDetails> getStkTransDetailsList() {
        return stkTransDetailsList;
    }

    public void setStkTransDetailsList(List<StkTransDetails> stkTransDetailsList) {
        this.stkTransDetailsList = stkTransDetailsList;
    }

    public Branch getBranchno() {
        return branchno;
    }

    public void setBranchno(Branch branchno) {
        this.branchno = branchno;
    }

//    public String getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transNo != null ? transNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkTransHeader)) {
            return false;
        }
        StkTransHeader other = (StkTransHeader) object;
        if ((this.transNo == null && other.transNo != null) || (this.transNo != null && !this.transNo.equals(other.transNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.StkTransHeader[ transNo=" + transNo + " ]";
    }

}
