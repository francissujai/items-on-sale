package com.rbc.assignment.itemsonsale.config;

public class SecurityConstants {

    //# TODO : Move it to property file
    public static final String SECRET = "moOObRc6CJYzv1x-9VBYEChxrtf4uJUQxM8MrIUtKl0";
    //# TODO : Move it to property file
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/items-on-sale/api/v1/users/signup";
}