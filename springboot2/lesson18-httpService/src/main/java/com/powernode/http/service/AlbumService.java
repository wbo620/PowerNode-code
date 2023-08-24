package com.powernode.http.service;

import com.powernode.http.modle.Album;
import com.powernode.http.record.AlbumRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 16:43
 */
/**
 * 2. 创建接口
 */
@Service
@HttpExchange(url = "https://jsonplaceholder.typicode.com/")
public interface AlbumService {
    //@GetExchange("/albums/{id}")
    @HttpExchange(method = "GET",url ="/albums/{id}" )
    Album getById(@PathVariable Integer id);

    @HttpExchange(method = "GET",url ="/albums/{id}" )
    AlbumRecord getByIdReturnRecord(@PathVariable Integer id);
}
