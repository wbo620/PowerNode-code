package com.powernode.blogadmin.service.impl;

import com.powernode.blogadmin.mapper.ArticleMapper;
import com.powernode.blogadmin.model.dto.ArticleDto;
import com.powernode.blogadmin.model.pojo.ArticleDetailPO;
import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;
import com.powernode.blogadmin.service.ArticleService;
import com.powernode.blogadmin.settings.ArticleSettings;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * Date: 2023/8/24
 * Time: 23:29
 * @author hallen
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

    //发布文章
    //开启事物,遇到异常回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean add(ArticleDto articleDto) {
        //文章
        ArticlePo articlePo = new ArticlePo();
        articlePo.setTitle(articleDto.getTitle());
        articlePo.setSummary(articleDto.getSummary());
        articlePo.setUserId(new Random().nextInt(1000));
        articlePo.setReadCount(new Random().nextInt(100));
        articlePo.setCreateTime(LocalDateTime.now());
        articlePo.setUpdateTime(LocalDateTime.now());
        int count = articleMapper.insertArticle(articlePo);

        //文章内容
        ArticleDetailPO articleDetailPo = new ArticleDetailPO();
        articleDetailPo.setArticleId(articlePo.getId());
        articleDetailPo.setContent(articleDto.getContent());
        count += articleMapper.insertArticleDetil(articleDetailPo);
        if (count == 2) {
            return true;
        }

        return false;
    }

    //按照id查找
    @Override
    public ArticleDto selectById(Integer id) {
        return articleMapper.selectArticleById(id);
    }

    //保存修改的文章
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean edit(ArticleVo articleVo) {
        //修改文章属性
        int count = articleMapper.editArticle(articleVo);
        //修改文章内容
        count += articleMapper.editArticleDetail(articleVo);
        if (count == 2) {
            return true;
        }
        return false;
    }
}
