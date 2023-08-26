package com.powernode.blogadmin.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * User: hallen
 * Date: 2023/8/26
 * Time: 13:50
 */
@Data
@ToString
public class ArticleDto {
    private Integer id;
    private String title;
    private String summary;
    private String content;
}
