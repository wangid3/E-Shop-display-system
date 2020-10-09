package com.wangid3.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wangid3.domain.Goods;
import com.wangid3.service.GoodsService;

@WebServlet("/GoodsServletPro")
public class  GoodsServletPro extends BaseServlet {
	
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.调用服务层
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.findAllGoods();
			request.setAttribute("allGoods", allGoods);
			// 转发
			return "index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getGoodsByCid (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String cid =request.getParameter("cid");	
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.findGoodsbyCid(cid);
			request.setAttribute("allGoods", allGoods);
			// 转发
			return "index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;				
	}
	
	public String logout (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getSession().removeAttribute("user");
		return "/GoodsServletPro?action=getListGoods";
	}
}
