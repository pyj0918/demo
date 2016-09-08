package com.study.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class MyTest9ServletAPI {

	// mvc的handler方法可以接受哪些ServletApi类型的参数：
	// HttpServletRequest
	// HttpServletResponse
	// HttpSession
	// java.security.Principal
	// Locale
	// InputStream
	// OutputStream
	// Reader
	// Writer

	@RequestMapping("testservletapi")
	public void testservletapi(Writer out) throws IOException {
		out.write("333");
	}

}
