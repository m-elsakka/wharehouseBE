/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers;

import com.wharehouse.wharehouseBE.model.entities.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed.Gaber
 */

@RestController
@RequestMapping("masterdata/item")
public class ItemController extends BaseRestController<Item>{

    public ItemController() {
    }
    
    
    
}
