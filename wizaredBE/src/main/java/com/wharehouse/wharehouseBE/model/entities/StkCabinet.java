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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "stk_cabinet")
@XmlRootElement
public class StkCabinet extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cabinet_code")
    private String cabinetno;
    @Size(max = 50)
    @Column(name = "cabinet_namea")
    private String cabinetnamea;
    @Size(max = 50)
    @Column(name = "cabinet_namee")
    private String cabinetnamee;

    @Size(max = 50)
    @Column(name = "DESCREPTION")
    @JsonIgnore
    private String descreption;

    
    @Size(max = 1)
    @Column(name = "ACTIVE")
    private String active;
    /*@OneToMany(mappedBy = "accountC",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StkTransDescriptor> stkTransDescriptorList;
    @OneToMany(mappedBy = "accountD",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StkTransDescriptor> stkTransDescriptorList1;
    @JoinColumn(name = "BRANCHNO", referencedColumnName = "BRANCHNO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JsonIgnore
    private Branch branchno;
    @JoinColumn(name = "GROUP_CODE", referencedColumnName = "GROUP_CODE")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JsonIgnore
    private StkAccountGroup groupCode;*/

    public StkCabinet() {
    }

    public String getCabinetno() {
        return cabinetno;
    }

    public void setCabinetno(String cabinetno) {
        this.cabinetno = cabinetno;
    }

    public String getCabinetnamea() {
        return cabinetnamea;
    }

    public void setCabinetnamea(String cabinetnamea) {
        this.cabinetnamea = cabinetnamea;
    }

    public String getCabinetnamee() {
        return cabinetnamee;
    }

    public void setCabinetnamee(String cabinetnamee) {
        this.cabinetnamee = cabinetnamee;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

  
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
    
    
    /*
    @XmlTransient
    public List<StkTransDescriptor> getStkTransDescriptorList() {
        return stkTransDescriptorList;
    }

    public void setStkTransDescriptorList(List<StkTransDescriptor> stkTransDescriptorList) {
        this.stkTransDescriptorList = stkTransDescriptorList;
    }

    @XmlTransient
    public List<StkTransDescriptor> getStkTransDescriptorList1() {
        return stkTransDescriptorList1;
    }

    public void setStkTransDescriptorList1(List<StkTransDescriptor> stkTransDescriptorList1) {
        this.stkTransDescriptorList1 = stkTransDescriptorList1;
    }

    public Branch getBranchno() {
        return branchno;
    }

    public void setBranchno(Branch branchno) {
        this.branchno = branchno;
    }

    public StkAccountGroup getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(StkAccountGroup groupCode) {
        this.groupCode = groupCode;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabinetno != null ? cabinetno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkCabinet)) {
            return false;
        }
        StkCabinet other = (StkCabinet) object;
        if ((this.cabinetno == null && other.cabinetno != null) || (this.cabinetno != null && !this.cabinetno.equals(other.cabinetno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.StkAccounts[ cabinetno=" + cabinetno + " ]";
    }
    
}
