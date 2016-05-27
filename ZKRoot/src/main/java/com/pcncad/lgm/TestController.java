package com.pcncad.lgm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class TestController {

	@Autowired
	private ZKHelper zkHelper;
	
	@RequestMapping(value="/zk", method=RequestMethod.GET)
	private void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<String> result = new ArrayList<>();
		for(String s : zkHelper.getList()){
			String string = zkHelper.getZkClient().readData("/service/"+s);
			result.add(string);
		}
		response.getWriter().write(new Gson().toJson(result));
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Runtime.getRuntime().exec("/Users/lgm/Desktop/test.sh");
		response.getWriter().write("success");
	}

	public ZKHelper getZkHelper() {
		return zkHelper;
	}

	public void setZkHelper(ZKHelper zkHelper) {
		this.zkHelper = zkHelper;
	}
	
	
	
}
