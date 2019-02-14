package com.test05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.test01.connection.JDBCTools;

public class BaseDao {
	// 执行insert,update,delete
	public void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1,args[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCTools.release(null, ps, conn);
		}
	}

	public <T> T get(Class<T> clazz, String sql, Object... args) {
		return null;
	}

	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
		return null;
	}

	public <E> E getValue(String sql, Object... args) {
		return null;
	}
}
