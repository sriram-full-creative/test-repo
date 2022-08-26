package com.fullcreative.sriramnsm;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hey"}
)
public class HelloAppEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
	 * @see HttpServlet#HttpServlet()
	 */

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    response.getWriter().print("Hello App Engine!\r\n");

  }

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	doGet(request, response);
}
}