package com.music.servlet;

import com.alibaba.fastjson.JSON;
import com.music.dao.UserDAO;
import com.music.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/user")
public class setUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public setUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        String interesting, education, email, gender, password, name, set_str;
        int age;

        name = request.getParameter("username");
//		
        set_str = request.getParameter("set");
        boolean set = Boolean.valueOf(set_str);

        PrintWriter pw = response.getWriter();
        Map<String, String> m = new HashMap<>();
        if (set) {
            password = request.getParameter("password");
            age = Integer.valueOf(request.getParameter("age"));
            gender = request.getParameter("gender");
            email = request.getParameter("email");
            education = request.getParameter("education");
            interesting = request.getParameter("interesting");

            User user = new User(name, null, age, gender, email, education, interesting);
//			User user=new User(name,password);
            if (UserDAO.setUser(user)) {
                m.put("errmsg", "success");
            } else {
                m.put("errmsg", "setfaild");
            }
            pw.print(JSON.toJSON(m).toString());
        } else {
            User user = UserDAO.getUser(name);
            user.setPassword(null);
            pw.print(JSON.toJSON(user));

//			m.put("errcode", "0");
//			if(UserDAO.getUser(user)) {
//				m.put("errmsg", "success");
//				m.put("token", "8888");
//			}else {
//
//				m.put("errmsg", "passerr");
//			}


        }


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
