package com.blog.util;

import com.blog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @Author 于立凯
 * @Description
 * @Date 2021年07月09日 14:29
 */

public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
