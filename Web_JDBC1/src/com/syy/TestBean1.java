package com.syy;
/**
 * 3-4.�൱��װ��ж��
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBean1 {
	public static void main(String[] args) throws SQLException {
		/**
		 * 1:�������ã���������
		 * */
		//����������������Ŀ
		//����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 2��ƴ�����ݿ�  �����ַ���
		 * ip	username password	port	mysqldb
		 * locaohost	root	zhaolong	3306	mysqlDB
		 * */
		//ƴ���ַ���
		String mysql="jdbc:mysql://localhost:3306/mysqlDB";
		//ͨ��mysql�ַ������û��������롣�������Ӹ����ݿ��Connection����
		Connection con = DriverManager.getConnection(mysql, "root", "zhaolong");
		/**
		 * 3:ִ��sql
		 * */
		//׼��sql
		String sql="select * from users";
		//��������
		Statement st = con.createStatement();
		//ִ����Query�󷵻�Resultset
		ResultSet rs = st.executeQuery(sql);
		/**
		 * 4:������
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
		 * 5:�ر���Դ
		 * */
		rs.close();//�൱�ڹ���,ȥ��ȡResultSet�е�����
		st.close();
		con.close();
		
	}
}
