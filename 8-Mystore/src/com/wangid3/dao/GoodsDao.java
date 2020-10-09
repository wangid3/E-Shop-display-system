package com.wangid3.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wangid3.domain.Goods;
import com.wangid3.util.JdbcUtil;

public class GoodsDao {

	public List<Goods> findAllGoods() throws Exception {
		 	//1.连接数据库
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			// 2.从数据库当中获取数据
			String sql = "select * from goods where rownum<= 20 minus select * from goods where rownum<= 0";
			List<Goods> allGoods = null;
				allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
			return allGoods;
	}
	public List<Goods> findGoodsByCid(String cid) throws Exception{
	 	//1.连接数据库
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		// 2.从数据库当中获取数据
		String sql = "select * from goods where cid = ? and rownum<= 20 minus select * from goods where cid = ? and rownum<= 0";
		List<Goods> Goods = null;
		Goods = qr.query(sql, new BeanListHandler<Goods>(Goods.class),Integer.parseInt(cid),Integer.parseInt(cid));
		return Goods;
}
}
