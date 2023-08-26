package com.powernode.blogadmin.model.param;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/**
 * User: hallen
 * Date: 2023/8/26
 * Time: 13:34
 */
@Data
@ToString
public class ArticleParam {
    public static interface AddArticle {
    }

    ;

    public static interface EditArticle {
    }

    ;

    @NotNull(message = "修改必须有id", groups = {EditArticle.class})
    @Min(value = 1, message = "id大于{value}", groups = {EditArticle.class})
    private Integer id;//文章id
    @NotBlank(message = "标题不能为空", groups = {EditArticle.class, AddArticle.class})
    @Size(min = 5, max = 20, message = "标题长度必须在{min}-{max}之间", groups = {EditArticle.class, AddArticle.class})
    private String title;
    @NotBlank(message = "副标题不能为空", groups = {EditArticle.class, AddArticle.class})
    @Size(min = 5, max = 20, message = "副标题长度必须在{min}-{max}之间", groups = {EditArticle.class, AddArticle.class})
    private String summary;
    @NotBlank(message = "内容不能为空", groups = {EditArticle.class, AddArticle.class})
    @Size(min = 10, max = 8000, message = "内容长度必须在{min}-{max}之间", groups = {EditArticle.class, AddArticle.class})
    private String content;
}

