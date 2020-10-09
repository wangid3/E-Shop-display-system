package com.wangid3.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.wangid3.domain.Users;
import com.wangid3.service.UsersService;
import com.wangid3.util.JdbcUtil;


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//����������� ����Ӧ�ı���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		//��ȡ����  ��֤��
		String code = request.getParameter("code");
		System.out.println("code="+code);
		//��ȡ���������ɵ���֤��  
		String word = (String) this.getServletContext().getAttribute("checkCode");
		//�ж��������֤
		if(code.equals(word)) {
			//�����ȷ 
			//1.�������в���
			Map<String, String[]> parameterMap = request.getParameterMap();
			try {
				Users u = new Users();
				BeanUtils.populate(u, parameterMap);
				u.setId(UUID.randomUUID().toString());
				UsersService usersService=new UsersService();
				usersService.insertUser(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.getWriter().write("ע��ɹ�");
			//��ת����¼
			response.setHeader("refresh", "0.5;url=/8-Mystore/login.jsp");
		}
		else {
			//����ȷ �������û���֤�������ת��ע��ҳ
			response.getWriter().write("��֤�����");
			response.setHeader("refresh", "0.5;url=/8-Mystore/regist.jsp");
		}
	}
}
