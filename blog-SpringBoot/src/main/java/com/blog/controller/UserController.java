package com.blog.controller;


import com.blog.common.lang.Result;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @RequestMapping("/index")
    public Object index(){

        User user = userService.getById(1);
        return Result.succ(200,"操作成功",user);
    }


    @PostMapping ("/save")
    public Object save(@Validated @RequestBody  User user){
        return Result.succ(user);
    }
}
