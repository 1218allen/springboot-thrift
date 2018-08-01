package com.thrift.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	private static ThriftServer thriftServer;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		try {
			thriftServer = context.getBean(ThriftServer.class);
			thriftServer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
