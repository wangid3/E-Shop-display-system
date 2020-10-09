package com.wangid3.service;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wangid3.dao.GoodsDao;
import com.wangid3.dao.UserDao;
import com.wangid3.domain.Users;
import com.wangid3.util.JdbcUtil;
public class UsersService {
	
	public Users checkUser(String username,String password) throws Exception {
		UserDao userDao = new UserDao();
		return userDao.checkUser(username, password);
	}
	
	public void insertUser(Users user) throws Exception {
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
	}

}
