package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/studentSignUp")
public class StudentSignUpController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String reEnterePassword = req.getParameter("reEnteredPassword");

		if (!password.equals(reEnterePassword)) {
			// return to failure
			// return
		}

		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String city = req.getParameter("city");
		int courseID = Integer.parseInt(req.getParameter("courseID"));
		String gender = req.getParameter("gender");
		String emailID = req.getParameter("emailID");
		String phoneNumber = req.getParameter("phoneNumber");

		Student curStudent = new Student();
		curStudent.setStudentName(name);
		curStudent.setAge(age);
		curStudent.setCity(city);
		curStudent.setCourseEnrolled(courseID);
		curStudent.setGender(gender);
		curStudent.setEmailID(emailID);
		curStudent.setPhoneNumber(phoneNumber);
		curStudent.setUserName(userName);
		curStudent.setPassword(password);
		
		boolean signUpStatus = Student.studentSignUp(curStudent);
		if (signUpStatus) {
			// success
			HttpSession session = req.getSession();
			session.setAttribute("title", "Student Apply");
			session.setAttribute("message", "Application Received!<br> Kindly wait for Admin to Approve");
			session.setAttribute("redirectLink", "StudentHome.jsp");
			resp.sendRedirect("index.html");
		} else {
			// failure
		}
	}
}
