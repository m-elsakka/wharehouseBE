package com.wharehouse.wharehouseBE.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StkTransDetails.class)
public abstract class StkTransDetails_ {

	public static volatile SingularAttribute<StkTransDetails, Integer> qCrt;
	public static volatile SingularAttribute<StkTransDetails, Integer> accQCrt;
	public static volatile SingularAttribute<StkTransDetails, String> storeKepperComments;
	public static volatile SingularAttribute<StkTransDetails, BigDecimal> itemprice;
	public static volatile SingularAttribute<StkTransDetails, StkTransDetailsPK> stkTransDetailsPK;
	public static volatile SingularAttribute<StkTransDetails, Item> itemno;
	public static volatile SingularAttribute<StkTransDetails, StkTransHeader> stkTransHeader;
	public static volatile SingularAttribute<StkTransDetails, String> branchno;

	public static final String Q_CRT = "qCrt";
	public static final String ACC_QCRT = "accQCrt";
	public static final String STORE_KEPPER_COMMENTS = "storeKepperComments";
	public static final String ITEMPRICE = "itemprice";
	public static final String STK_TRANS_DETAILS_PK = "stkTransDetailsPK";
	public static final String ITEMNO = "itemno";
	public static final String STK_TRANS_HEADER = "stkTransHeader";
	public static final String BRANCHNO = "branchno";

}

