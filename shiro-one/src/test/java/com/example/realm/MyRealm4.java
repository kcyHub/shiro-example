package com.example.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm4 implements Realm {

    @Override
    public String getName() {
        return "myrealm4";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 得到用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        if (!"zhang".equals(username)) {
            throw new UnknownAccountException(); // 如果用户名错误
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException(); // 如果密码错误
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
