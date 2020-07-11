 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rawan.Ahmed
 */
@Embeddable
public class StkTransDescriptorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TRANS_DESC_CODE")
    private String transDescCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "BRANCHNO")
    private String branchno;

    public StkTransDescriptorPK() {
    }

    public StkTransDescriptorPK(String transDescCode, String branchno) {
        this.transDescCode = transDescCode;
        this.branchno = branchno;
    }

    public String getTransDescCode() {
        return transDescCode;
    }

    public void setTransDescCode(String transDescCode) {
        this.transDescCode = transDescCode;
    }

    public String getBranchno() {
        return branchno;
    }

    public void setBranchno(String branchno) {
        this.branchno = branchno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transDescCode != null ? transDescCode.hashCode() : 0);
        hash += (branchno != null ? branchno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkTransDescriptorPK)) {
            return false;
        }
        StkTransDescriptorPK other = (StkTransDescriptorPK) object;
        if ((this.transDescCode == null && other.transDescCode != null) || (this.transDescCode != null && !this.transDescCode.equals(other.transDescCode))) {
            return false;
        }
        if ((this.branchno == null && other.branchno != null) || (this.branchno != null && !this.branchno.equals(other.branchno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unilever.StockKeeperSAS.model.entities.StkTransDescriptorPK[ transDescCode=" + transDescCode + ", branchno=" + branchno + " ]";
    }
    
}
