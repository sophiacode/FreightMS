package com.freight.ms.system.shiro;

import com.freight.ms.common.constant.UserEnum;
import com.freight.ms.model.User;
import com.freight.ms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;


public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(userService.getRoleID(username));
        authorizationInfo.setStringPermissions(userService.getOperationID(username));
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();

        User user = userService.findUserByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//用户名不存在
        }
        if(user.getStatus() == UserEnum.USER_STATUS_FREEZE.getCode()) {
            throw new LockedAccountException(); //用户锁定
        }

        //进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }
}
