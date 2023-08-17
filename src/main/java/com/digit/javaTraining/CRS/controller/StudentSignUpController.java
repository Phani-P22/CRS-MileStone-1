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
		HttpSession session = req.getSession();

		String userName;
		String password;
		String reEnterePassword;
		String name;
		int age;
		String city;
		int courseID;
		String gender;
		String emailID;
		String phoneNumber;

		try {
			userName = req.getParameter("userName");
			password = req.getParameter("password");
			reEnterePassword = req.getParameter("reEnteredPassword");
			name = req.getParameter("name");
			age = Integer.parseInt(req.getParameter("age"));
			city = req.getParameter("city");
			courseID = Integer.parseInt(req.getParameter("courseID"));
			gender = req.getParameter("gender");
			emailID = req.getParameter("emailID");
			phoneNumber = req.getParameter("phoneNumber");
		} catch (Exception e) {
			session.setAttribute("title", "Student SignUp Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		if (!password.equals(reEnterePassword)) {
			session.setAttribute("title", "Student SignUp Failure!");
			session.setAttribute("message", "Passwords Doesn't match");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

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
			session.setAttribute("title", "Student Application Success");
			session.setAttribute("message",
					"Application Received!<br> Kindly wait for Admin to Approve<br>SignIn to View Details");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("AppPrintMessage.jsp");
		} else {
			// failure
			session.setAttribute("title", "Student SignUp Failure!");
			session.setAttribute("message", "Something Wrong!<br> Try Again Later");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
	}
}
