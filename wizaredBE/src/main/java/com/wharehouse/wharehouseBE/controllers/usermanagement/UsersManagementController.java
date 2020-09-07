/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers.usermanagement;

import com.wharehouse.wharehouseBE.business.dao.common.GenericEntitySpecfications;
import com.wharehouse.wharehouseBE.business.dao.common.GenericJPARepository;
import com.wharehouse.wharehouseBE.business.dao.specifications.UsersSpecifications;
import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.model.dto.MobileListDto;
import com.wharehouse.wharehouseBE.model.enums.CrudOpTypesEnum;
import com.wharehouse.wharehouseBE.model.pojos.ResponsePojo;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.services.UsersService;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waleed.mohamed
 */
@RestController
@RequestMapping("/usermanagement/users")
public class UsersManagementController extends BaseRestController<Users>{

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

    @RequestMapping(value = "find-userById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findById(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization,
            @PathVariable Long id) throws Exception {
        try {
            validateCrudOperation(CrudOpTypesEnum.FIND.getCrudTypeId());
            Users entity = findOne(id, null);
            return findObjectResponseEntity(entity, headerAuthorization);
        } catch (Exception exception) {
            return buildExceptionResponseEntity(exception, headerAuthorization);

        }
    }

    protected Users findOne(Long id, String code) {
        Users entity = null;
        Serializable identifer = id != null ? id : code;
        Optional<Users> optional = this.genericJpARepository.findById(identifer);
        if (optional != null && optional.isPresent()) {
            entity = optional.get();
        }
        return entity;
    }

    @RequestMapping(value = "edit-user/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity update(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization,
            @PathVariable Long id, @RequestBody Users json) throws Exception {
        validateCrudOperation(CrudOpTypesEnum.EDIT.getCrudTypeId());
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("Users json is of type {}", json.getClass());
        return updateEntity(id, json, headerAuthorization);

    }

    protected Users updateEntity(Long id, Users json) {
        Users entity = findOne(id, null);
        Users updated = null;
        if (entity != null) {
            try {
                copyProperties(json, entity);
            } catch (Exception e) {
                logger.warn("while copying properties", e);
                throw e;

            }

            logger.debug("merged entity: {}", entity);
//            prePareEntityBeforeEdit(entity, json);
            updated = saveEntity(entity);
            logger.debug("updated enitity: {}", updated);
            return updated;
        } else {
            return null;
        }
    }

    protected ResponseEntity updateEntity(Long id, Users json, String headerAuthorization) {
        try {
            Users updated = updateEntity(id, json);
            if (updated != null) {
                return buildResponseEntity(true, null, updated, HttpStatus.OK, headerAuthorization);

            } else {

                logger.debug("non exist enitity: {}", id);
                return buildExceptionResponseEntity(new BusinessException("not found", new String[]{id.toString()}), headerAuthorization);

            }
        } catch (Exception exception) {
            return buildExceptionResponseEntity(exception, headerAuthorization);

        }
    }

    @RequestMapping(value = "delete-user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity delete(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization,
            @PathVariable Long id) throws Exception {
        try {
            validateCrudOperation(CrudOpTypesEnum.DELETE.getCrudTypeId());
            if (genericJpARepository.existsById(id)) {
                genericJpARepository.deleteById(id);
                logger.debug("Deleted enitity: {}", id);
                return buildResponseEntity(true, null, id, HttpStatus.OK, headerAuthorization);
            } else {
                return buildExceptionResponseEntity(new BusinessException("not found", new String[]{id.toString()}), headerAuthorization);
            }
        } catch (Exception exception) {
            return buildResponseEntity(false, exception.getMessage(), null, HttpStatus.NOT_ACCEPTABLE, headerAuthorization);

        }

    }

    private void validateCrudOperation(int crudOpeType) throws Exception {
        String validtionError = null;
        if (crudOpeType == CrudOpTypesEnum.CREATE.getCrudTypeId() && !canCreate) {
            validtionError = "CREATION_NOT_ALLOWED";
        } else if (crudOpeType == CrudOpTypesEnum.EDIT.getCrudTypeId() && !canEdit) {
            validtionError = "EDIT_NOT_ALLOWED";
        } else if (crudOpeType == CrudOpTypesEnum.DELETE.getCrudTypeId() && !canDelete) {
            validtionError = "DELETE_NOT_ALLOWED";
        } else if (crudOpeType == CrudOpTypesEnum.FIND.getCrudTypeId() && !canFind) {
            validtionError = "SEARCH_NOT_ALLOWED";
        }

        if (validtionError != null) {
            throw new BusinessException(validtionError);

        }
    }

    @Override
    protected Users saveEntity(Users entity) {
        return usersService.save(entity);
    }

    protected ResponseEntity findObjectResponseEntity(T entity, String headerAuthorization) {
        return buildResponseEntity(true, null, entity, HttpStatus.OK, headerAuthorization);
    }
}
