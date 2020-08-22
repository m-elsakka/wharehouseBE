/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.business.dao.repositories;

import com.wharehouse.wharehouseBE.business.dao.common.GenericJPARepository;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import java.util.List;



/**
 *
 * @author Rawan.Ahmed
 */
public interface StkTransHeaderRepository extends GenericJPARepository<StkTransHeader> {
    
    
      //List<StkTransHeader> findByAccountType(String accountType);

}
