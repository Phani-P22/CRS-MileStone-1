package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/professorLogin")
public class ProfessorLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String userName, password;
		try {
			userName = req.getParameter("userName");
			password = req.getParameter("password");
		} catch (Exception e) {
			session.setAttribute("title", "Professor LogIn Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor curProfessor = Professor.authenticateProfessor(userName, password);
		if (curProfessor != null) {
			HttpSession newSession = req.getSession(true);
			newSession.setAttribute("curProfessor", curProfessor);
			resp.sendRedirect("/CRS/ProfessorHome.jsp");
			return;
		}

		curProfessor = Professor.authenticateProfessorInRequestsTable(userName, password);
		if (curProfessor != null) {
			HttpSession newSession = req.getSession(true);
			newSession.setAttribute("curProfessor", curProfessor);
			resp.sendRedirect("/CRS/ProfessorPendingHome.jsp");
			return;
		}

		session.setAttribute("title", "Professor LogIn Failure!");
		session.setAttribute("message", "Invalid Credentials");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Failure.jsp");
		return;
	}
}
