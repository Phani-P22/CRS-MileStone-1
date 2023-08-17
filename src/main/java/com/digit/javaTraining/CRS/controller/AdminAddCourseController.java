package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Course;

@WebServlet("/addCourse")
public class AdminAddCourseController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String courseName;
		String courseDescription;
		int fee;
		int duration;
		try {
			courseName = req.getParameter("courseName");
			courseDescription = req.getParameter("courseDescription");
			fee = Integer.parseInt(req.getParameter("fee"));
			duration = Integer.parseInt(req.getParameter("durationInHrs"));
		} catch (Exception e) {
			session.setAttribute("title", "Add Course Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Course curCourse = new Course();
		curCourse.setCourseName(courseName);
		curCourse.setDescription(courseDescription);
		curCourse.setFee(fee);
		curCourse.setDurationInHrs(duration);

		Course.addCourseToCourseTable(curCourse);
		resp.sendRedirect("/CRS/CourseAddSuccess.html");
	}
}
