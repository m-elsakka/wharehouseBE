/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.business.dao.specifications;

import com.wharehouse.wharehouseBE.business.dao.common.GenericEntitySpecfications;
import com.wharehouse.wharehouseBE.model.entities.Branch_;
import com.wharehouse.wharehouseBE.model.entities.StkCabinet_;
import com.wharehouse.wharehouseBE.model.entities.StkCabinet;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader;
import com.wharehouse.wharehouseBE.model.entities.StkTransHeader_;
import com.wharehouse.wharehouseBE.model.enums.StkTransTypeEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StockTransactionSpecifications extends GenericEntitySpecfications<StkTransHeader> {

    public Specification buildViewStockTransactionDataFromMobile(String branchNo,
            String transRef, String transDate, Long transNo, String cabinetno, Integer stkTransType) {

        return (Specification) (Root root, CriteriaQuery cq, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.equal(root.get(StkTransHeader_.branchno).get(Branch_.branchno), branchNo));
            if (stkTransType != null && stkTransType == StkTransTypeEnum.DELIVER.getTransType()) {
                predicates.add(cb.equal(root.get(StkTransHeader_.status), "AR"));
            }else if (stkTransType != null && stkTransType == StkTransTypeEnum.SEND.getTransType()) {
                predicates.add(cb.equal(root.get(StkTransHeader_.status), "SC"));
            }
            //predicates.add(cb.equal(root.get(StkTransHeader_.branchno).get(Branch_.STORE_KEPEER_APP), "Y"));
            if (transRef != null && !transRef.isEmpty()) {
                predicates.add(cb.equal(root.get(StkTransHeader_.transRef), transRef));
            }
            if (transDate != null) {
                predicates.add(cb.equal(cb.function("TO_CHAR", String.class, cb.function("TRUNC", Date.class, root.get(StkTransHeader_.transDate)), cb.literal("yyyy.MM.dd-HH24:mi:ss")), transDate));
                // predicates.add(cb.equal(cb.function("TO_CHAR", String.class, root.get(StkTransHeader_.transDate),cb.literal("dd-MMM-yyyy")), "18-JUN-20"));
                System.out.println(transDate);
            }
            if (transNo != null) {
                predicates.add(cb.equal(root.get(StkTransHeader_.transNo), transNo));
            }
            if (cabinetno != null && !cabinetno.isEmpty()) {
                predicates.add(cb.equal(root.get(StkTransHeader_.accountC).get(StkCabinet_.cabinetno), cabinetno));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
