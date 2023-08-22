package com.powernode.exp.controller;

import com.powernode.exp.vo.OrderVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: hallen
 * Date: 2023/8/22
 * Time: 19:42
 */
@RestController
public class OrderController {
    @PostMapping("/order/new")
    public String createorder(@Validated
                              @RequestBody OrderVo orderVo) {
        return orderVo.toString();
    }
}
