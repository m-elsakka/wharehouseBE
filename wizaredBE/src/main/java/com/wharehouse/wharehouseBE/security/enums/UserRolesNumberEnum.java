/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.enums;

 
public enum UserRolesNumberEnum {
    ROLE_ADMIN(1),
    ROLE_SALES_FORCE(2),
    ROLE_MASTERDATA(3),
    ROLE_REPORTS(4),
    ROLE_USERMANAGEMENT(5);

    private final long roleNumber;

    private UserRolesNumberEnum(long roleNumber) {
        this.roleNumber = roleNumber;
    }

    public long getRoleNumber() {
        return this.roleNumber;
    }
}
