package com.powernode.blogadmin.service;

import com.powernode.blogadmin.model.pojo.ArticlePo;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:27
 */

public interface ArticleService {

    List<ArticlePo> queryHot();

}
