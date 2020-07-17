/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.pojos;

/**
 *
 * @author Rawan.Ahmed
 */
public class JwtResponse {
    private UserValidPojo data;
    private String iat;
    private String exp;

    public JwtResponse() {
    }
    
    public JwtResponse(UserValidPojo data, String iat, String exp) {
        this.data = data;
        this.iat = iat;
        this.exp = exp;
    }

    public UserValidPojo getData() {
        return data;
    }

    public void setData(UserValidPojo data) {
        this.data = data;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
}
