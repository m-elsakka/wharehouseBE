/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers;

import com.wharehouse.wharehouseBE.business.dao.repositories.BranchRepository;
import com.wharehouse.wharehouseBE.business.dao.repositories.StkTransHeaderRepository;
import com.wharehouse.wharehouseBE.business.dao.specifications.StockTransactionSpecifications;
//import com.wharehouse.wharehouseBE.business.service.HandleLossQuantitiesService;
import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.model.entities.Branch;
import com.wharehouse.wharehouseBE.model.entities.StkTransDetails;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import com.wharehouse.wharehouseBE.model.enums.ResponseMessageEnum;
import com.wharehouse.wharehouseBE.model.pojos.FilterPojo;
import com.wharehouse.wharehouseBE.model.pojos.SearchParPojo;
import java.text.ParseException;
import java.util.Date;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("mobile/stocktransaction")
public class StockTransactionController extends BaseRestController<StkTransHeader> {

    @Autowired
    private StkTransHeaderRepository stkTransHeaderRepository;
//    @Autowired
//    private HandleLossQuantitiesService handleLossQuantitiesService;
    @Autowired
    private BranchRepository branchRepository;

    private StockTransactionSpecifications stockTransactionSpecifications;
    private SimpleDateFormat formatter;

    public StockTransactionController() {
        stockTransactionSpecifications = new StockTransactionSpecifications();
        //findOnlyService();
        responseByMobileDto = true;
        formatter = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
    }

    protected Specification buildSpecification(SearchParPojo searchPar) {
        Specification specification = null;
        String branchNo = null;
        String transRef = null;
        String transDate = null;
        Long transNo = null;
        Branch branch = null;
        String accountCode = null;
        if (searchPar.getFiltersList() != null && !searchPar.getFiltersList().isEmpty()) {
            for (FilterPojo filterPojo : searchPar.getFiltersList()) {
                if (filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty()
                        && filterPojo.getFilter() != null && !filterPojo.getFilter().isEmpty()) {
                    if (filterPojo.getFieldName().equals("branchNo")) {
                        branchNo = filterPojo.getFilter();
                        Optional<Branch> branchOptional = branchRepository.findById(branchNo);
                        branch = branchOptional.get();
                    } else if (filterPojo.getFieldName().equals("transNo")) {
                        transNo = Long.parseLong(filterPojo.getFilter());
                    } else if (filterPojo.getFieldName().equals("transRef")) {
                        transRef = filterPojo.getFilter();
                    } else if (filterPojo.getFieldName().equals("transDate")) {
                        try {
                            Date d = null;
                            String date = null;
                            d = formatter.parse(filterPojo.getFilter());
                            date = formatter.format(d);
                            transDate = date;
                        } catch (ParseException ex) {
                            Logger.getLogger(StockTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (filterPojo.getFieldName().equals("accountCode")) {
                        accountCode = filterPojo.getFilter();
                    }
                } else {
                    throw new BusinessException("invalid search data");
                }
            }
            if (branchNo == null) {
                throw new BusinessException("invalid branch number");
            } //            else if(branch != null && branch.getStoreKepeerApp()!= null && branch.getStoreKepeerApp().equals("N")){
            //                throw new BusinessException("User Can't use this App");
            //            }
            else {
                specification = stockTransactionSpecifications.buildViewStockTransactionDataFromMobile(branchNo, transRef, transDate, transNo, accountCode);
            }
        }
        return specification;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity edit(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization, @PathVariable Long id, @RequestBody StkTransHeader json) {
        try {
            if (id == null) {
                throw new BusinessException("Transaction number is missed");
            }
            StkTransHeader editObj = null;
            Optional<StkTransHeader> optionalStkTransHeader = stkTransHeaderRepository.findById(id);
            if (optionalStkTransHeader.isPresent()) {
                editObj = optionalStkTransHeader.get();
            } else {
                throw new BusinessException("This transaction not available");
            }
            editObj = editData(editObj, json);
            saveEntity(editObj);
            //handleLossQuantitiesService.addLineToStkHeaderLoss(editObj);
            return buildResponseEntity(true, null, ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.OK, headerAuthorization);
        } catch (Exception ex) {
            return buildExceptionResponseEntity(ex, headerAuthorization);
        }
    }

    @RequestMapping(value = "/syncall", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity edit(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization, @RequestBody StkTransHeader jsonList) {
        try {
            if (jsonList != null) {// && !jsonList.isEmpty()){
                List<StkTransHeader> editedList = new ArrayList<>();
                // for(StkTransHeader jsonObj : jsonList){
                StkTransHeader editObj = null;
                Optional<StkTransHeader> optionalStkTransHeader = stkTransHeaderRepository.findById(jsonList.getTransNo());
                if (optionalStkTransHeader.isPresent()) {
                    editObj = optionalStkTransHeader.get();
                } else {
                    throw new BusinessException("This transaction not available");
                }
                editObj = editData(editObj, jsonList);
                editedList.add(editObj);
                // }
                save(editedList);
                return buildResponseEntity(true, null, ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.OK, headerAuthorization);
            } else {
                throw new BusinessException("No transactions found");
            }
        } catch (Exception ex) {
            return buildExceptionResponseEntity(ex, headerAuthorization);
        }
    }

    private StkTransHeader editData(StkTransHeader editObj, StkTransHeader jsonObj) {
        if (editObj.getStatus().equals("SC")) {
            throw new BusinessException("This Transaction already edited by another store Keeper");
        }
        editObj.setStatus("SC");
        for (StkTransDetails detail : editObj.getStkTransDetailsList()) {
            StkTransDetails jsonDetail = jsonObj.getStkTransDetailsList().stream()
                    .filter(line -> line.getItemNumber().equals(detail.getItemNumber()))
                    .collect(Collectors.toList()).get(0);
            detail.setQCrt(jsonDetail.getQCrt());
            //detail.setQPlt(jsonDetail.getQPlt());
            // detail.setStoreKepperComments(jsonDetail.getStoreKepperComments());
        }
        return editObj;
    }

    private void save(List<StkTransHeader> editList) {
        for (StkTransHeader obj : editList) {
            saveEntity(obj);
//            handleLossQuantitiesService.addLineToStkHeaderLoss(obj);
        }
    }

}
