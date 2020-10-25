/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.business.dao.service;

import com.wharehouse.wharehouseBE.business.dao.repositories.StkTransCategoryRepository;
import com.wharehouse.wharehouseBE.business.dao.repositories.StkTransDetailsRepository;
import com.wharehouse.wharehouseBE.business.dao.repositories.StkTransHeaderRepository;
import com.wharehouse.wharehouseBE.model.entities.StkTransCategory;
import com.wharehouse.wharehouseBE.model.entities.StkTransDetails;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class StktransService implements StktransServiceLocal {

    @Autowired
    private StkTransHeaderRepository stkTransHeaderRepository;

    @Autowired
    private StkTransDetailsRepository stkTransDetailsRepository;
    
    @Autowired
    private StkTransCategoryRepository  stkTransCategoryRepository;

    @Override
    public void saveTransHeader(StkTransHeader stkTransHeader) {
        stkTransHeaderRepository.save(stkTransHeader);
        stkTransHeaderRepository.flush();
    }

    @Override
    public void saveNewTransDetails(List<StkTransDetails> stkTransDetailseList) {
        for (StkTransDetails obj : stkTransDetailseList) {
            stkTransDetailsRepository.save(obj);
        }
        stkTransDetailsRepository.flush();
    }

    @Override
    public void saveCateDetails(List<StkTransCategory> StkTransCategoryList) {
          for (StkTransCategory obj : StkTransCategoryList) {
            stkTransCategoryRepository.save(obj);
        }
        stkTransCategoryRepository.flush();
    }


}
