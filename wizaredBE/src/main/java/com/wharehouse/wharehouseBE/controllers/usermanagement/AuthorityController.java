/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers.usermanagement;


import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.security.model.entities.Authority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waleed.mohamed
 */
@RestController
@RequestMapping("/usermanagement/authorities")
public class AuthorityController extends BaseRestController<Authority> {

    public AuthorityController() {
        canCreate = false;
        canEdit = false;
        canDelete = false;
        canFind = true;
    }
}
