package com.syy;
/**
 * 3-4.相当于装货卸货
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBean1 {
	public static void main(String[] args) throws SQLException {
		/**
		 * 1:驱动配置（创建对象）
		 * */
		//将驱动包加载置项目
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 2：拼接数据库  连接字符串
		 * ip	username password	port	mysqldb
		 * locaohost	root	zhaolong	3306	mysqlDB
		 * */
		//拼接字符串
		String mysql="jdbc:mysql://localhost:3306/mysqlDB";
		//通过mysql字符串和用户名，密码。生成连接该数据库的Connection对象
		Connection con = DriverManager.getConnection(mysql, "root", "zhaolong");
		/**
		 * 3:执行sql
		 * */
		//准备sql
		String sql="select * from users";
		//创建对象
		Statement st = con.createStatement();
		//执行完Query后返回Resultset
		ResultSet rs = st.executeQuery(sql);
		/**
		 * 4:处理结果
		 * */
		while(rs.next()){
			System.out.println(rs.getInt(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println(rs.getObject(6));
		}
		/**
		 * 5:关闭资源
		 * */
		rs.close();//相当于工人,去获取ResultSet中的数据
		st.close();
		con.close();
		
	}
}
