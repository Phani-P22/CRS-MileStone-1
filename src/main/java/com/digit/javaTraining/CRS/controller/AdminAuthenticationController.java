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
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
				
		boolean isAdminAuthenticated = Admin.authAdminFromTable(userName, password);
		if (isAdminAuthenticated) {			
			resp.sendRedirect("/CRS/AdminHome.jsp");
		} else {
			// error msg and return to index.html
			resp.sendRedirect("/CRS/Failure.jsp");
		}
	}
}
