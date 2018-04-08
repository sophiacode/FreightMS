package com.freight.ms.system.beetl;

import com.freight.ms.system.shiro.ShiroExt;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * Created by wyq on 2018/4/1.
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {
    @Override
    protected void initOther() {
        super.initOther();

        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
    }
}
