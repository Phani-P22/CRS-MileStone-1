package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.CRS.model.Course;

@WebServlet("/addCourse")
public class AdminAddCourseController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseName = req.getParameter("courseName");
		String courseDescription = req.getParameter("courseDescription");
		int fee = Integer.parseInt(req.getParameter("fee"));
		int duration = Integer.parseInt(req.getParameter("durationInHrs"));
		
		Course curCourse = new Course();
		curCourse.setCourseName(courseName);
		curCourse.setDescription(courseDescription);
		curCourse.setFee(fee);
		curCourse.setDurationInHrs(duration);
		
		Course.addCourseToCourseTable(curCourse);
		resp.sendRedirect("/CRS/CourseAddSuccess.html");
	}
}
