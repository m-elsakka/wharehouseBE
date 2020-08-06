package com.wharehouse.wharehouseBE.security.model.pojo;

import com.wharehouse.wharehouseBE.model.entities.StkAccounts;
import com.wharehouse.wharehouseBE.security.model.entities.Authority;
import java.util.List;

public class UserLoginResponse {

    private String token;
    private String fullName;
    private String branchno;
    private Long id;
    private List<Authority> authorities;
    private List<StkAccounts> stkAccountses;

    public UserLoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getBranchno() {
        return branchno;
    }

    public void setBranchno(String branchno) {
        this.branchno = branchno;
    }

    public List<StkAccounts> getStkAccountses() {
        return stkAccountses;
    }

    public void setStkAccountses(List<StkAccounts> stkAccountses) {
        this.stkAccountses = stkAccountses;
    }
    
    
    
}
