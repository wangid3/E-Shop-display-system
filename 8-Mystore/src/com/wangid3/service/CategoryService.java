package com.wangid3.service;
import java.util.List;

import com.wangid3.dao.CategoryDao;
import com.wangid3.domain.Category;
public class CategoryService {
	//��ȡ���еķ�����Ϣ
	public List<Category> findCategory() throws Exception {
		//�����ݿ⵱�в���
		CategoryDao categoryDao = new CategoryDao();
		List<Category> allCategory = categoryDao.getAllCategory();
		return allCategory;
	}
}
