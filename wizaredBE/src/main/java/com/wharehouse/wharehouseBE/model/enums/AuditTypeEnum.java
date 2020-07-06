/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.enums;

/**
 *
 * @author waleed.mohamed
 */
public enum AuditTypeEnum {
    L("limited audit"),
    N("No audit"),
    Y("Continuous audit");

    private String type;

    private AuditTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
