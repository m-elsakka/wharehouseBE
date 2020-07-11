package com.wharehouse.wharehouseBE.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StkTransDetailsPK.class)
public abstract class StkTransDetailsPK_ {

	public static volatile SingularAttribute<StkTransDetailsPK, Date> productiondate;
	public static volatile SingularAttribute<StkTransDetailsPK, String> itemno;
	public static volatile SingularAttribute<StkTransDetailsPK, Long> transNo;

	public static final String PRODUCTIONDATE = "productiondate";
	public static final String ITEMNO = "itemno";
	public static final String TRANS_NO = "transNo";

}

