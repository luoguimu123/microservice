package com.pcncad.lgm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZkBootApplication {
	
	private static int port = 8080;
	
	public static void main(String[] args) {
		for(int i = port; ; i++){
			if (!isLoclePortUsing(i)) {
				port = i;
				break;
			}
		}
		SpringApplication.run(ZkBootApplication.class, args);
	}
	
	@Bean
	public ZkClient zkClient(){
		return new ZkClient("127.0.0.1:2181");
	}
	
	@Bean
	public ZKHelper zkHelper() {
		return new ZKHelper(zkClient(), port);
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainerFactory() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(port);
		return factory;
	}
	
    public static boolean isLoclePortUsing(int port){  
        boolean flag = true;  
        try {  
            flag = isPortUsing("127.0.0.1", port);  
        } catch (Exception e) {  
        }  
        return flag;  
    }  

    public static boolean isPortUsing(String host,int port) throws UnknownHostException{  
        boolean flag = false;  
        InetAddress theAddress = InetAddress.getByName(host);  
        try {  
            Socket socket = new Socket(theAddress,port);  
            flag = true;  
        } catch (IOException e) {  
              
        }  
        return flag;  
    } 
	

}






















