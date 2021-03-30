package com.music.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.music.dao.UserDAO;
import com.music.dto.User;
import com.music.utils.JDBCUtils;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/DoRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String interesting,education,email,gender,password,name;
		int age; 
		
		name=request.getParameter("username");
		password=request.getParameter("password");
//		age=Integer.valueOf(request.getParameter("age"));
//		gender=request.getParameter("gender");
//		email=request.getParameter("email");
//		education=request.getParameter("education");
//		interesting=request.getParameter("interesting");
		
//		User user=new User(name,password,age,gender,email,education,interesting);
		User user=new User(name,password);
		PrintWriter pw=response.getWriter();
		Map<String,String> m=new HashMap<>();
		if(UserDAO.addUser(user)) {
//			response.sendRedirect("registerSuccess.jsp");
			m.put("errmsg", "success");
		}else {
//			response.sendRedirect("register.jsp");
			m.put("errmsg", "regfaild");
		}
		pw.print(JSON.toJSON(m).toString());
		
				
		//response.getWriter().print(name);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
