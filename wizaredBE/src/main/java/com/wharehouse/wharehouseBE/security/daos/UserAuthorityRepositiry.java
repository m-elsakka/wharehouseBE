/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.daos;


import com.wharehouse.wharehouseBE.business.dao.common.GenericJPARepository;
import com.wharehouse.wharehouseBE.security.model.entities.UserAuthority;
import java.util.List;


public interface UserAuthorityRepositiry extends GenericJPARepository<UserAuthority> {

    List<UserAuthority> findUserAuthorityByUserId(Long userId);

}
