/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonParseException extends JsonProcessingException {

    public JsonParseException(String msg) {
        super(msg);
    }

}
