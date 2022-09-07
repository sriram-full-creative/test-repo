package com.fullcreative.sriramnsm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet(name = "ArrMessageServlet", urlPatterns = { "/arrmessages" })
public class ArrMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<String> messages = new ArrayList<String>();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served by ArrayMessageServlet ").append(request.getContextPath());

		response.getWriter().println();

		for (String message : messages) {
			System.out.println(message);
			response.getWriter().println(message);
			response.getWriter().println("Get Called");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String message = request.getParameter("arrmessage");
		messages.add(message);
		doGet(request, response);
	}

}
