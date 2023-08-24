package com.powernode.blogadmin.service.impl;

import com.powernode.blogadmin.mapper.ArticleMapper;
import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.service.ArticleService;
import com.powernode.blogadmin.settings.ArticleSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:29
 */
@Service
@RequiredArgsConstructor

public class ArticleServiceImpl implements ArticleService {


    private final ArticleMapper articleMapper;
    private final ArticleSettings articleSettings;

    ////构造注入
    //public ArticleServiceImpl(ArticleMapper articleMapper) {
    //    this.articleMapper = articleMapper;
    //}
    @Override
    public List<ArticlePo> queryHot() {
        Integer lowRead = articleSettings.getLowRead();
        Integer topRead = articleSettings.getTopRead();
        return articleMapper.selecHot(lowRead, topRead);
    }
}
