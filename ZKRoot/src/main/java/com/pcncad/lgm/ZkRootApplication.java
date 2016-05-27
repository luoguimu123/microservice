package com.pcncad.lgm;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZkRootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkRootApplication.class, args);
	}
	
	@Bean
	public ZkClient zkClient() {
		return new ZkClient("127.0.0.1:2181");
	}
	
	@Bean
	public ZKHelper zkHelper(ZkClient zkClient) {
		return new ZKHelper(zkClient);
	}
	
}
