package com.powernode.exp.handler;

/**
 * User: hallen
 * Date: 2023/8/22
 * Time: 16:23
 */

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.在类的上面加入@ControllerAdvice,@RestControllerAdvice
 * 灵活组合@ControllerAdvice @ResponseBody
 * 2.在类中自定义方法，处理齐种异常。
 * 方法定义Controller类中的方法的定义
 * 控制器增强，给Controller增加异常处理功能。类似A0P的思想
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法处理数学异常
    /* @ExceptionHandler({ArithmeticException.class})
    public String handlerArtithmeticException(ArithmeticException e, Model model) {
        String error = e.getMessage();
        model.addAttribute("error", error);
        return "exp";//指定视图页面
    }*/
    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public Map<String, String> handlerArtithmeticException(ArithmeticException e, Model model) {
        Map<String, String> error = new HashMap<>();
        String massige = e.getMessage();
        error.put("msg", massige);
        error.put("tip", "被除数不能为0");
        return error;
    }

    //处理JSR303验证参数的异常
    @ExceptionHandler({BindException.class})
    @ResponseBody public Map<String, Object> handlerJSR303Exception(BindException e) {
        Map<String, Object> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (int i = 0, len = errors.size(); i < len; i++) {
                FieldError field = errors.get(i);
                map.put(i + "-" + field.getField(), field.getDefaultMessage());
            }
        }
        return map;
    }


}
