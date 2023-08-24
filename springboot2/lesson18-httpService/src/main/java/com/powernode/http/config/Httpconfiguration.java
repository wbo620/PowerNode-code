package com.powernode.http.config;

import com.powernode.http.service.AlbumService;
import com.powernode.http.service.TodoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 15:40
 */

/**
 * 3. 创建代理对象
 */
@Configuration(proxyBeanMethods = false)
public class Httpconfiguration {
    //创建服务接口的代理对象,基于WebClient
    //第一种方式
    @Bean
    public TodoService requestService() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
        //创建代理工厂
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        //通过工厂创建某个代理的对象进行返回
        return proxyFactory.createClient(TodoService.class);
    }

    //第二种方式
    @Bean
    public AlbumService getAlbumService() {

        //定制Http服务
        //超时
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000) //连接时间
                .doOnConnected(conn -> {
                    conn.addHandlerLast(new ReadTimeoutHandler(10));//读超时
                    conn.addHandlerLast(new WriteTimeoutHandler(10));//写超时
                });
        //设置异常
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    System.out.println("*******Webclient请求异常********");
                    return Mono.error(new RuntimeException("" + clientResponse.statusCode().value()));
                }).build();

        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return proxyFactory.createClient(AlbumService.class);
    }
}
