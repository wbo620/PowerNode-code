package com.powernode.blogadmin.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:32
 */

@Data
@ConfigurationProperties(prefix = "article")
public class ArticleSettings {
    private Integer lowRead;
    private Integer topRead;
}
