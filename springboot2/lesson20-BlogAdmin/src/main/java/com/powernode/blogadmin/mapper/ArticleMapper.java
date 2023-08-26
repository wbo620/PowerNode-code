package com.powernode.blogadmin.mapper;

import com.powernode.blogadmin.model.dto.ArticleDto;

import com.powernode.blogadmin.model.pojo.ArticleDetailPO;
import com.powernode.blogadmin.model.pojo.ArticlePo;
import com.powernode.blogadmin.model.vo.ArticleVo;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 23:09
 */
public interface ArticleMapper {
    //查询首页内容
    //热点文章
    @Select("""
                select id, user_id,title,summary
            , read_count,create_time,update_time 
                from article
                where read_count>=#{lowRead}
                order by read_count desc
                limit #{topRead}
            """)
    @Results(id = "ArticleBaseMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<ArticlePo> selecHot(Integer lowRead, Integer topRead);


    //发布新文章
    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time)
             values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertArticle(ArticlePo articlePo);

    @Insert("""
            insert into article_detail (article_id, content) values (#{articleId},#{content});
            """)
    int insertArticleDetil(ArticleDetailPO articleDetailPO);

    //两个表的连接
    @Select("""
                select m.id as aticle_id,title,summary,ad.content
                from article m inner join article_detail ad
                on m.id =ad.article_id
                where m.id=#{id};
            """)
    @Results(id = "ArticleAndDetailMapper", value = {
            @Result(id = true, column = "article_id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "content", property = "content")
    })
    ArticleDto selectArticleById(Integer id);

    @Update("""
            update article 
            set title=#{title} ,summary=#{summary},update_time=#{updateTime}
            where id=#{id};
            """)
    int editArticle(ArticleVo articleVo);

    @Update("""
            update article_detail 
            set content=#{content}
            where article_id=#{id};
            """)
    int editArticleDetail(ArticleVo articleVo);

}
