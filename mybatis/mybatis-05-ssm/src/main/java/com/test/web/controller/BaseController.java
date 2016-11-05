package com.test.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {
	public void write(HttpServletResponse response, String content)
			throws Exception {
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setDateHeader("Expires", -1);

			try {
				PrintWriter writer = response.getWriter();
				writer.write(content);
				writer.flush();
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
