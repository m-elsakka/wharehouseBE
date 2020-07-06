package com.wharehouse.wharehouseBE.security.model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tokens.class)
public abstract class Tokens_ {

	public static volatile SingularAttribute<Tokens, Date> issuedDate;
	public static volatile SingularAttribute<Tokens, String> userName;
	public static volatile SingularAttribute<Tokens, String> token;

	public static final String ISSUED_DATE = "issuedDate";
	public static final String USER_NAME = "userName";
	public static final String TOKEN = "token";

}

