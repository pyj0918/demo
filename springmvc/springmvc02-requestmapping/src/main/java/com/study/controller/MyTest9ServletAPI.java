package com.study.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springmvc")
@Controller
public class MyTest9ServletAPI {

	// mvc��handler�������Խ�����ЩServletApi���͵Ĳ�����
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
