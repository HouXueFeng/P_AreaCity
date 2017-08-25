package com.xapi.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JdbcUtils {
	public static void main(String[] args) throws SQLException {
		Connection connection = getConnection();
		System.out.println(connection);
	}
	/**
	 * c3p0链接数据库
	 */
	private static DataSource ds = null;
	static {
		ds = new ComboPooledDataSource("mysql");//获取自定义的xml标签头
	}

	public static DataSource getDataSource() {
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
		/**
		 * 关闭数据库
		 */
	public static void close(Connection connection, PreparedStatement sta, ResultSet resultSet) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}