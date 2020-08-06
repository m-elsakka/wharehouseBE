/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.controllers.usermanagement;


import com.wharehouse.wharehouseBE.business.dao.specifications.UsersSpecifications;
import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.model.pojos.FilterPojo;
import com.wharehouse.wharehouseBE.model.pojos.SearchParPojo;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author waleed.mohamed
 */
@RestController
@RequestMapping("/usermanagement/users-managers")
public class LineManagerController extends BaseRestController<Users> {

    private final UsersSpecifications usersSpecifications;

    public LineManagerController() {
        findOnlyService();
        this.usersSpecifications = new UsersSpecifications();
    }

    @Override
    protected Specification buildSpecification(SearchParPojo searchPar) {
        Integer userLevel = null;

        Specification specification = null;
        if (searchPar.getFiltersList() != null && !searchPar.getFiltersList().isEmpty()) {
            for (FilterPojo filterPojo : searchPar.getFiltersList()) {
                if (filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty()
                        && filterPojo.getFilter() != null && !filterPojo.getFilter().isEmpty()) {
                    if (filterPojo.getFieldName().equals("userLevel")) {
                        userLevel = Integer.parseInt(filterPojo.getFilter());
                    }
                } else {
                    throw new BusinessException("invalid search data");
                }
            }
        }
        if (userLevel == null) {
            throw new BusinessException("level missed");
        }

        Integer linManagerLevel = Users.findLineManagerLevel(userLevel);

        specification = usersSpecifications.buildLineMangerByLevelSpecification(linManagerLevel);
        return specification;

    }
}
