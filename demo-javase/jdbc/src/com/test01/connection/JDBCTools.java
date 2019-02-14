package com.test01.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc工具类
 * @author angelo
 *
 */
public class JDBCTools {
	
	public static Connection getConnection() throws Exception{
		String driverClass=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;	
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",password);
		//加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块.)
		Class.forName(driverClass);
		//通过 DriverManager 的 getConnection() 方法获取数据库连接.
		return DriverManager.getConnection(jdbcUrl, info);
	}
	
	public static void release(ResultSet rs, 
			Statement statement, Connection conn) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
