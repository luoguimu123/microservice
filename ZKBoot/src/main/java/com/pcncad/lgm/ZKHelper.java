package com.pcncad.lgm;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;

public class ZKHelper {

	private ZkClient zkClient;
	
	public ZKHelper(ZkClient zkClient, int port)  {
		this.zkClient = zkClient;
		if (!this.zkClient.exists("/service")) {
			this.zkClient.create("/service", "this is log", CreateMode.PERSISTENT);
		}
		this.zkClient.createEphemeralSequential("/service/logservice-", "http://127.0.0.1:"+port+"/test");
	}
	
	
}
