package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.services.Service;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -2133730339858743837L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User client = new User();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		

		
		client.setUsername(username);
		client.setPw(password);
		
		client = new Service().loginUser(client);
		
		if(client != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", client);
			
			if(client.getUser_role_id() == 1) {
				resp.sendRedirect("teacherhome.html");
			}else{
				resp.sendRedirect("studenthome.html");
			}
		}else{
			resp.sendRedirect("login.html");
		}
		
		
	}
}
