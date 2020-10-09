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
		 	//1.连接数据库
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			// 2.从数据库当中获取数据
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

		//到数据库当中查询
		//1.连接
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//QueryRunner qr=new QueryRunner(JDBCUtil.getDataSource());
		//2.查询
		String sql ="select * from Users where username=? and password=?";
		//3.执行查询
		Users user = null;
		user = qr.query(sql, new BeanHandler<Users>(Users.class),name,pwd);
		//返回查询结果
		return user;
	}
	
	public  void  insertUser(Users u) throws Exception {
	
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql ="insert into users values(?,?,?,?)";
		qr.update(sql,u.getId(),u.getUsername(),u.getPassword(),u.getPhone());
		
	}

}