package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;

@WebServlet("/professorLogin")
public class ProfessorLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		Professor curProfessor = Professor.authenticateProfessor(userName, password);
		if (curProfessor != null) {
			// return to specific home
//			return;
			HttpSession session = req.getSession(true);
			session.setAttribute("curProfessor", curProfessor);
			
			resp.sendRedirect("/CRS/ProfessorHome.jsp");
			return;
		}
		
		curProfessor = Professor.authenticateProfessorInRequestsTable(userName, password);
		if (curProfessor != null) {
			// return to specific home
//			return;
			HttpSession session = req.getSession(true);
			session.setAttribute("curProfessor", curProfessor);
			
			resp.sendRedirect("/CRS/ProfessorPendingHome.jsp");
			return;
		}
		
		// error jsp
		resp.sendRedirect("/CRS/Failure.jsp");
	}
}
