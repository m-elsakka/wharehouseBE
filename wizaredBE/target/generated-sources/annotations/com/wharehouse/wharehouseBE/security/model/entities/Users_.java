package com.wharehouse.wharehouseBE.security.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ extends com.wharehouse.wharehouseBE.model.entities.CrudBaseEntity_ {

	public static volatile SingularAttribute<Users, String> firstName;
	public static volatile SingularAttribute<Users, String> lastName;
	public static volatile SingularAttribute<Users, String> password;
	public static volatile SingularAttribute<Users, UserLevel> userLevel;
	public static volatile SingularAttribute<Users, String> user_name;
	public static volatile SingularAttribute<Users, Short> isAdmin;
	public static volatile SingularAttribute<Users, Integer> userLevelId;
	public static volatile ListAttribute<Users, Authority> authorities;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String USER_LEVEL = "userLevel";
	public static final String USER_NAME = "user_name";
	public static final String IS_ADMIN = "isAdmin";
	public static final String USER_LEVEL_ID = "userLevelId";
	public static final String AUTHORITIES = "authorities";

}

