package com.powernode.service;

public class UserService {
    public void login(String username, String password) {
        if ("admin".equals(username) && "123".equals(password)) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
    public void logout(){
        System.out.println("退出登录");

    }
}
