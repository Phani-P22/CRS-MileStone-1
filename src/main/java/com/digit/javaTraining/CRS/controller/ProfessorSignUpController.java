package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;

@WebServlet("/professorSignUp")
public class ProfessorSignUpController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String userName, password, reEnteredPassword, name, city, emailID, phoneNumber;
		int age, yearsOfExperience, courseID;
		try {
			userName = req.getParameter("userName");
			password = req.getParameter("password");
			reEnteredPassword = req.getParameter("reEnteredPassword");
			name = req.getParameter("name");
			age = Integer.parseInt(req.getParameter("age"));
			city = req.getParameter("city");
			yearsOfExperience = Integer.parseInt(req.getParameter("yearsOfExperience"));
			courseID = Integer.parseInt(req.getParameter("courseID"));
			emailID = req.getParameter("emailID");
			phoneNumber = req.getParameter("phoneNumber");
		} catch (Exception e) {
			session.setAttribute("title", "Professor SignUp Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		if (!password.equals(reEnteredPassword)) {
			session.setAttribute("title", "Professor SignUp Failure!");
			session.setAttribute("message", "Passwords Doesn't match");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor curProfessor = new Professor();
		curProfessor.setProfessorName(name);
		curProfessor.setAge(age);
		curProfessor.setCity(city);
		curProfessor.setYearsOfExpreience(yearsOfExperience);
		curProfessor.setCourseID(courseID);
		curProfessor.setEmailID(emailID);
		curProfessor.setPhoneNumber(phoneNumber);
		curProfessor.setUserName(userName);
		curProfessor.setPassword(password);

		boolean signUpStatus = Professor.professorSignUp(curProfessor);
		if (signUpStatus) {
			// success
			session.setAttribute("title", "Professor Apply");
			session.setAttribute("message", "Application Received!<br> Kindly wait for Admin to Approve");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("AppPrintMessage.jsp");
		} else {
			// failure
			session.setAttribute("title", "Professor SignUp Failure!");
			session.setAttribute("message", "Something Wrong!<br> Try Again Later");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
	}
}
