package com.pcncad.lgm;

import java.util.ArrayList;
import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

public class ZKHelper {

	private List<String> list = new ArrayList<>();
	
	private ZkClient zkClient;

	public ZKHelper(ZkClient zkClient) {
		this.zkClient = zkClient;
		this.list = zkClient.getChildren("/service");
		this.zkClient.subscribeChildChanges("/service",new IZkChildListener() {
			
			@Override
			public void handleChildChange(String arg0, List<String> arg1) throws Exception {
				for(String s : arg1){
					System.out.println(s);
				}
				list = arg1;
			}
		});
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public ZkClient getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZkClient zkClient) {
		this.zkClient = zkClient;
	}
	
	
}
