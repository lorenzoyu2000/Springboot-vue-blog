package com.blog.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 于立凯
 * @Description
 * @Date 2021年07月09日 8:50
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String avatar;

    private String email;
}
