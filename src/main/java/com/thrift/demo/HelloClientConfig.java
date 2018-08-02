package com.thrift.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloClientConfig {
    @Bean(initMethod = "init")
    public HelloAsyncClient helloAsyncClient() {
        HelloAsyncClient helloAsyncClient = new HelloAsyncClient();
        helloAsyncClient.setHost("localhost");
        helloAsyncClient.setPort(7911);

        return helloAsyncClient;
    }
}
