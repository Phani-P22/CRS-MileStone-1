package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Course;
import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/removeStudent")
public class AdminRemoveStudentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		int curStudentID;
		try {
			curStudentID = Integer.parseInt(req.getParameter("studentID"));
		} catch (Exception e) {
			session.setAttribute("title", "Remove Student Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		boolean isValidStudentID = Student.isValidStudentID(curStudentID);
		if (!isValidStudentID) {
			session.setAttribute("title", "Remove Student Failure!");
			session.setAttribute("message", "Invalid StudentID");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Student.removeStudentFromTable(curStudentID);
		resp.sendRedirect("/CRS/StudentRemoveSuccess.html");
	}
}
