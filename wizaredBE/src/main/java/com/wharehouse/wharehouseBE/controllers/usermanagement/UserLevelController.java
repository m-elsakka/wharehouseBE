/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers.usermanagement;


import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.security.model.entities.UserLevel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waleed.mohamed
 */
@RestController
@RequestMapping("/usermanagement/user-levels")
public class UserLevelController extends BaseRestController<UserLevel> {

}
