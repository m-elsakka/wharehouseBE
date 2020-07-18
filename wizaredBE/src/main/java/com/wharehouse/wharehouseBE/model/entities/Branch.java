/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "BRANCH")
@XmlRootElement
public class Branch extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "BRANCHNO")
    private String branchno;
    @Size(max = 50)
    @Column(name = "BRANCHNAMEE")
    private String branchnamee;
    @Size(max = 50)
    @Column(name = "BRANCHNAMEA")
    private String branchnamea;
    @Size(max = 10)
    @Column(name = "SCHEMANAMEE")
    @JsonIgnore
    private String schemanamee;
    @Size(max = 15)
    @Column(name = "IP")
    @JsonIgnore
    private String ip;
    @Size(max = 50)
    @Column(name = "CITY")
    @JsonIgnore
    private String city;
    @Size(max = 15)
    @Column(name = "REGION")
    @JsonIgnore
    private String region;
    @Size(max = 15)
    @Column(name = "TYPE")
    @JsonIgnore
    private String type;
    @Size(max = 1)
    @Column(name = "ACTIVE")
   // @JsonIgnore
    private String active;
    @Size(max = 10)
    @Column(name = "MFG_CODE")
    @JsonIgnore
    private String mfgCode;
    @Basic(optional = false)
   // @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "REP")
    @JsonIgnore
    private String rep;
    @Size(max = 20)
    @Column(name = "PHONE_NO")
    @JsonIgnore
    private String phoneNo;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    @JsonIgnore
    private String address;
    @Size(max = 20)
    @Column(name = "SALES_MANAGER_CODE")
    @JsonIgnore
    private String salesManagerCode;
    @Size(max = 30)
    @Column(name = "HH_ADMIN_PASS")
    @JsonIgnore
    private String hhAdminPass;
    @Size(max = 300)
    @Column(name = "MAINREPTITLE")
    @JsonIgnore
    private String mainreptitle;
    @Size(max = 10)
    @Column(name = "SUBS")
    @JsonIgnore
    private String subs;
//    @Size(max = 1)
//    @Column(name = "SASII")
//    @JsonIgnore
//    private String sasii;
    @Size(max = 20)
    @Column(name = "AREA_MANAGER_CODE")
    @JsonIgnore
    private String areaManagerCode;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date enddate;
//    @Size(max = 10)
//    @Column(name = "SAP_CODE")
//    @JsonIgnore
//    private String sapCode;
//    @Size(max = 3)
//    @Column(name = "CURRENCY")
//    @JsonIgnore
//    private String currency;
//    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "LONGITUDE")
//    @JsonIgnore
//    private Double longitude;
//    @Column(name = "LATITUDE")
//    @JsonIgnore
//    private Double latitude;
//    @Size(max = 2)
//    @Column(name = "ADDEDTAX_EXEMPTED")
//    @JsonIgnore
//    private String addedtaxExempted;
//    @Column(name = "REAL_STARTDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonIgnore
//    private Date realStartdate;
//    @Size(max = 50)
//    @Column(name = "SMS_NAME")
//    @JsonIgnore
//    private String smsName;
//    @Size(max = 1)
//    @Column(name = "STORE_KEPEER_APP")
//    @JsonIgnore
//    private String storeKepeerApp;
//    @Size(max = 1)
//    @Column(name = "SCAN_BARCODE")
//    private String scanBarcode;
//    @Size(max = 1)
//    @Column(name = "IS_QNB_DEAL")
//    @JsonIgnore
//    private String isQnbDeal;
    /*@OneToMany(mappedBy = "branchno")
    @JsonIgnore
    private List<Cars> carsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StkTransDescriptor> stkTransDescriptorList;
    @OneToMany(mappedBy = "branchno",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Drivers> driversList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchno",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StkAccounts> stkAccountsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchno",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StkTransHeader> stkTransHeaderList;*/

    public Branch() {
    }

    public Branch(String branchno) {
        this.branchno = branchno;
    }

    public Branch(String branchno, String rep) {
        this.branchno = branchno;
        this.rep = rep;
    }

    public String getBranchno() {
        return branchno;
    }

    public void setBranchno(String branchno) {
        this.branchno = branchno;
    }

    public String getBranchnamee() {
        return branchnamee;
    }

    public void setBranchnamee(String branchnamee) {
        this.branchnamee = branchnamee;
    }

    public String getBranchnamea() {
        return branchnamea;
    }

    public void setBranchnamea(String branchnamea) {
        this.branchnamea = branchnamea;
    }

    public String getSchemanamee() {
        return schemanamee;
    }

    public void setSchemanamee(String schemanamee) {
        this.schemanamee = schemanamee;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getMfgCode() {
        return mfgCode;
    }

    public void setMfgCode(String mfgCode) {
        this.mfgCode = mfgCode;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalesManagerCode() {
        return salesManagerCode;
    }

    public void setSalesManagerCode(String salesManagerCode) {
        this.salesManagerCode = salesManagerCode;
    }

    public String getHhAdminPass() {
        return hhAdminPass;
    }

    public void setHhAdminPass(String hhAdminPass) {
        this.hhAdminPass = hhAdminPass;
    }

    public String getMainreptitle() {
        return mainreptitle;
    }

    public void setMainreptitle(String mainreptitle) {
        this.mainreptitle = mainreptitle;
    }

    public String getSubs() {
        return subs;
    }

    public void setSubs(String subs) {
        this.subs = subs;
    }

//    public String getSasii() {
//        return sasii;
//    }
//
//    public void setSasii(String sasii) {
//        this.sasii = sasii;
//    }

    public String getAreaManagerCode() {
        return areaManagerCode;
    }

    public void setAreaManagerCode(String areaManagerCode) {
        this.areaManagerCode = areaManagerCode;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

//    public String getSapCode() {
//        return sapCode;
//    }
//
//    public void setSapCode(String sapCode) {
//        this.sapCode = sapCode;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public Double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }
//
//    public Double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getAddedtaxExempted() {
//        return addedtaxExempted;
//    }
//
//    public void setAddedtaxExempted(String addedtaxExempted) {
//        this.addedtaxExempted = addedtaxExempted;
//    }
//
//    public Date getRealStartdate() {
//        return realStartdate;
//    }
//
//    public void setRealStartdate(Date realStartdate) {
//        this.realStartdate = realStartdate;
//    }
//
//    public String getSmsName() {
//        return smsName;
//    }
//
//    public void setSmsName(String smsName) {
//        this.smsName = smsName;
//    }
//
//    public String getStoreKepeerApp() {
//        return storeKepeerApp;
//    }
//
//    public void setStoreKepeerApp(String storeKepeerApp) {
//        this.storeKepeerApp = storeKepeerApp;
//    }
//
//    public String getIsQnbDeal() {
//        return isQnbDeal;
//    }
//
//    public void setIsQnbDeal(String isQnbDeal) {
//        this.isQnbDeal = isQnbDeal;
//    }
//
//    public String getScanBarcode() {
//        return scanBarcode;
//    }
//
//    public void setScanBarcode(String scanBarcode) {
//        this.scanBarcode = scanBarcode;
//    }
    
    /*@XmlTransient
    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }

    @XmlTransient
    public List<StkTransDescriptor> getStkTransDescriptorList() {
        return stkTransDescriptorList;
    }

    public void setStkTransDescriptorList(List<StkTransDescriptor> stkTransDescriptorList) {
        this.stkTransDescriptorList = stkTransDescriptorList;
    }

    @XmlTransient
    public List<Drivers> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<Drivers> driversList) {
        this.driversList = driversList;
    }

    @XmlTransient
    public List<StkAccounts> getStkAccountsList() {
        return stkAccountsList;
    }

    public void setStkAccountsList(List<StkAccounts> stkAccountsList) {
        this.stkAccountsList = stkAccountsList;
    }

    @XmlTransient
    public List<StkTransHeader> getStkTransHeaderList() {
        return stkTransHeaderList;
    }

    public void setStkTransHeaderList(List<StkTransHeader> stkTransHeaderList) {
        this.stkTransHeaderList = stkTransHeaderList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchno != null ? branchno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchno == null && other.branchno != null) || (this.branchno != null && !this.branchno.equals(other.branchno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.model.entities.Branch[ branchno=" + branchno + " ]";
    }
    
}
