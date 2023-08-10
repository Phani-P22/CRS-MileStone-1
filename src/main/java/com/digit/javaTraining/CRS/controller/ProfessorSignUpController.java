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
		int yearsOfExperience = Integer.parseInt(req.getParameter("yearsOfExperience"));
		int courseID = Integer.parseInt(req.getParameter("courseID"));
		String emailID = req.getParameter("emailID");
		String phoneNumber = req.getParameter("phoneNumber");

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
			HttpSession session = req.getSession();
			session.setAttribute("title", "Student Apply");
			session.setAttribute("message", "Application Received!<br> Kindly wait for Admin to Approve");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("AppPrintMessage.jsp");
		} else {
			// failure
		}
	}
}
