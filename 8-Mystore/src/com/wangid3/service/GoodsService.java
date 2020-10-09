package com.wangid3.service;

import java.util.List;

import com.wangid3.dao.GoodsDao;
import com.wangid3.domain.Goods;

public class GoodsService {

	public List<Goods> findAllGoods() throws Exception {
		GoodsDao goodsDao = new GoodsDao();
		return  goodsDao.findAllGoods();
	}
	
	public List<Goods> findGoodsbyCid(String cid) throws Exception {
		GoodsDao goodsDao = new GoodsDao();
		return  goodsDao.findGoodsByCid(cid);
	}
}
