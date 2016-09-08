package com.study.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value={"names"})
@RequestMapping("/springmvc")
@Controller
public class Test {
	
	/**
	 * 处理模型数据第一种方式：
	 * 对ModelAndView进行测试
	 * @return
	 */
	@RequestMapping("/testmodelandview")
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("time",new Date());
		return mv;
	}
	
	/**
	 * 处理模型数据第二种方式：
	 * 对ModelAndView进行测试
	 * @return
	 */
	@RequestMapping("/testmap")
	public String testmap(Map<String,Object> map) {
		System.out.println("map的实际类型："+map.getClass());
		map.put("names",Arrays.asList("tom","jack"));
		return "success";
	}
	
	/**
	 * 处理模型数据第三种方式：在类上添加@SessionAttributes
	 * @param map
	 * @return
	 */
	@RequestMapping("/testsessionattributes")
	public String testSessionAttribute(Map<String,Object> map){
		//在类上添加SessionAttributes后，指定注解的值为names
		map.put("names",Arrays.asList("tom","jack"));
		return "success";
	}
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(id!=null){
			//模拟从数据库取数据
			User user = new User("1","tom","123","123@qq.com","12");
			System.out.println("从数据库获取一个对象："+user);
			map.put("user", user);
		}
	}
	
	
	@RequestMapping("/testmodelattribute")
	public String testModelAttribute(User user){
		System.out.println("修改："+user);
		return "success";
	}
}
