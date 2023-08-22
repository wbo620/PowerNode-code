package com.powernode.exp.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import org.hibernate.validator.constraints.Range;
import org.jetbrains.annotations.NotNull;

/**
 * User: hallen
 * Date: 2023/8/22
 * Time: 16:47
 */

@Data
public class OrderVo {
    @NotBlank(message = "订单名称不能为空")
    private String name;
    @NotNull("商品必须有数量")
    @Range(min = 1, max = 99, message = "一个订单的商品数量在{min}-{max}")
    private Integer amount;
    @NotNull("用户不能为空")
    @Min(value = 1, message = "从1开始")
    private Integer userId;
}
