/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.daos;

import com.wharehouse.wharehouseBE.business.dao.common.GenericJPARepository;
import com.wharehouse.wharehouseBE.security.model.entities.Tokens;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rawan.Ahmed
 */
public interface TokenRepository  extends GenericJPARepository<Tokens>{
      
    @Query("SELECT COUNT(t.token) FROM Tokens t WHERE (t.userName =  :username) and (t.token = :token)")
    public int Count(@Param("username") String username,@Param("token") String token);
    
    @Query("SELECT t FROM Tokens t WHERE (t.userName =  :username) and (t.token = :token)")
    public Tokens findByUserNameAndToken(@Param("username") String username ,@Param("token") String token);
}
