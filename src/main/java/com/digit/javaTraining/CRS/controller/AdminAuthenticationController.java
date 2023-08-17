package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Admin;

@WebServlet("/adminAuth")
public class AdminAuthenticationController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String userName, password;
		try {
			userName = req.getParameter("userName");
			password = req.getParameter("password");
		} catch (Exception e) {
			session.setAttribute("title", "Authentication Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		

		boolean isAdminAuthenticated = Admin.authAdminFromTable(userName, password);
		if (isAdminAuthenticated) {
			resp.sendRedirect("/CRS/AdminHome.jsp");
			return;
		}
		
		session.setAttribute("title", "Authentication Failure!");
		session.setAttribute("message", "Invalid Credentials");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Failure.jsp");
	}
}
