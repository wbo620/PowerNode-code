package com.powernode.blogadmin.handler;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/26
 * Time: 14:31
 */
@ControllerAdvice
public class GlobalExacpletionHandler
{
    @ExceptionHandler({BindException.class})
    public String handlerBindExacpletion(BindException bindException, Model model){
        BindingResult bindingResult = bindException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        model.addAttribute("errors", fieldErrors);

        return "/blog/error/bind";

    }
}
