/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.services;


import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<Users> findByUsername(String username);

    Users save(Users user);

    Users checkUserAccount(Users userObj) throws BusinessException;

    //String changePassword(ChangePassword changePW) throws BusinessException;
//
//    List<Long> findTeamIdListFromUser(Long userId);
//
//    void validateTeamLeadForSalesManAssign(Long userId, String branchNo) throws BusinessException;

}
