package com.wangid3.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wangid3.domain.Goods;
import com.wangid3.service.GoodsService;
import com.wangid3.util.JdbcUtil;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		List<Goods> allGoods;
		try {
			allGoods = goodsService.findAllGoods();
			request.setAttribute("allGoods", allGoods);
			
			//转发到商品列表页面，转发时把request对象传入
			request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
