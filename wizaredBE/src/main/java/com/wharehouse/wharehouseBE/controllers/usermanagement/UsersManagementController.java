/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers.usermanagement;


import com.wharehouse.wharehouseBE.business.dao.specifications.UsersSpecifications;
import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.services.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waleed.mohamed
 */
@RestController
@RequestMapping("/usermanagement/users")
public class UsersManagementController extends BaseRestController<Users> {

    @Autowired
    private UsersService usersService;

    public UsersManagementController() {
        this.genericEntitySpecfications = new UsersSpecifications();
    }

    @Override
    protected void prePareEntityBeforeCreate(Users newUser) {
        validateUserBeforSave(null, newUser);
        newUser.setChangePassword(true);
    }

    @Override
    protected void copyProperties(Users newUser, Users oldUser) {
        validateUserBeforSave(oldUser, newUser);
        BeanUtils.copyProperties(newUser, oldUser, "userName"); //To change body of generated methods, choose Tools | Templates.

    }

    private void validateUserBeforSave(Users oldUser, Users newUser) {
        if (newUser.getUserName() == null || newUser.getUserName().isEmpty()) {
            throw new BusinessException("username missed");

        }
        if (StringUtils.containsWhitespace(newUser.getUserName())) {
            throw new BusinessException("username should not contain spaces");

        }

        if (newUser.getAuthorities() == null || newUser.getAuthorities().isEmpty()) {
            throw new BusinessException("user roles missed");

        }

//        if (newUser.getIsS2Account() == 0) {
//            if (newUser.getAuthorities().size() > 1 || !(newUser.getAuthorities().get(0).getId().equals(UserRolesNumberEnum.ROLE_SALES_FORCE.getRoleNumber()))) {
//                throw new BusinessException("user should has role sales force only");
//            }
//        }

//        if (newUser.getUserLevelId() == null) {
//            throw new BusinessException("level missed");
//        }

//        if (newUser.getLineManagerId() != null) {
//
//            if (newUser.getUserLevelId().equals(UserLevelEnum.REGION_SALES_MANAGER.getLevelNumber())) {
//                throw new BusinessException("sales managers should not have manger");
//
//            }
//
//            Users manager = findOne(newUser.getLineManagerId(), null);
//
//            if (manager == null) {
//                throw new BusinessException("manager not found");
//
//            }
//
//            Integer mangerLevel = Users.findLineManagerLevel(newUser.getUserLevelId());
//
//            if (!mangerLevel.equals(manager.getUserLevelId())) {
//                throw new BusinessException("invalid manager level");
//            }
//        }

        if (oldUser != null) {

            if (!newUser.getPassword().equals(oldUser.getPassword())) {
                newUser.setChangePassword(true);
            }

            //check change level or status (de-activate) or change team LeadBranch branch
//            if (!oldUser.getUserLevelId().equals(newUser.getUserLevelId())
//                    || (oldUser.getActive() == 1 && newUser.getActive() == 0)
//                    //change branch when user is teamlead
//                    || ((oldUser.getBranchNo() != null && !oldUser.getBranchNo().isEmpty()) && (!oldUser.getBranchNo().equals(newUser.getBranchNo())))) {
//
//                if (oldUser.getUserLevelId().equals(UserLevelEnum.TEAM_LEAD.getLevelNumber())) {
//                    if (oldUser.getTeamLeadSalesmanAssignList() != null && !oldUser.getTeamLeadSalesmanAssignList().isEmpty()) {
//                        throw new BusinessException("assigned salesmen found can not change level or status or branch");
//
//                    }
//                } else {
//                    if (oldUser.getSubordinatList() != null && !oldUser.getSubordinatList().isEmpty()) {
//                        throw new BusinessException("subordinates found can not change level or status");
//                    }
//                }
//
//            }
        }
    }

    @Override
    protected Users saveEntity(Users entity) {
        return usersService.save(entity);
    }

}
