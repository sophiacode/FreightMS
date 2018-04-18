package com.freight.ms.system.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.beetl.core.GroupTemplate;



/**
 * Created by wyq on 2018/4/1.
 */
public class ShiroExt {
    public boolean hasPermission(String p){
        Subject subject = SecurityUtils.getSubject();

        return true;
        //return subject != null && p != null && p.length() > 0 && subject.isPermitted(p);
    }

    public static void main(String[] args) {
        GroupTemplate gt = new GroupTemplate();
        gt.registerFunctionPackage("shiro", new ShiroExt());
    }
}
