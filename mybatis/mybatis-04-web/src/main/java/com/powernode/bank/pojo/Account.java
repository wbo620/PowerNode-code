package com.powernode.bank.pojo;

import lombok.*;

/**
 * 账户类,封装账户数据
 * @author hallen
 * @version 1.0
 * @since 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {
    private Long id;
    private String actno;
    private Double balance;
}
