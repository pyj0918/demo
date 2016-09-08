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
	 * ����ģ�����ݵ�һ�ַ�ʽ��
	 * ��ModelAndView���в���
	 * @return
	 */
	@RequestMapping("/testmodelandview")
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("time",new Date());
		return mv;
	}
	
	/**
	 * ����ģ�����ݵڶ��ַ�ʽ��
	 * ��ModelAndView���в���
	 * @return
	 */
	@RequestMapping("/testmap")
	public String testmap(Map<String,Object> map) {
		System.out.println("map��ʵ�����ͣ�"+map.getClass());
		map.put("names",Arrays.asList("tom","jack"));
		return "success";
	}
	
	/**
	 * ����ģ�����ݵ����ַ�ʽ�����������@SessionAttributes
	 * @param map
	 * @return
	 */
	@RequestMapping("/testsessionattributes")
	public String testSessionAttribute(Map<String,Object> map){
		//���������SessionAttributes��ָ��ע���ֵΪnames
		map.put("names",Arrays.asList("tom","jack"));
		return "success";
	}
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(id!=null){
			//ģ������ݿ�ȡ����
			User user = new User("1","tom","123","123@qq.com","12");
			System.out.println("�����ݿ��ȡһ������"+user);
			map.put("user", user);
		}
	}
	
	
	@RequestMapping("/testmodelattribute")
	public String testModelAttribute(User user){
		System.out.println("�޸ģ�"+user);
		return "success";
	}
}
