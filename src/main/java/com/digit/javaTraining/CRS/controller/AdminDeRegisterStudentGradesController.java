package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/deRegisterStudentGrades")
public class AdminDeRegisterStudentGradesController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentID = Integer.parseInt(req.getParameter("studentID"));

		if (!Student.isValidStudentID(studentID)) {
			return;
		}

		Student curStudent = Student.getStudentFromStudentTableUsingID(studentID);

		Student.deRegisterStudentGrades(curStudent);
		resp.sendRedirect("/CRS/DeRegisterMarksSuccess.html");
	}
}
