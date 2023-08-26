package com.powernode.blogadmin.model.dto;

import lombok.Data;

/**
 * User: hallen
 * Date: 2023/8/26
 * Time: 13:50
 */
@Data
public class ArticleDto {
    private Integer id;
    private String title;
    private String summary;
    private String content;
}
