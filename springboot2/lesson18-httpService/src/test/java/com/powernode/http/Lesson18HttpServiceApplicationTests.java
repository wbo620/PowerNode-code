package com.powernode.http;

import com.powernode.http.config.Httpconfiguration;
import com.powernode.http.modle.Todo;
import com.powernode.http.service.TodoService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 4. 编写测试类
 */
@SpringBootTest
class Lesson18HttpServiceApplicationTests {

    @Resource
    private TodoService todoService;

    @Test
    void testQueryById() {
        Todo todo = todoService.getTodoById(1);
        System.out.println(todo);
    }

    @Test
    void selectAll() {
        List<Todo> allTodos = todoService.getAllTodos();
        allTodos.forEach(todo -> System.out.println(todo));
    }

    @Test
    void creatTodo() {
        Todo todo = new Todo();
        todo.setUserId(1101);
        todo.setTitle("Hello");
        todo.setCompleted(true);
        todo.setId(11);
        Todo newTodo = todoService.createTodo(todo);
        System.out.println(newTodo);
    }

    @Test
    void UpdateById() {
        Todo todo = new Todo();
        todo.setUserId(9999);
        todo.setTitle("Hello9");
        todo.setCompleted(true);
        todo.setId(99);
        ResponseEntity<Todo> todoResponseEntity = todoService.updateById(2, todo);
        HttpStatusCode statusCode = todoResponseEntity.getStatusCode();
        System.out.println(statusCode);
        HttpHeaders headers = todoResponseEntity.getHeaders();
        System.out.println(headers);
        Todo body = todoResponseEntity.getBody();
        System.out.println(body);

    }

    @Test
    void deleteById() {
        todoService.deleteById(1);

    }
}
