package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Course;

@WebServlet("/removeCourse")
public class AdminRemoveCourseController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		int curCourseID;
		try {
			curCourseID = Integer.parseInt(req.getParameter("courseID"));
		} catch (Exception e) {
			session.setAttribute("title", "Remove Course Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		boolean isValidCourse = Course.isValidCourseID(curCourseID);
		if (!isValidCourse) {
			session.setAttribute("title", "Remove Course Failure!");
			session.setAttribute("message", "Invalid CourseID");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Course.deleteCourseFromCourseTableUsingID(curCourseID);
		resp.sendRedirect("/CRS/CourseDeleteSuccess.html");
	}
}
