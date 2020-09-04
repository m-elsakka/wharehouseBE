/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.services;

import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.model.dto.ChangePassword;
import com.wharehouse.wharehouseBE.security.daos.UserAuthorityRepositiry;
import com.wharehouse.wharehouseBE.security.daos.UsersRepository;
import com.wharehouse.wharehouseBE.security.model.entities.UserAuthority;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wharehouse.wharehouseBE.security.model.entities.Authority;

@Transactional
@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

//    @Autowired
//    private TeamLeadUserHierViewRepository teamLeadUserHierViewRepository;
//
    @Autowired
    private UserAuthorityRepositiry userAuthorityRepositiry;
    @Override
    public Users save(Users user) {
        List<Long> authorityIdList = user.getAuthorities().stream()
                .map(Authority::getId)
                .collect(Collectors.toList());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            if (user.isChangePassword()) {
                checkPasswordLength(user.getPassword());
                user.setPassword(bcryptEncodeString(user.getPassword()));
            }
        } else {
            // if (authorityIdList.contains(UserRolesNumberEnum.ROLE_SALES_FORCE.getRoleNumber())) {
            //throw new BusinessException("ROLE_SALES_FORCE_SHOULD_HAS_PASSWORD");
            //}
            throw new BusinessException("password missed");

        }
        Users SavedUser = userRepository.save(user);
         manageUserRoles(SavedUser, authorityIdList);
        return SavedUser;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> findByUsername(String username) {
        try {
            Optional<Users> userOptional = userRepository.findById(username);
            return userOptional;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Users checkUserAccount(Users userObj) throws BusinessException {
        if (userObj.getUserName() == null) {
            throw new BusinessException("fill user name");
        }
        if (userObj.getPassword() == null) {
            throw new BusinessException("fill password");
        }

        String userName = userObj.getUserName().trim();
        String password = userObj.getPassword().trim();

        Optional<Users> userOptional = findByUsername(userName);

        if (!userOptional.isPresent()) {
            throw new BusinessException("user name not found");
        }

        Users user = userOptional.get();
        if (user.getActive() == 0) {
            throw new BusinessException("user inactive");
        }

        //https://stackoverflow.com/questions/26905721/decode-the-bcrypt-encoded-password-in-spring-security-to-deactivate-user-account
        //bcrypt GENERATE DIFFRENT HAS TO SAME ROW PW SO EQUAL CAN NOT BE USED
        if (!bcryptEncoder.matches(password, user.getPassword())) {
            throw new BusinessException("invalid login password not match");
        }
        return user;

    }

    private void checkPasswordLength(String password) {
        if (password.length() < ConstantStrings.MIN_PASSWOED_LENGTH)//min 6
        {
            throw new BusinessException("invalid password length min 6");
        }
    }
    @Override
    public String changePassword(ChangePassword changePW) throws BusinessException {
        //check
        changePW.setUsername(changePW.getUsername().toLowerCase());
        Users userObj = new Users();
        userObj.setUserName(changePW.getUsername());
        userObj.setPassword(changePW.getOldPassword());

        userObj = checkUserAccount(userObj);
        if (!(changePW.getNewPassword().equals(changePW.getConfirmedNewPassword()))) {
            throw new BusinessException("password not match");
        }
        if ((changePW.getNewPassword().equals(changePW.getOldPassword()))) {
            throw new BusinessException("password equal old");
        }

        checkPasswordLength(changePW.getNewPassword());

        userObj.setPassword(bcryptEncodeString(changePW.getNewPassword()));
        userRepository.save(userObj);

        return JWTUtil.generateToken(userObj.getUserName(), userObj.getAuthorities().toArray());
    }
    private String bcryptEncodeString(String text) {
        return bcryptEncoder.encode(text);
    }

//    @Override
//    public List<Long> findTeamIdListFromUser(Long userId) {
//        List<Long> tmIdList = null;
//        List<TeamLeadUserHierView> teamLeadList = null;
//        Optional<Users> userOptional = userRepository.findById(userId);
//        if (!userOptional.isPresent()) {
//            throw new BusinessException("user not found");
//
//        }
//        Users mobileUser = userOptional.get();
//        Integer userLevel = mobileUser.getUserLevelId();
//
//        if (userLevel.equals(UserLevelEnum.TEAM_LEAD.getLevelNumber())) {
//            tmIdList = new ArrayList<>();
//            tmIdList.add(mobileUser.getId());
//        } else if (userLevel.equals(UserLevelEnum.AREA_SALES_MANANGER.getLevelNumber())) {
//            teamLeadList = teamLeadUserHierViewRepository.findTeamLeadIdByAreaMangerId(userId);
//        } else if (userLevel.equals(UserLevelEnum.SALES_MANAGER.getLevelNumber())) {
//            teamLeadList = teamLeadUserHierViewRepository.findTeamLeadIdBySalesManagerId(userId);
//        } else if (userLevel.equals(UserLevelEnum.REGION_SALES_MANAGER.getLevelNumber())) {
//            teamLeadList = teamLeadUserHierViewRepository.findTeamLeadIdByRegionManagerId(userId);
//        }
//
//        if (teamLeadList != null && !teamLeadList.isEmpty()) {
//            tmIdList = teamLeadList.stream()
//                    .map(TeamLeadUserHierView::getTeamLeadId)
//                    .collect(Collectors.toList());
//        }
//
//        return tmIdList;
//    }
//
//    @Override
//    public void validateTeamLeadForSalesManAssign(Long userId, String branchNo) {
//        Optional<Users> userOptional = userRepository.findById(userId);
//        if (!userOptional.isPresent()) {
//            throw new BusinessException("team lead not found");
//        }
//        Users teamLead = userOptional.get();
//
//        if (teamLead.getActive() != 1) {
//            throw new BusinessException("team lead not active", new String[]{userId.toString()});
//
//        }
//        if (!teamLead.getUserLevelId().equals(UserLevelEnum.TEAM_LEAD.getLevelNumber())) {
//            throw new BusinessException("non team lead level", new String[]{userId.toString()});
//        }
//
//        if (branchNo != null && teamLead.getBranchNo() != null && (!teamLead.getBranchNo().equals(branchNo))) {
//            throw new BusinessException("team lead branch not macth", new String[]{userId.toString()});
//
//        }
//    }
//
    private void manageUserRoles(Users updateUser, List<Long> authorityIdList) {

        List<UserAuthority> oldRoles = userAuthorityRepositiry.findUserAuthorityByUserId(updateUser.getId());
        List<UserAuthority> deletingList = null;
        deletingList = new ArrayList<>();

        if (oldRoles != null && !oldRoles.isEmpty()) {
            for (UserAuthority userAuthority : oldRoles) {
                if (!authorityIdList.contains(userAuthority.getAuthorityId())) {
                    deletingList.add(userAuthority);
                    authorityIdList.remove(userAuthority.getAuthorityId());
                }
            }
        }
        saveUserRoles(updateUser, deletingList, authorityIdList);

    }

    private void saveUserRoles(Users user, List<UserAuthority> deledtingList, List<Long> savingAuthIdList) {
        UserAuthority newUserAuthority = null;
        if (deledtingList != null && !deledtingList.isEmpty()) {
            userAuthorityRepositiry.deleteInBatch(deledtingList);
        }

        if (savingAuthIdList != null && !savingAuthIdList.isEmpty()) {
            List<UserAuthority> savingList = new ArrayList<>();
            for (Long authId : savingAuthIdList) {
                newUserAuthority = new UserAuthority();
                newUserAuthority.setAuthorityId(authId);
                newUserAuthority.setUserId(user.getId());
                savingList.add(newUserAuthority);
            }
            userAuthorityRepositiry.saveAll(savingList);
        }
    }
}
