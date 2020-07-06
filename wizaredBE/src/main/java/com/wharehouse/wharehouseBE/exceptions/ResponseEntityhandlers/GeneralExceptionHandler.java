/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.exceptions.ResponseEntityhandlers;

import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.exceptions.NoDataException;
import com.wharehouse.wharehouseBE.model.dto.common.ErrorDetails;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex, WebRequest request) {
        LOGGER.warn(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        if (ex.getParams() != null) {
            errorDetails.setParamObjects(ex.getParams());
        }
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoDataException.class)
    public final ResponseEntity<ErrorDetails> handleUserNoDataException(NoDataException ex, WebRequest request) {
        LOGGER.warn(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleGeneralException(Exception ex, WebRequest request) {
        LOGGER.error(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Internal Server Error",
                "Internal Server Error");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }
}
