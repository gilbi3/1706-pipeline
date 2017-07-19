package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.services.Service;
import com.revature.threads.EmailNewStudent;

public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 7308028664343626463L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		User new_kid = new User();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		new_kid.setUsername(username);
		new_kid.setPw(password);
		new_kid.setFirst_name(firstname);
		new_kid.setLast_name(lastname);
		new_kid.setUser_role_id(2);
		
		Service.registerUser(new_kid);
		
		Runnable email = new EmailNewStudent();
		Thread runnable = new Thread(email);
		runnable.setPriority(10);
		runnable.start();
		
		resp.sendRedirect("teacherhome.html");
	}
}
