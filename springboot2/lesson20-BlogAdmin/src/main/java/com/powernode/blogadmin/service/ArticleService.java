package com.powernode.blogadmin.service;

import com.powernode.blogadmin.model.dto.ArticleDto;

import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;

import java.util.List;

/**
 * Date: 2023/8/24
 * Time: 23:27
 * @author hallen
 */

public interface ArticleService {

    /**
     * 查询热点文章
     * @return
     */
    List<ArticlePo> queryHot();

    /**
     *  发布文章
     *  需要对article,article_detail这两个表进行插入
     *  @param articleDto 实体类
     *  @return
     */
    Boolean add(ArticleDto articleDto);

    /**
     * 按主键查询
     * @param id 文章id
     * @return
     */

    ArticleDto selectById(Integer id);

    /**
     * 修改文章
     * @param articleVo 包含两个表的一些字段的共同的实体类
     * @return
     */
    boolean edit(ArticleVo articleVo);

    boolean deleteArticle(Integer id);

    String queryTop20Content(Integer id);
}
