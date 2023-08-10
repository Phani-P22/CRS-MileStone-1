package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.CRS.model.Course;

@WebServlet("/removeCourse")
public class AdminRemoveCourseController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int curCourseID = Integer.parseInt(req.getParameter("courseID"));

		boolean isValidCourse = Course.isValidCourseID(curCourseID);
		if (!isValidCourse) {
			// return error
		}

		Course.deleteCourseFromCourseTableUsingID(curCourseID);
		resp.sendRedirect("/CRS/CourseDeleteSuccess.html");
	}
}
