package com.blog.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author 于立凯
 * @Description
 * @Date 2021年07月08日 17:01
 */

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
