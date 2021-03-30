package com.music.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.music.dao.FavorDAO;
import com.music.dto.Favor;

/**
 * Servlet implementation class getFavor
 */
@WebServlet("/getFavor")
public class getFavor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFavor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id,userid,songid;
		userid=request.getParameter("userid");
		PrintWriter pw=response.getWriter();
		Map<String,String> m=new HashMap<>();
		List<Favor> favors=FavorDAO.getFavor(userid);
		List <String> songs=new ArrayList();
		for (Favor f : favors) {
			
			songs.add(String.valueOf(f.getSongid()));
		}
		
		
			pw.print(JSON.toJSON(songs));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
