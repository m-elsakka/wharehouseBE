package com.wharehouse.wharehouseBE.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StkAccounts.class)
public abstract class StkAccounts_ {

	public static volatile SingularAttribute<StkAccounts, Character> suspend;
	public static volatile SingularAttribute<StkAccounts, String> accountCode;
	public static volatile SingularAttribute<StkAccounts, String> descreption;
	public static volatile SingularAttribute<StkAccounts, Date> lastTrDate;
	public static volatile SingularAttribute<StkAccounts, Character> keepHistory;
	public static volatile SingularAttribute<StkAccounts, String> accountNamee;
	public static volatile SingularAttribute<StkAccounts, String> accountRef;
	public static volatile SingularAttribute<StkAccounts, String> accountNamea;

	public static final String SUSPEND = "suspend";
	public static final String ACCOUNT_CODE = "accountCode";
	public static final String DESCREPTION = "descreption";
	public static final String LAST_TR_DATE = "lastTrDate";
	public static final String KEEP_HISTORY = "keepHistory";
	public static final String ACCOUNT_NAMEE = "accountNamee";
	public static final String ACCOUNT_REF = "accountRef";
	public static final String ACCOUNT_NAMEA = "accountNamea";

}

