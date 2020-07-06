/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model;

public abstract class ConstantStrings {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30;
    public static final String SIGNING_KEY = "secretkey";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final int MIN_PASSWOED_LENGTH = 6;
    public static final String LOGIN_MOBILE_URL = "/mobile/user/login";
    public static final String LOGIN_WEB_URL = "/user/login";
    public static final String LOGOUT_MOBILE_URL = "/logoutservice/mobile/logout";
    public static final String LOGOUT_WEB_URL = "/logoutservice/web/logout";
    public static final String SUB_MOBILE_URL = "/mobile";
    public static final String DATE_FORMATE = "dd-MM-yyyy";
    public static final String SUB_LOGOUT_URL = "logout";
}
