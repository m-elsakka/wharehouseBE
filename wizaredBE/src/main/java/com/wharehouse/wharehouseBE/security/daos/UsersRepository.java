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

    @Query("SELECT u FROM Users u WHERE UPPER(TRIM(u.user_name))=UPPER(TRIM(:user_name))")
    public Optional<Users> findByUsername(@Param("user_name") String user_name);

}
