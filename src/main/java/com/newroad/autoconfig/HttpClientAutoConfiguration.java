package com.newroad.autoconfig;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableConfigurationProperties(HttpClientProperties.class)
@ConditionalOnClass({HttpClient.class})//当拥有HttpClient这个类时才起作用
public class HttpClientAutoConfiguration {
   private  final  HttpClientProperties properties;
    public HttpClientAutoConfiguration(HttpClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient(){
            //一、连接目标服务器超时时间：ConnectionTimeout-->指的是连接一个url的连接等待时间
        RequestConfig config=RequestConfig.custom()
                .setConnectionRequestTimeout(properties.getConnectTimeout())
                //二、读取目标服务器数据超时时间：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
                .setSocketTimeout(properties.getConnectTimeout()).build();
        HttpClient client= HttpClientBuilder.create()
         // 这个超时可以设置为客户端级别,作为所有请求的默认值：
                .setDefaultRequestConfig(config).
                        setUserAgent(properties.getAgent()).
                        setMaxConnPerRoute(properties.getMaxConnPerRoute()).
                        setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();

        return client;


    }

}
