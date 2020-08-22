/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.enums;

/**
 *
 * @author Ahmed.Gaber
 */
public enum StkTransTypeEnum {
    
    DELIVER(1),
    SEND(2),
    INVENTORY(3);
    

    private final int transType;

    private StkTransTypeEnum(int transType) {
        this.transType = transType;
    }

    public int getTransType() {
        return transType;
    }

    
}
