package com.test03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.test01.connection.JDBCTools;

public class Test03 {

	@Test
	public void testpreparedStatement() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCTools.getConnection();
			String sql = "Insert into user (id,user_name,create_time) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 2);
			ps.setObject(2, "pyj");
			ps.setObject(3, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(null, ps, conn);
		}
	}
}
