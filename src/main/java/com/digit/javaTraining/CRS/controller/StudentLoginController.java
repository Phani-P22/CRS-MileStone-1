package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/studentLogin")
public class StudentLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		Student curStudent = Student.authenticateStudent(userName, password);
		if (curStudent != null) {
			// return to specific home
//			return;
			HttpSession session = req.getSession(true);
			session.setAttribute("curStudent", curStudent);

			resp.sendRedirect("/CRS/StudentHome.jsp");
			return;
		}

		curStudent = Student.authenticateStudentInRequestsTable(userName, password);
		if (curStudent != null) {
			// return to specific home
			HttpSession session = req.getSession(true);
			session.setAttribute("curStudent", curStudent);

			resp.sendRedirect("/CRS/StudentPendingHome.jsp");
			return;
//			return;
		}

		// error jsp
		resp.sendRedirect("/CRS/Failure.jsp");
	}
}
