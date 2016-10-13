package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Ҫʵ�ֶ�̬������ʵ�ִ˽ӿ�
 * @author angelo
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	//������Ķ���
	Object target;

	public DynamicProxy(Object target){
		this.target = target;
	}
	
	public <T> T getProxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object result = method.invoke(target,args);
		after();
		return result;
	}
	
	public void before(){
		System.out.println("����ǰ");
	}
	
	public void after(){
		System.out.println("���ú�");
	}

}
