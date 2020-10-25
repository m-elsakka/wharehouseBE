/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.business.dao.specifications;


import com.wharehouse.wharehouseBE.business.dao.common.GenericEntitySpecfications;
import com.wharehouse.wharehouseBE.model.enums.ActiveEnum;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.model.entities.Users_;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public class UsersSpecifications extends GenericEntitySpecfications<Users> {

    public Specification buildLineMangerByLevelSpecification(Integer levelNumber) {
        return (Specification) (Root root, CriteriaQuery cq, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
          //  predicates.add(cb.equal(root.get(Users_.active), new Short(ActiveEnum.ACTIVE.getActiveFlag().toString())));
            predicates.add(cb.equal(root.get(Users_.userLevelId), levelNumber));

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
