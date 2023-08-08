package com.powernode.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User: hallen
 * Date: 2023/8/8
 * Time: 21:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userId;
    private String cardType;
    private String cardNo;
    private String userName;
    private String userSex;
    private String userAge;
    private String userRole;
}
