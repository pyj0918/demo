package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 要实现动态代理，需实现此接口
 * @author angelo
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	//被代理的对象
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
		System.out.println("调用前");
	}
	
	public void after(){
		System.out.println("调用后");
	}

}
