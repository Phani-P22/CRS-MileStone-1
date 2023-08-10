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

@WebServlet("/changeCourseEnrollmentProfessor")
public class ProfessorCourseChangeApplyController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int newCourseID = Integer.parseInt(req.getParameter("newCourseID"));

		HttpSession session = req.getSession();
		Professor curProfessor = (Professor) session.getAttribute("curProfessor");

		boolean isValidCourseID = Course.isValidCourseID(newCourseID);
		if (!isValidCourseID) {
			// do something
			return;
		}

		Professor.addCourseChangeRequestToProfCourseReqTable(curProfessor, newCourseID);
	}
}
