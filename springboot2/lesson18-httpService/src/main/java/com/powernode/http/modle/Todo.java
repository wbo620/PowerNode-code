package com.powernode.http.modle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 15:29
 */

/**
 * 1.创建实体类
 */
@NoArgsConstructor
@Data
public class Todo {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("completed")
    private Boolean completed;
}

