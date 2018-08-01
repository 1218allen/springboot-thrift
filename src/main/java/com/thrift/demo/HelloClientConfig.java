package com.thrift.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloClientConfig {
    @Bean(initMethod = "init")
    public HelloClient helloClient() {
        HelloClient helloClient = new HelloClient();
        helloClient.setHost("localhost");
        helloClient.setPort(7911);

        return helloClient;
    }
}
