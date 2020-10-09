package com.wangid3.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wangid3.domain.Users;
import com.wangid3.service.UsersService;
import com.wangid3.util.JdbcUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名， 密码
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(name+pwd);
		Users u=null;
		try {
			UsersService usersService= new UsersService();
			u = usersService.checkUser(name, pwd);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1.有值
		if(u != null) {
			response.getWriter().write("登录成功");
			//跳转到登录			
			//把登陆成功的用户信息保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("user",u);
			response.setHeader("refresh", "0.5;url=/8-Mystore/GoodsServletPro?action=getListGoods");
		}else {
			response.getWriter().write("登录失败");
			//跳转到登录
			response.setHeader("refresh", "0.5;url=/8-Mystore/login.jsp");
		}
		
	}

}
