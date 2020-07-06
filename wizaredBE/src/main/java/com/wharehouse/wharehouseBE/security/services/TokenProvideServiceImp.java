/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.services;

import com.wharehouse.wharehouseBE.security.model.entities.Tokens;
import com.wharehouse.wharehouseBE.security.daos.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rawan.Ahmed
 */
@Transactional
@Service
public class TokenProvideServiceImp implements TokenProvideService {

    @Autowired
    private TokenRepository tokenRepository;
    
    @Override
    public Tokens create(Tokens token) {
        Tokens savedToken = tokenRepository.save(token);
        return savedToken;
    }

    @Override
    public void delete(Tokens token) {
        tokenRepository.delete(token);
    }

    @Override
    public int count(String userName,String token) {
        return tokenRepository.Count(userName,token);
    }

    @Override
    public Tokens findByUserNameAndToken(String userName, String token) {
        return tokenRepository.findByUserNameAndToken(userName, token);
    }
    
}
