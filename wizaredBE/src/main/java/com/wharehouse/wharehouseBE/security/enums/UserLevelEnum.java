/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.enums;


/**
 *
 * @author waleed.mohamed
 */
public enum UserLevelEnum {
    TEAM_LEAD(1),
    AREA_SALES_MANANGER(2),
    SALES_MANAGER(3),
    REGION_SALES_MANAGER(4);

    private final Integer levelNumber;

    private UserLevelEnum(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Integer getLevelNumber() {
        return this.levelNumber;
    }

}
