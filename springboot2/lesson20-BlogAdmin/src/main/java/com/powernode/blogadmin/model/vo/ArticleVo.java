package com.powernode.blogadmin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:44
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleVo {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

