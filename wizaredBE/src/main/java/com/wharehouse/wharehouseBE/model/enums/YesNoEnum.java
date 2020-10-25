/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.enums;


public enum YesNoEnum {
    Yes("Y"),
    NO("N");
    

    private final String flag;

    private YesNoEnum(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
