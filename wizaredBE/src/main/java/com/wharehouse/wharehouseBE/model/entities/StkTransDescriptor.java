/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rawan.Ahmed
 */
@Entity
@Table(name = "STK_TRANS_DESCRIPTOR")
@XmlRootElement
public class StkTransDescriptor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StkTransDescriptorPK stkTransDescriptorPK;
    @Size(max = 50)
    @Column(name = "TRANS_DESC_NAMEA")
    private String transDescNamea;
    @Size(max = 50)
    @Column(name = "TRANS_DESC_NAMEE")
    private String transDescNamee;
    @Size(max = 50)
    @Column(name = "TRANS_DESC_TITLEA")
    private String transDescTitlea;
    @Size(max = 50)
    @Column(name = "TRANS_DESC_TITLEE")
    private String transDescTitlee;
    @Column(name = "APPLY_DEFA_C_ACC")
    private Character applyDefaCAcc;
    @Column(name = "APPLY_DEFA_D_ACC")
    private Character applyDefaDAcc;
    @Size(max = 15)
    @Column(name = "DEFA_C_GROUP")
    private String defaCGroup;
    @Size(max = 15)
    @Column(name = "DEFA_D_GROUP")
    private String defaDGroup;
    @Column(name = "PACKINGSLIP_OPERATION")
    private Character packingslipOperation;
    @Column(name = "ONE_SIDE")
    private Character oneSide;
    @Column(name = "HAS_CAR")
    private Character hasCar;
    @JoinColumn(name = "BRANCHNO", referencedColumnName = "BRANCHNO", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Branch branch;
    @JoinColumn(name = "ACCOUNT_C", referencedColumnName = "ACCOUNT_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private StkAccounts accountC;
    @JoinColumn(name = "ACCOUNT_D", referencedColumnName = "ACCOUNT_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private StkAccounts accountD;
//    @JoinColumn(name = "FORMAT_NO", referencedColumnName = "FORMAT_NO")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private StkFormatPosition formatNo;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "stkTransDescriptor",fetch = FetchType.LAZY)
    private List<StkTransHeader> stkTransHeaderList;*/

    public StkTransDescriptor() {
    }

    public StkTransDescriptor(StkTransDescriptorPK stkTransDescriptorPK) {
        this.stkTransDescriptorPK = stkTransDescriptorPK;
    }

    public StkTransDescriptor(String transDescCode, String branchno) {
        this.stkTransDescriptorPK = new StkTransDescriptorPK(transDescCode, branchno);
    }

    public StkTransDescriptorPK getStkTransDescriptorPK() {
        return stkTransDescriptorPK;
    }

    public void setStkTransDescriptorPK(StkTransDescriptorPK stkTransDescriptorPK) {
        this.stkTransDescriptorPK = stkTransDescriptorPK;
    }

    public String getTransDescNamea() {
        return transDescNamea;
    }

    public void setTransDescNamea(String transDescNamea) {
        this.transDescNamea = transDescNamea;
    }

    public String getTransDescNamee() {
        return transDescNamee;
    }

    public void setTransDescNamee(String transDescNamee) {
        this.transDescNamee = transDescNamee;
    }

    public String getTransDescTitlea() {
        return transDescTitlea;
    }

    public void setTransDescTitlea(String transDescTitlea) {
        this.transDescTitlea = transDescTitlea;
    }

    public String getTransDescTitlee() {
        return transDescTitlee;
    }

    public void setTransDescTitlee(String transDescTitlee) {
        this.transDescTitlee = transDescTitlee;
    }

    public Character getApplyDefaCAcc() {
        return applyDefaCAcc;
    }

    public void setApplyDefaCAcc(Character applyDefaCAcc) {
        this.applyDefaCAcc = applyDefaCAcc;
    }

    public Character getApplyDefaDAcc() {
        return applyDefaDAcc;
    }

    public void setApplyDefaDAcc(Character applyDefaDAcc) {
        this.applyDefaDAcc = applyDefaDAcc;
    }

    public String getDefaCGroup() {
        return defaCGroup;
    }

    public void setDefaCGroup(String defaCGroup) {
        this.defaCGroup = defaCGroup;
    }

    public String getDefaDGroup() {
        return defaDGroup;
    }

    public void setDefaDGroup(String defaDGroup) {
        this.defaDGroup = defaDGroup;
    }

    public Character getPackingslipOperation() {
        return packingslipOperation;
    }

    public void setPackingslipOperation(Character packingslipOperation) {
        this.packingslipOperation = packingslipOperation;
    }

    public Character getOneSide() {
        return oneSide;
    }

    public void setOneSide(Character oneSide) {
        this.oneSide = oneSide;
    }

    public Character getHasCar() {
        return hasCar;
    }

    public void setHasCar(Character hasCar) {
        this.hasCar = hasCar;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public StkAccounts getAccountC() {
        return accountC;
    }

    public void setAccountC(StkAccounts accountC) {
        this.accountC = accountC;
    }

    public StkAccounts getAccountD() {
        return accountD;
    }

    public void setAccountD(StkAccounts accountD) {
        this.accountD = accountD;
    }

//    public StkFormatPosition getFormatNo() {
//        return formatNo;
//    }
//
//    public void setFormatNo(StkFormatPosition formatNo) {
//        this.formatNo = formatNo;
//    }

    /*@XmlTransient
    public List<StkTransHeader> getStkTransHeaderList() {
        return stkTransHeaderList;
    }

    public void setStkTransHeaderList(List<StkTransHeader> stkTransHeaderList) {
        this.stkTransHeaderList = stkTransHeaderList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stkTransDescriptorPK != null ? stkTransDescriptorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkTransDescriptor)) {
            return false;
        }
        StkTransDescriptor other = (StkTransDescriptor) object;
        if ((this.stkTransDescriptorPK == null && other.stkTransDescriptorPK != null) || (this.stkTransDescriptorPK != null && !this.stkTransDescriptorPK.equals(other.stkTransDescriptorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unilever.StockKeeperSAS.model.entities.StkTransDescriptor[ stkTransDescriptorPK=" + stkTransDescriptorPK + " ]";
    }
    
}
