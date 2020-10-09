package com.wangid3.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wangid3.domain.Category;
import com.wangid3.util.JdbcUtil;

public class CategoryDao {

	//��ȡ���з�����Ϣ
	public List<Category> getAllCategory() throws Exception {	
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		List<Category> allCategory = null;
		allCategory = qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		return allCategory;
		
	}

}
