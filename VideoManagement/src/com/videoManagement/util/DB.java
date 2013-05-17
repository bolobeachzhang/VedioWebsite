
package com.videoManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* @ClassName: DB 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 张兵 【390125214@qq.com】
* @date 2012-7-12 上午10:06:47 
*  
*/
public class DB {
	//下面是sqlserver2008连接数据库的方式
	private String DBDrive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String DBUrl = "jdbc:sqlserver://180.84.33.77:1433;databaseName=videoManageMent";
	private String DBUser = "sa";
	private String DBPassword = "123456";
	private ResultSet _rs = null;
	private Connection _conn = null;
	private Statement _stmt = null;
	/**
	 * 执行一则更新语句，返回主键值
	 * 
	 * @param sql
	 * @return
	 */
	
	public Connection getConn() {
		try {
			System.out.println("数据库进来了");
			
			Class.forName(DBDrive);
			_conn = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
			System.out.println("数据库可以使用了!!!!");
		} catch (Exception e) {
			System.out.println("---------出现异常，获取连接失败--------");
			e.printStackTrace();
		}
		return _conn;
	}
	
	
	public int executeUpdate(String sql) {
		int result = -1;
		try {

			// 执行sql
			_stmt = getConn().createStatement();
			_stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			// 获取主键
			_rs = _stmt.getGeneratedKeys();
			while (_rs.next()) {
				// 获取最后一个主键值
				result = _rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.colse();
		}
		return result;
	}

	public ResultSet executeQuery(String sql) {

		try {
			// 执行sql
			_stmt = getConn().createStatement();
			_rs = _stmt.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return _rs;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	

	// 关闭数据库操作。。。。
	public boolean colse() {
		try {
			if (_rs != null) {
				_rs.close();
			}
			if (_stmt != null) {
				_stmt.close();
			}
			if (_conn != null) {
				_conn.close();
			}
			return true;
		} catch (SQLException e) {
			System.out.println("关闭失败。。。。。");
			e.printStackTrace();
			return false;
		}
	}

}
