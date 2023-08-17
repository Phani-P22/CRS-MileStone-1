package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/deRegisterStudentGrades")
public class AdminDeRegisterStudentGradesController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		int studentID;
		try {
			studentID = Integer.parseInt(req.getParameter("studentID"));
		} catch (Exception e) {
			session.setAttribute("title", "Remove Grades Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		if (!Student.isValidStudentID(studentID)) {
			session.setAttribute("title", "Remove Grades Failure!");
			session.setAttribute("message", "Invalid Student ID");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Student curStudent = Student.getStudentFromStudentTableUsingID(studentID);

		Student.deRegisterStudentGrades(curStudent);
		resp.sendRedirect("/CRS/DeRegisterMarksSuccess.html");
	}
}
