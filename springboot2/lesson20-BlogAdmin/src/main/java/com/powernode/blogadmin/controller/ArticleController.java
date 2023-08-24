package com.powernode.blogadmin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;
import com.powernode.blogadmin.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:40
 */

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    //查询热点文章
    @GetMapping(value = {"/", "/article/hot"})
    public String showHotArticle(Model model) {
        List<ArticlePo> articlePoList = articleService.queryHot();
        //转为vo 用hutool工具类
        List<ArticleVo> articleVoList = BeanUtil.copyToList(articlePoList, ArticleVo.class);

        //添加数据
        model.addAttribute("articleList", articleVoList);

        //指定视图
        return "blog/articleList";


    }
}
