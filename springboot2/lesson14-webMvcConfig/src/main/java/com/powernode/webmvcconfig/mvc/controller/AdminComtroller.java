package com.powernode.webmvcconfig.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 21:53
 */
@RestController
public class AdminComtroller {
    @PostMapping("/admin/add")
    public String add(){
       return "发布文章";
    }
    @DeleteMapping("/admin/delete")
    public String remove(){
        return"删除文章";
    }
    @PostMapping("/admin/update")
    public String update(){
        return"修改文章";
    }
    @GetMapping("/admin/select")
    public String select(){
        return"查询文章";
    }
}
