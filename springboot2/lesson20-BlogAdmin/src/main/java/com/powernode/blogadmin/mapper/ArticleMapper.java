package com.powernode.blogadmin.mapper;

import com.powernode.blogadmin.model.pojo.ArticlePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
