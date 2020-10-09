package com.wangid3.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wangid3.domain.Goods;
import com.wangid3.domain.Users;
import com.wangid3.util.JdbcUtil;

public class UserDao {

	public List<Users> findAllUsers() throws Exception{
		 	//1.�������ݿ�
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			// 2.�����ݿ⵱�л�ȡ����
			String sql = "select * from Users";
			List<Users> allUsers = null;
			try {
				allUsers = qr.query(sql, new BeanListHandler<Users>(Users.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return allUsers;
	}
	
	public Users checkUser(String name, String pwd) throws Exception {

		//�����ݿ⵱�в�ѯ
		//1.����
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//QueryRunner qr=new QueryRunner(JDBCUtil.getDataSource());
		//2.��ѯ
		String sql ="select * from Users where username=? and password=?";
		//3.ִ�в�ѯ
		Users user = null;
		user = qr.query(sql, new BeanHandler<Users>(Users.class),name,pwd);
		//���ز�ѯ���
		return user;
	}
	
	public  void  insertUser(Users u) throws Exception {
	
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql ="insert into users values(?,?,?,?)";
		qr.update(sql,u.getId(),u.getUsername(),u.getPassword(),u.getPhone());
		
	}

}