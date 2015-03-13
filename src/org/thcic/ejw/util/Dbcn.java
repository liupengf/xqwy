package org.thcic.ejw.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dbcn {
	// 构造函数
	public Dbcn() {
	}

	public static Connection getConn() {
		Connection conn = null;
		String url = "jdbc/OracleDB";

		try {
			Context env = (Context) new InitialContext()
					.lookup("java:comp/env");
			DataSource pool = (DataSource) env.lookup(url);
			conn = pool.getConnection();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Dbcn.getConn方法：连接池中建立与数据库连接失败！");
		}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,PreparedStatement ps1,Connection con) {
		try {
			if (null != rs) {
				rs.close();
			}
			if(null != ps){
				ps.close();
			}
			if(null != ps1){
				ps1.close();
			}
			if (null != con) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>关闭数据库连接出错!>>>>>>>>>>>");
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement ps1,Connection con) {
		try {
			if (null != rs) {
				rs.close();
			}
			if(null != ps1){
				ps1.close();
			}
			if (null != con) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>关闭数据库连接出错!>>>>>>>>>>>");
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs, Statement sta1,Connection con) {
		try {
			if (null != rs) {
				rs.close();
			}
			if(null != sta1){
				sta1.close();
			}
			if (null != con) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>关闭数据库连接出错!>>>>>>>>>>>");
			e.printStackTrace();
		}
	}
}
