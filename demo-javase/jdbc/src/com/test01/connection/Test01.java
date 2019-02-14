package com.test01.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class Test01 {

	@Test
	public void testDriver() throws SQLException{
		//创建一个Driver实现类对象
		Driver driver = new com.mysql.jdbc.Driver();
		String url="jdbc:mysql://localhost:3306/base-data";
		Properties info = new Properties();
		info.put("user","root");//必须写user
		info.put("password", "123");//必须写password	
		Connection connection = driver.connect(url,info);
		System.out.println(connection);
	}
	
	//与具体实现类解耦
	private Connection getConnection() throws Exception{
		String driverClass=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;
		
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		Driver driver = (Driver) Class.forName(driverClass).newInstance();
		
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",password);
		
		Connection connection = driver.connect(jdbcUrl, info);
		return connection;
	}
	
	@Test
	public void testConnection() throws Exception{
		System.out.println(getConnection());
	}
	
	/**
	 * 使用DriverManager，实现驱动的管理
	 * @throws Exception
	 */
	@Test
	public void testDriverManager() throws Exception{
		String driverClass=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;	
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",password);
		//注册驱动
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(jdbcUrl, info);
		System.out.println(connection);
	}
	
	
}
