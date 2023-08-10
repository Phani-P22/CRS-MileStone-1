package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/changeStudentPendingCourseEnrollment")
public class StudentPendingCourseChangeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int newCourseID = Integer.parseInt(req.getParameter("newCourseID"));
		// check valid?
		
		HttpSession session = req.getSession();
		Student curStudent = (Student) session.getAttribute("curStudent");
		
		Student.updateCourseIDForStudentInPending(curStudent, newCourseID);
	}
}
