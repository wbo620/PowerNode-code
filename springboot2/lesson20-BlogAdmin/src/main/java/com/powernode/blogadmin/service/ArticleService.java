package com.powernode.blogadmin.service;

import com.powernode.blogadmin.model.dto.ArticleDto;

import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:27
 */

public interface ArticleService {

    //查询热点文章
    List<ArticlePo> queryHot();

    //发布文章article,anticle_detail
    Boolean add(ArticleDto articleDto);

    ArticleDto selectById(Integer id);

    boolean edit(ArticleVo articleVo);
}
