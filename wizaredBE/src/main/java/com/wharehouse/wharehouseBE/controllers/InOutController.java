/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers;

import com.wharehouse.wharehouseBE.business.dao.repositories.StkTransHeaderRepository;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed.Gaber
 */
@RestController
@RequestMapping("transactions/inout")
public class InOutController extends BaseRestController<StkTransHeader> {

    @Autowired
    private StkTransHeaderRepository stkTransHeaderRepository;

    public InOutController() {

    }

    @RequestMapping(value = "/findInOut/{inOutType}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity findListBySpecifications(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization,
            @PathVariable String inOutType) {
        try {
            //validateCrudOperation(CrudOpTypesEnum.FIND.getCrudTypeId());
            List<StkTransHeader> resultList = null;
            //resultList = stkTransHeaderRepository.findByAccountType(inOutType);

            return findObjectResponseEntity(resultList, headerAuthorization);
        } catch (Exception exception) {
            return buildExceptionResponseEntity(exception, headerAuthorization);
        }
    }

}
