package com.powernode.blogadmin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.powernode.blogadmin.model.dto.ArticleDto;

import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;
import com.powernode.blogadmin.model.param.ArticleParam;
import com.powernode.blogadmin.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDateTime;
import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:40
 */

@RequiredArgsConstructor
@Controller
public class ArticleController {

    /**
     * 因为是final修饰,springboot创建bean的时候不能进行修改(不能使用setter方法)
     * 不能用@Resource,和@Autowired进行注入(这两种注入都是基于setter方法)\
     * 只能用构造注入的方式,使用@RequiredArgsConstructor
     */
    private final ArticleService articleService;

    //查询热点文章
    @GetMapping(value = {"/", "/article/hot"})
    public String showHotArticle(Model model) {
        List<ArticlePo> articlePoList = articleService.queryHot();
        //转为vo 用hutool工具类
        List<ArticleVo> articleVoList = BeanUtil.copyToList(articlePoList, ArticleVo.class);

        //添加数据
        model.addAttribute("article", articleVoList);

        //指定视图
        return "blog/articleList";

    }

    /**
     * 发布文章
     * @Validated(ArticleParam.AddArticle.class) 校验参数
     * @param param
     * @return
     */
    @PostMapping("/article/add")
    public String addArticle(@Validated(ArticleParam.AddArticle.class) ArticleParam param) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setContent(param.getContent());
        articleDto.setId(param.getId());
        articleDto.setSummary(param.getSummary());
        articleDto.setTitle(param.getTitle());
        //调用service里的添加方法
        Boolean add = articleService.add(articleDto);
        return "redirect:/article/hot";
    }

    //按主键id查询文章内容
    @GetMapping("/article/get")
    public String queryArticle(Integer id, Model model) {
        //调用service方法进行查询
        ArticleDto articleDto = articleService.selectById(id);
        //DTO转Vo
        ArticleVo articleVo = BeanUtil.copyProperties(articleDto, ArticleVo.class);
        //绑定数据,传给前端
        model.addAttribute("article", articleVo);

        //跳转视图
        return "/blog/editArticle";
    }

    //更新文章
    @PostMapping("/article/edit")
    public String editArticle(@Validated(ArticleParam.EditArticle.class) ArticleParam param) {
        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(param.getId());
        articleVo.setSummary(param.getSummary());
        articleVo.setTitle(param.getTitle());
        articleVo.setUpdateTime(LocalDateTime.now());
        articleVo.setContent(param.getContent());
        boolean edit = articleService.edit(articleVo);

        return "redirect:/article/hot";
    }
}
