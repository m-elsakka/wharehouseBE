/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    @Size(max = 50)
    @Column(name = "ITEMSHORTNAMEE")
    @JsonIgnore
    private String itemshortnamee;
    @Size(max = 50)
    @Column(name = "ITEMSHORTNAMEA")
    @JsonIgnore
    private String itemshortnamea;
    @Column(name = "PLT_CRT")
    private Short pltCrt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CRT_X")
    @JsonIgnore
    private BigDecimal crtX;
    @Column(name = "CRT_Y")
    @JsonIgnore
    private BigDecimal crtY;
    @Column(name = "CRT_Z")
    //@JsonIgnore
    private BigDecimal crtZ;
    @Column(name = "NETWEIGHT")
    @JsonIgnore
    private BigDecimal netweight;
    @Column(name = "TOTALWEIGHT")
    //@JsonIgnore
    private BigDecimal totalweight;
    @Size(max = 2)
    @Column(name = "ITEMTYPE")
   // @JsonIgnore
    private String itemtype;
    @Size(max = 5)
    @Column(name = "SKU_TYPENO")
    @JsonIgnore
    private String skuTypeno;
    @Column(name = "PACKET_PLT")
    private Short packetPlt;
    @Size(max = 50)
    @Column(name = "SHORTNAMEE")
    @JsonIgnore
    private String shortnamee;
    @Size(max = 50)
    @Column(name = "SHORTNAMEA")
    @JsonIgnore
    private String shortnamea;
    @Size(max = 50)
    @Column(name = "F1")
    @JsonIgnore
    private String f1;
    @Size(max = 50)
    @Column(name = "F2")
    @JsonIgnore
    private String f2;
    @Size(max = 50)
    @Column(name = "F3")
    @JsonIgnore
    private String f3;
//    @Column(name = "IS_UNILEVER_ITEM")
//    @JsonIgnore
//    private Character isUnileverItem;
    @Size(max = 1)
    @Column(name = "IS_SELLABLE")
    @JsonIgnore
    private String isSellable;
    @Size(max = 100)
    @Column(name = "CRT_BARCODE")
    private String crtBarcode;
//    @Size(max = 100)
//    @Column(name = "PLT_BARCODE")
//    private String pltBarcode;
    /*@JoinColumn(name = "BRANDNO", referencedColumnName = "BRANDNO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Brand brandno;
    @JoinColumn(name = "PACKSIZENO", referencedColumnName = "PACKSIZENO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Packsize packsizeno;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mainItemno",fetch = FetchType.LAZY)
    @JsonIgnore
    private Packsize packsize;*/

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

    public String getItemshortnamee() {
        return itemshortnamee;
    }

    public void setItemshortnamee(String itemshortnamee) {
        this.itemshortnamee = itemshortnamee;
    }

    public String getItemshortnamea() {
        return itemshortnamea;
    }

    public void setItemshortnamea(String itemshortnamea) {
        this.itemshortnamea = itemshortnamea;
    }

    public Short getPltCrt() {
        return pltCrt;
    }

    public void setPltCrt(Short pltCrt) {
        this.pltCrt = pltCrt;
    }

    public BigDecimal getCrtX() {
        return crtX;
    }

    public void setCrtX(BigDecimal crtX) {
        this.crtX = crtX;
    }

    public BigDecimal getCrtY() {
        return crtY;
    }

    public void setCrtY(BigDecimal crtY) {
        this.crtY = crtY;
    }

    public BigDecimal getCrtZ() {
        return crtZ;
    }

    public void setCrtZ(BigDecimal crtZ) {
        this.crtZ = crtZ;
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

    public String getSkuTypeno() {
        return skuTypeno;
    }

    public void setSkuTypeno(String skuTypeno) {
        this.skuTypeno = skuTypeno;
    }

    public Short getPacketPlt() {
        return packetPlt;
    }

    public void setPacketPlt(Short packetPlt) {
        this.packetPlt = packetPlt;
    }

    public String getShortnamee() {
        return shortnamee;
    }

    public void setShortnamee(String shortnamee) {
        this.shortnamee = shortnamee;
    }

    public String getShortnamea() {
        return shortnamea;
    }

    public void setShortnamea(String shortnamea) {
        this.shortnamea = shortnamea;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

//    public Character getIsUnileverItem() {
//        return isUnileverItem;
//    }
//
//    public void setIsUnileverItem(Character isUnileverItem) {
//        this.isUnileverItem = isUnileverItem;
//    }

    public String getIsSellable() {
        return isSellable;
    }

    public void setIsSellable(String isSellable) {
        this.isSellable = isSellable;
    }

    public String getCrtBarcode() {
        return crtBarcode;
    }

    public void setCrtBarcode(String crtBarcode) {
        this.crtBarcode = crtBarcode;
    }

//    public String getPltBarcode() {
//        return pltBarcode;
//    }
//
//    public void setPltBarcode(String pltBarcode) {
//        this.pltBarcode = pltBarcode;
//    }

    /*public Brand getBrandno() {
        return brandno;
    }

    public void setBrandno(Brand brandno) {
        this.brandno = brandno;
    }*/

    /*public Packsize getPacksizeno() {
        return packsizeno;
    }

    public void setPacksizeno(Packsize packsizeno) {
        this.packsizeno = packsizeno;
    }

    public Packsize getPacksize() {
        return packsize;
    }

    public void setPacksize(Packsize packsize) {
        this.packsize = packsize;
    }*/

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
        return "com.unilever.StockKeeper.model.entities.Item[ itemno=" + itemno + " ]";
    }
    
}
