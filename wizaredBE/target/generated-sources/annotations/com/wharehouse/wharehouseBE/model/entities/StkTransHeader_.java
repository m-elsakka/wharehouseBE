package com.wharehouse.wharehouseBE.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StkTransHeader.class)
public abstract class StkTransHeader_ {

	public static volatile SingularAttribute<StkTransHeader, String> transRef;
	public static volatile SingularAttribute<StkTransHeader, StkTransDescriptor> stkTransDescriptor;
	public static volatile SingularAttribute<StkTransHeader, Date> transDate;
	public static volatile SingularAttribute<StkTransHeader, Date> postDate;
	public static volatile SingularAttribute<StkTransHeader, StkAccounts> accountD;
	public static volatile SingularAttribute<StkTransHeader, StkAccounts> accountC;
	public static volatile ListAttribute<StkTransHeader, StkTransDetails> stkTransDetailsList;
	public static volatile SingularAttribute<StkTransHeader, Long> transNo;
	public static volatile SingularAttribute<StkTransHeader, String> status;
	public static volatile SingularAttribute<StkTransHeader, Branch> branchno;

	public static final String TRANS_REF = "transRef";
	public static final String STK_TRANS_DESCRIPTOR = "stkTransDescriptor";
	public static final String TRANS_DATE = "transDate";
	public static final String POST_DATE = "postDate";
	public static final String ACCOUNT_D = "accountD";
	public static final String ACCOUNT_C = "accountC";
	public static final String STK_TRANS_DETAILS_LIST = "stkTransDetailsList";
	public static final String TRANS_NO = "transNo";
	public static final String STATUS = "status";
	public static final String BRANCHNO = "branchno";

}

