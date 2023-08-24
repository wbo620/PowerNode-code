package com.powernode.http.service;

import com.powernode.http.modle.Todo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 15:36
 */

/**
 * 2. 创建接口
 */
@Service
public interface TodoService {
    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable("id") Integer id);

    @GetExchange("/todos")
    List<Todo> getAllTodos();

    @PostExchange(value = "/todos/", accept = MediaType.APPLICATION_JSON_VALUE)
    Todo createTodo(@RequestBody Todo newTodo);

    //修改
    @PutExchange("/todos/{id}")
    ResponseEntity<Todo> updateById(@PathVariable("id") Integer id, @RequestBody Todo newTodo);

    //删除
    @DeleteExchange("/todos/{sid}")
    void deleteById(@PathVariable("sid") Integer id);
}
