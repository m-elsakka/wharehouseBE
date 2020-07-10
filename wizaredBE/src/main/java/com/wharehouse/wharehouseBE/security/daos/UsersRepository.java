/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.daos;

import com.wharehouse.wharehouseBE.business.dao.common.GenericJPARepository;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends GenericJPARepository<Users> {

    @Query("SELECT u FROM Users u WHERE UPPER(TRIM(u.userName))=UPPER(TRIM(:userName))")
    public Optional<Users> findByUsername(@Param("userName") String user_name);

}
