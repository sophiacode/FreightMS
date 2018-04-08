package com.freight.ms.system.shiro;

import org.beetl.core.GroupTemplate;

/**
 * Created by wyq on 2018/4/1.
 */
public class ShiroExt {
    public boolean hasPermission(String p){
        return true;
    }

    public static void main(String[] args) {
        GroupTemplate gt = new GroupTemplate();
        gt.registerFunctionPackage("shiro", new ShiroExt());
    }
}
