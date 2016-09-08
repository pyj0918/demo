package com.test04.metadata;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test01.connection.JDBCTools;

public class Test04 {
	
	@Test
	public void test(){
		UserEntity user = new UserEntity();
		String sql = "select * from user where id=?";
		get(UserEntity.class,sql,1);
	}
	
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			// 利用反射创建对象
			entity = clazz.newInstance();
			ResultSetMetaData msmd = rs.getMetaData();
			Map<String,Object> map = new HashMap<String,Object>();
			while (rs.next()) {
				for (int i = 0; i < msmd.getColumnCount(); i++) {
					String columnName = msmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(columnName);
					map.put(columnName, columnValue);
					
					//TODO 利用反射，包装成对象					
					Field[] fields = entity.getClass().getDeclaredFields();
					for (int j = 0; j < fields.length; j++) {
						//获取字段上的注解
						fields[j].getAnnotations();
					}
					
				}
			}
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{	
			JDBCTools.release(rs, ps, conn);
		}
		
		return entity;
	}
}
