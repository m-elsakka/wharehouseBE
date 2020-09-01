/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wharehouse.wharehouseBE.model.entities.CrudBaseEntity;
import com.wharehouse.wharehouseBE.model.entities.StkCabinet;
import com.wharehouse.wharehouseBE.security.enums.UserLevelEnum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Users")
@XmlRootElement
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "default_gen", sequenceName = "USERS_SEQ", allocationSize = 1)
public class Users extends CrudBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 20)
    @Column(name = "last_name")
    private String lastName;
//
//    @Column(name = "active")
//    private short active;
//
    @Column(name = "is_admin")
    private short isAdmin;
//
//    @Column(name = "job_description")
//    private String jobDescription;
//
    @Column(name = "user_level")
    private Integer userLevelId;

    @JoinColumn(name = "user_level", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserLevel userLevel;
//
//    @Column(name = "line_manager")
//    private Long lineManagerId;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnore
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    // @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinTable(
            name = "user_account",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "account_id", referencedColumnName = "cabinet_code")})
    private List<StkCabinet> stkCabinetList;


    @Column(name = "branchno")
    private String branchNo;

//
//    @Column(name = "is_s2_account")
//    private short isS2Account;
    @Transient
    private boolean activeFlag;

    @Transient
    private boolean isS2AccountFlag;

    @Transient
    private String confirmedPassword;

    @Transient
    @JsonIgnore
    private boolean changePassword;

    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    public List<StkCabinet> getStkCabinetList() {
        return stkCabinetList;
    }

    public void setStkCabinetList(List<StkCabinet> stkCabinetList) {
        this.stkCabinetList = stkCabinetList;
    }

  
    

  

    public Users(Long id, String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public short getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(short isAdmin) {
        this.isAdmin = isAdmin;
    }
//
//    public String getJobDescription() {
//        return jobDescription;
//    }
//
//    public void setJobDescription(String jobDescription) {
//        this.jobDescription = jobDescription;
//    }
//

    public Integer getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Integer userLevelId) {
        this.userLevelId = userLevelId;
    }
//

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }
//
//    public Long getLineManagerId() {
//        return lineManagerId;
//    }
//
//    public void setLineManagerId(Long lineManagerId) {
//        this.lineManagerId = lineManagerId;
//    }

//    public Users getLineManger() {
//        return lineManger;
//    }
//
//    public void setLineManger(Users lineManger) {
//        this.lineManger = lineManger;
//    }
//
//    public List<Users> getSubordinatList() {
//        return subordinatList;
//    }
//
//    public void setSubordinatList(List<Users> subordinatList) {
//        this.subordinatList = subordinatList;
//    }
//
//
    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public static Integer findLineManagerLevel(int level) {
        Integer lineManagerLevel = null;
        if (level == UserLevelEnum.TEAM_LEAD.getLevelNumber()) {
            lineManagerLevel = UserLevelEnum.AREA_SALES_MANANGER.getLevelNumber();
        } else if (level == UserLevelEnum.AREA_SALES_MANANGER.getLevelNumber()) {
            lineManagerLevel = UserLevelEnum.SALES_MANAGER.getLevelNumber();
        } else if (level == UserLevelEnum.SALES_MANAGER.getLevelNumber()) {
            lineManagerLevel = UserLevelEnum.REGION_SALES_MANAGER.getLevelNumber();
        }
        return lineManagerLevel;
    }

    public String getFirstName() {
        return firstName;
    }
//

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

//    public short getActive() {
//        return active;
//    }
//
//    public void setActive(short active) {
//        this.active = active;
//    }
//
//    public short getIsS2Account() {
//        return isS2Account;
//    }
//
//    public void setIsS2Account(short isS2Account) {
//        this.isS2Account = isS2Account;
//    }
//    public boolean isIsS2AccountFlag() {
//        this.isS2AccountFlag = this.getIsS2Account() == 1;
//        return isS2AccountFlag;
//    }
    public void setIsS2AccountFlag(boolean isS2AccountFlag) {
        this.isS2AccountFlag = isS2AccountFlag;
    }

//    public boolean isActiveFlag() {
//        this.activeFlag = this.getActive() == 1;
//        return activeFlag;
//    }
    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getConfirmedPassword() {
        confirmedPassword = password;
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wharehouse.wharehouseBE.security.model.Users[ user_name=" + id + " ]";
    }

}
