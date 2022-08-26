package com.fullcreative.sriramnsm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * Servlet implementation class DatastoreMessageServlet
 */
@WebServlet(name = "DatastoreMessageServlet", urlPatterns = { "/datastoremessages" })
public class DatastoreMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int count = 1;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served by DatastoreMessageServlet").append(request.getContextPath());

		response.getWriter().println();

		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Query query = new Query("Profiles");
			PreparedQuery preparedquery = datastore.prepare(query);

			for (Entity profile : preparedquery.asIterable()) {
				String id = profile.getProperty("Profile_ID").toString();
				String name = profile.getProperty("Name").toString();
				String dateofbirth = profile.getProperty("Date_of_Birth").toString();
				String phone = profile.getProperty("Phone_Number").toString();

				response.getWriter().println(id + "  " + name + "  " + dateofbirth + "  " + phone);
				count++;
		}
	} catch (Exception e) {
		System.out.println("Printing stack trace...");
		e.printStackTrace();
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String dateofbirth = request.getParameter("date");
		String phone = request.getParameter("phone");

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Entity entity = new Entity("Profiles", count);
		entity.setProperty("Profile_ID", count);
		entity.setProperty("Name", name);
		entity.setProperty("Date_of_Birth", dateofbirth);
		entity.setProperty("Phone_Number", phone);
		entity.setProperty("timestamp", System.currentTimeMillis());
		datastore.put(entity);

		response.sendRedirect("/datastoremessages");
	}

}
