/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers;

import com.wharehouse.wharehouseBE.model.entities.Branch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed.Gaber
 */

@RestController
@RequestMapping("masterdata/branchs")
public class BranchController extends BaseRestController<Branch>{
    
}
