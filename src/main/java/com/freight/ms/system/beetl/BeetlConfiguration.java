package com.freight.ms.system.beetl;

import com.freight.ms.system.shiro.ShiroExt;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {
    @Override
    protected void initOther() {
        super.initOther();
        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
    }
}
