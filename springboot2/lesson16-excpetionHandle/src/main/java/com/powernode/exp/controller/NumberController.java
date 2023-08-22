package com.powernode.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: hallen
 * Date: 2023/8/22
 * Time: 16:09
 */
@RestController
public class NumberController {

    @PostMapping("/divide")
    public String divide(Integer n1, Integer n2) {
        return "" + n1 / n2;
    }
}
