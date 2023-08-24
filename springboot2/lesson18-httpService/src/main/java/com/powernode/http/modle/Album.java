package com.powernode.http.modle;

import lombok.Data;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 16:42
 */

/**
 * 1.创建实体类
 */
@Data
public class Album {
    private Integer id;
    private Integer userId;
    private String title;
}
