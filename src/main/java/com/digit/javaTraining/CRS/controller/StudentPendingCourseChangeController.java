package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Course;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/changeStudentPendingCourseEnrollment")
public class StudentPendingCourseChangeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		int newCourseID;
		
		try {
			newCourseID = Integer.parseInt(req.getParameter("newCourseID"));			
		} catch (Exception e) {
			session.setAttribute("title", "Course Change Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "StudentPendingHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		if (!Course.isValidCourseID(newCourseID)) {
			session.setAttribute("title", "Course Change Failure!");
			session.setAttribute("message", "Invalid CourseID");
			session.setAttribute("redirectLink", "StudentPendingHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		Student curStudent = (Student) session.getAttribute("curStudent");
		if (curStudent == null) {
			session.setAttribute("title", "Change Course Failure!");
			session.setAttribute("message", "Invalid Session! Login Again");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		if (newCourseID == curStudent.getCourseEnrolled()) {
			session.setAttribute("title", "Change Course Application Failure!");
			session.setAttribute("message", "You are already enrolled to Course-" + newCourseID);
			session.setAttribute("redirectLink", "StudentPendingHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		Student.updateCourseIDForStudentInPending(curStudent, newCourseID);
		curStudent.setCourseEnrolled(newCourseID);
		session.setAttribute("curStudent", curStudent);
		
		session.setAttribute("title", "Student Course Change");
		session.setAttribute("message", "Course Changed Successfully!<br> Kindly wait for Admin to Approve");
		session.setAttribute("redirectLink", "StudentPendingHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
