/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.services;

import com.wharehouse.wharehouseBE.security.model.entities.Tokens;

/**
 *
 * @author Rawan.Ahmed
 */
public interface TokenProvideService {
    
    Tokens create(Tokens token);
    
    void delete(Tokens token);
    
    int count(String userName,String token);
    
    Tokens findByUserNameAndToken(String userName,String token);
}
