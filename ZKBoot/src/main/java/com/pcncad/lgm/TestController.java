package com.pcncad.lgm;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	private void test(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		
		response.getWriter().write("this is the response string");
	}
	
	
}
