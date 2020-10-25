/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.enums;


public enum AccountTypeEnum {
    IN("IN"),
    OUT("OUT");

    private final String accountTypeFlag;

    private AccountTypeEnum(String accountTypeFlag) {
        this.accountTypeFlag = accountTypeFlag;
    }

    public String getAccountTypeFlag() {
        return accountTypeFlag;
    }


    

}
