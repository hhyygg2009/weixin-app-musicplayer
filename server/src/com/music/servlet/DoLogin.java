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
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
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

		
		User user=new User(name,password);
		PrintWriter pw=response.getWriter();
		
		
		
		Map<String,String> m=new HashMap<>();
//		m.put("errcode", "0");
		if(name==null||password==null) {
			m.put("errmsg", "NULL");
		}else if(UserDAO.checkUser(user)) {
			m.put("errmsg", "success");
			m.put("token", "8888");
		}else {

			m.put("errmsg", "passerr");
		}
		pw.print(JSON.toJSON(m).toString());
				

		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
