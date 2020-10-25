/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.business.dao.service;

import com.wharehouse.wharehouseBE.model.entities.StkTransCategory;
import com.wharehouse.wharehouseBE.model.entities.StkTransDetails;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import java.util.List;


public interface StktransServiceLocal {

    public void saveTransHeader(StkTransHeader stkTransHeader);

    public void saveNewTransDetails(List<StkTransDetails> stkTransDetailseList);

    public void saveCateDetails(List<StkTransCategory> StkTransCategoryList);

}
