package com.wharehouse.wharehouseBE.security.model.entities;

import com.wharehouse.wharehouseBE.security.enums.AuthorityNameEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authority.class)
public abstract class Authority_ extends com.wharehouse.wharehouseBE.model.entities.CrudBaseEntity_ {

	public static volatile SingularAttribute<Authority, AuthorityNameEnum> name;
	public static volatile ListAttribute<Authority, Users> users;

	public static final String NAME = "name";
	public static final String USERS = "users";

}

