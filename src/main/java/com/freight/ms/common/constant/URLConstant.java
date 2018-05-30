package com.freight.ms.common.constant;

public class URLConstant {
    static public String URL_PREFIX = "http://localhost:8000";

    static public String URL_LOGIN = URL_PREFIX + "/login";

    static public String URL_MANAGE = URL_PREFIX + "/manage";

    static public String URL_USER_MANAGE = URL_MANAGE + "/user";
    static public String URL_USER_LIST =  URL_USER_MANAGE + "/user_list";
    static public String URL_USER_ADD_VIEW = URL_USER_MANAGE + "/add";
    static public String URL_USER_ADD = URL_USER_MANAGE + "/user_add";
}
