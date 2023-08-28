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
    //查询所有热点文章
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

    //插入文章内容
    @Insert("""
            insert into article_detail (article_id, content) values (#{articleId},#{content});
            """)
    int insertArticleDetil(ArticleDetailPO articleDetailPO);

    //两个表的连接,展示文章信息
    @Select("""
                select m.id as article_id,title,summary,ad.content
                from article m inner join article_detail ad
                on m.id =ad.article_id
                where m.id=#{id};
            """)
    //写映射
    @Results(id = "ArticleAndDetailMapper", value = {
            @Result(id = true, column = "article_id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "content", property = "content")
    })
    ArticleDto selectArticleById(Integer id);

    //更新文章属性
    @Update("""
            update article 
            set title=#{title} ,summary=#{summary},update_time=#{updateTime}
            where id=#{id};
            """)
    int editArticle(ArticleVo articleVo);

    //更新文章内容
    @Update("""
            update article_detail 
            set content=#{content}
            where article_id=#{id};
            """)
    int editArticleDetail(ArticleVo articleVo);

    @Delete("""
            DELETE FROM article
            WHERE id=#{id};
            """)
    int removeArticle(Integer id);

    @Delete("""
            DELETE FROM article_detail
            WHERE article_id=#{id};
            """)
    int removeArticleDetail(Integer id);

    @Select("""
            select id, article_id, content
            from article_detail 
            where article_id=#{articleId};
            """)
    @Results(id="articleDetailMapper",value = {
            @Result(id=true ,column = "id",property = "id"),
            @Result(column = "content",property = "content"),
            @Result(column = "article_id" ,property = "articleId")
    })
    ArticleDetailPO query(Integer articleId);
}
