package com.powernode.transation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 17:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Act {
    private Integer id;
    private Integer actNo;
    private Double balance;
}
